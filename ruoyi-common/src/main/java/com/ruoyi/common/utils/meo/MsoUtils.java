package com.ruoyi.common.utils.meo;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.TypeReference;
import com.ruoyi.common.utils.meo.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Gavin Li
 * @version 1.0
 * @group HummingBird
 * @date 2022/6/30 15:40
 * @desc MSO工具类型
 */
public class MsoUtils {

    private static Logger LOGGER = LoggerFactory.getLogger("MsoUtils");

    // 认证类型；
    public static String GRANT_TYPE = "password";
    // 客户端 ID ；
    public static String CLIENT_ID = "cd7abd50bc1fc6f722445ccae5068eb9";
    // 客户端秘钥；
    public static String CLIENT_SECRET = "ea6afd63c512c0c21390fa2942b68960";
    // 回调地址；
    public static String REDIRECT_URI = "https://api-tencent.xiaoshouyi.com";
    public static String USERNAME = "it.service@titanwind.com.cn";
    public static String PASSWORD = "Ts@1234567897KzytJYP";
    public static String BASE_URL = "https://api-tencent.xiaoshouyi.com";

    public static void main(String[] args) {
        String token = getToken();
        System.out.println(token);
//        String project = queryProjectInfo(token,0,10);
//        System.out.println(project);
        //项目 - "内蒙古锡林郭勒盟上都风电项目"
        Project  project = queryProjectInfo(token,"内蒙古锡林郭勒盟上都风电项目");
//        Project  project = queryProjectInfo(token,"乌兰察布兴和县500MW风电项目");
//        System.out.println(project.toString());
        LOGGER.info(JSON.toJSONString(project, JSONWriter.Feature.WriteMapNullValue));
//        Account account = queryAccountInfo(token,1690281230369429L);
//        User user = queryUserInfo(token,1223141946737322L);
        //机型
//        Model model = queryCustomizeInfo(token,1690347809833686L);

        //合同
//        List<Contract> contractList = queryContractInfo(token,1214995356287684L);

        //通用选项集
//        List<GlobalPickOption> globalPickOptionList = queryGlobalPicks(token,"price_term__c");

//        queryContractInfo(token,0,10);
        // 合同交付批次
        // List<ContractDeliveryPlan> planList = queryContractDeliveryPlanInfo(token,"1378873187517167",0,10);
        LOGGER.info("操作完成");
    }

    /**
     * 获取项目信息
     * @param token
     * @return
     */
    public static Project queryProjectInfo(String token,String projectName) {
        String url = BASE_URL + String.format("/rest/data/v2/query?q=select id,opportunityName,accountId,proj_num__c,tower_machine__c,set_qty__c,tower_2__c__c,tower_2_qty__c,tower_3__c,tower_3_qty__c," +
                "tower_4__c,tower_4_qty__c,follower__c,country__c,province__c,address__c  from opportunity where opportunityName = \'%s\'  limit 0,20",projectName ) ;
        String result = HttpRequest.get(url).header("Authorization", token).execute().body();
        LOGGER.info(result);
        Result resultClass = JSON.parseObject(result, Result.class);
        if (resultClass != null && resultClass.getCode().intValue() == 200) {
            ResultRecords resultRecordsClass = JSON.parseObject(resultClass.getResult(), ResultRecords.class);
            List<Project> changeList = JSON.parseObject(resultRecordsClass.getRecords(),new TypeReference<List<Project>>(){});
            //项目位置-国家
            List<GlobalPickOption> countryOptionList = queryGlobalPicks(token,"country__c");
            Map<Integer,List<GlobalPickOption>> keyAndCountryOptionList = countryOptionList.stream().collect(Collectors.groupingBy(GlobalPickOption::getOptionCode));
            //项目位置-省份
            List<GlobalPickOption> provinceoptionList = queryGlobalPicks(token,"province");
            Map<Integer,List<GlobalPickOption>> keyAndProvinceoptionList = provinceoptionList.stream().collect(Collectors.groupingBy(GlobalPickOption::getOptionCode));
            if (changeList != null && changeList.size() > 0) {
                Project project = changeList.get(0);
                //客户名称
                if (project.getAccountId() != null) {
                    Account account = queryAccountInfo(token, project.getAccountId());
                    project.setAccountName(account == null ? "" : account.getAccountName());
                }
                //机型1

                if (project.getTower_machine__c() != null) {
                    Model model1 = queryCustomizeInfo(token,project.getTower_machine__c());
                    project.setTower_machine__c_str(model1.getName());
                }
                //机型2
                if (project.getTower_2__c__c() != null) {
                    Model model1 = queryCustomizeInfo(token,project.getTower_2__c__c());
                    project.setTower_2__c__c_str(model1.getName());
                }
                //机型3
                if (project.getTower_3__c() != null) {
                    Model model1 = queryCustomizeInfo(token,project.getTower_3__c());
                    project.setTower_3__c_str(model1.getName());
                }
                //机型4
                if (project.getTower_4__c() != null) {
                    Model model1 = queryCustomizeInfo(token,project.getTower_4__c());
                    project.setTower_4__c_str(model1.getName());
                }
                //跟进人
                if (project.getFollower__c() != null) {
                    User user = queryUserInfo(token, project.getFollower__c());
                    project.setFollower__c_str(user == null ? "" : user.getName());
                }
                //项目位置-国家
                if (project.getCountry__c() != null) {
                    project.setCountry__c_str(keyAndCountryOptionList.containsKey(project.getCountry__c()) ? keyAndCountryOptionList.get(project.getCountry__c()).get(0).getOptionLabel(): "");
                }
                //项目位置-省份
                if (project.getProvince__c() != null) {
                    project.setProvince__c_str(keyAndProvinceoptionList.containsKey(project.getProvince__c()) ? keyAndProvinceoptionList.get(project.getProvince__c()).get(0).getOptionLabel(): "");
                }
                //合同
                List<Contract> contractList = queryContractInfo(token,project.getId());
                project.setContractList(contractList);


                return project;
            }
        } else {
            LOGGER.error(String.format("访问出错，请排查问题。返回结果：%s",result));
            return null;
        }
        return null;

    }

    /**
     * 获取机型
     * @param token
     * @return
     */
    public static Model queryCustomizeInfo(String token,Long modelId ) {
        List<Project> resultList = new ArrayList<>();
        String url = BASE_URL + String.format("/rest/data/v2/query?q=select id,name  from prod_model__c where id =%s   limit 0,1", modelId) ;
        String result = HttpRequest.get(url).header("Authorization", token).execute().body();
        LOGGER.info(result);
        Result resultClass = JSON.parseObject(result, Result.class);
        if (resultClass != null && resultClass.getCode().intValue() == 200) {
            ResultRecords resultRecordsClass = JSON.parseObject(resultClass.getResult(), ResultRecords.class);
            List<Model> changeList = JSON.parseObject(resultRecordsClass.getRecords(),new TypeReference<List<Model>>(){});
            if (changeList != null && changeList.size() > 0) {
                return changeList.get(0);
            }
        } else {
            LOGGER.error(String.format("访问出错，请排查问题。返回结果：%s",result));
            return null;
        }
        return null;
    }

    /**
     * 获取客户信息
     * @param token
     * @return
     */
    public static Account queryAccountInfo(String token,Long accountId) {
        List<Account> resultList = new ArrayList<>();
        String url = BASE_URL + String.format("/rest/data/v2/query?q=select id,accountName  from account where id = %s limit 0,1",String.valueOf(accountId)) ;
        String result = HttpRequest.get(url).header("Authorization", token).execute().body();
        LOGGER.info(result);
        Result resultClass = JSON.parseObject(result, Result.class);
        if (resultClass != null && resultClass.getCode().intValue() == 200) {
            ResultRecords resultRecordsClass = JSON.parseObject(resultClass.getResult(), ResultRecords.class);
            List<Account> changeList = JSON.parseObject(resultRecordsClass.getRecords(),new TypeReference<List<Account>>(){});
            if (changeList != null && changeList.size() > 0) {
                return changeList.get(0);
            }
        } else {
            LOGGER.error(String.format("访问出错，请排查问题。返回结果：%s",result));
            return null;
        }
        return null;
    }

    /**
     * 获取用户
     * @param token
     * @return
     */
    public static User queryUserInfo(String token,Long userId) {
        List<User> resultList = new ArrayList<>();
        String url = BASE_URL + String.format("/rest/data/v2/query?q=select id,name  from user where id = %s limit 0,1",String.valueOf(userId)) ;
        String result = HttpRequest.get(url).header("Authorization", token).execute().body();
        LOGGER.info(result);
        Result resultClass = JSON.parseObject(result, Result.class);
        if (resultClass != null && resultClass.getCode().intValue() == 200) {
            ResultRecords resultRecordsClass = JSON.parseObject(resultClass.getResult(), ResultRecords.class);
            List<User> changeList = JSON.parseObject(resultRecordsClass.getRecords(),new TypeReference<List<User>>(){});
            if (changeList != null && changeList.size() > 0) {
                return changeList.get(0);
            }
        } else {
            LOGGER.error(String.format("访问出错，请排查问题。返回结果：%s",result));
            return null;
        }
        return null;
    }

    /**
     * 获取合同信息
     * @param token
     * @return
     */
    public static List<Contract> queryContractInfo(String token,Long projectId) {
        List<Contract> resultList = new ArrayList<>();
        String url = BASE_URL + String.format("/rest/data/v2/query?q=select id,opportunityId,title,price_term__c,del_addr__c  from contract where opportunityId = %s ",String.valueOf(projectId)) ;
        String result = HttpRequest.get(url).header("Authorization", token).execute().body();
        LOGGER.info(result);
        Result resultClass = JSON.parseObject(result, Result.class);
        if (resultClass != null && resultClass.getCode().intValue() == 200) {
            List<GlobalPickOption> optionList = queryGlobalPicks(token,"price_term__c");
            Map<Integer,List<GlobalPickOption>> keyAndOptionList = optionList.stream().collect(Collectors.groupingBy(GlobalPickOption::getOptionCode));

            ResultRecords resultRecordsClass = JSON.parseObject(resultClass.getResult(), ResultRecords.class);
            List<Contract> changeList = JSON.parseObject(resultRecordsClass.getRecords(),new TypeReference<List<Contract>>(){});
            for (Contract contract : changeList) {
                contract.setPrice_term__c_str(keyAndOptionList.containsKey(contract.getPrice_term__c()) ? keyAndOptionList.get(contract.getPrice_term__c()).get(0).getOptionLabel(): "");
                contract.setContractDeliveryPlanList(queryContractDeliveryPlanInfo(token,contract.getId()));
            }
            resultList.addAll(changeList);
        } else {
            LOGGER.error(String.format("访问出错，请排查问题。返回结果：%s",result));
            return null;
        }
        return resultList;
    }

    /**
     * 根据合同编号获取合同交付计划信息
     * private Long id;
     * private Integer bat_num__c;批次
     * private Integer set_qty__c;套数
     * private Long bat_deliv_date__c;批次交付日期
     * private String desc__c;批次描述
     * private Long customItem5__c;合同 ID
     * @param token
     * @return
     */
    public static List<ContractDeliveryPlan> queryContractDeliveryPlanInfo(String token,Long contract) {
        List<ContractDeliveryPlan> resultList = new ArrayList<>();
        String url = BASE_URL + String.format("/rest/data/v2/query?q=select id,set_qty__c,bat_deliv_date__c,customItem5__c  from customEntity20__c where customItem5__c = %s ",String.valueOf(contract)) ;
        String result = HttpRequest.get(url).header("Authorization", token).execute().body();
        LOGGER.info(result);
        Result resultClass = JSON.parseObject(result, Result.class);
        if (resultClass != null && resultClass.getCode().intValue() == 200) {
            ResultRecords resultRecordsClass = JSON.parseObject(resultClass.getResult(), ResultRecords.class);
            List<ContractDeliveryPlan> contractDeliveryPlanList = JSON.parseObject(resultRecordsClass.getRecords(),new TypeReference<List<ContractDeliveryPlan>>(){});
            /*for (ContractDeliveryPlan plan : contractDeliveryPlanList) {
                LOGGER.info(plan.toString());
            }*/
            resultList.addAll(contractDeliveryPlanList);
        } else {
            LOGGER.error(String.format("访问出错，请排查问题。返回结果：%s",result));
            return null;
        }
        return resultList;
    }

    /**
     * 获取通用选项集
     * 贸易术语：price_term__c
     * 项目位置（省份）：province__c
     * 项目位置（国家）：country__c
     * @param token
     * @return
     */
    public static List<GlobalPickOption> queryGlobalPicks(String token,String apiKey) {
        List<GlobalPickOption> resultList = new ArrayList<>();
        String url = BASE_URL + String.format("/rest/metadata/v2.0/settings/globalPicks/%s",apiKey) ;
        String result = HttpRequest.get(url).header("Authorization", token).execute().body();
        LOGGER.info(result);
        Result resultClass = JSON.parseObject(result, Result.class);
        if (resultClass != null && resultClass.getCode().intValue() == 0) {
            ResultRecords resultRecordsClass = JSON.parseObject(resultClass.getData(), ResultRecords.class);
            GlobalPickOptionRecord optionRecord = JSON.parseObject(resultRecordsClass.getRecords(), GlobalPickOptionRecord.class);
            List<GlobalPickOption> changeList = JSON.parseObject(optionRecord.getPickOption(),new TypeReference<List<GlobalPickOption>>(){});
            resultList.addAll(changeList);
        } else {
            LOGGER.error(String.format("访问出错，请排查问题。返回结果：%s",result));
            return null;
        }

        return resultList;
    }

    /**
     * 获取Token内容
     * @return
     */
    public static String getToken() {
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("grant_type",GRANT_TYPE);
        paramMap.put("client_id",CLIENT_ID);
        paramMap.put("client_secret",CLIENT_SECRET);
        paramMap.put("redirect_uri",REDIRECT_URI);
        paramMap.put("username",USERNAME);
        paramMap.put("password",PASSWORD);
        String url = BASE_URL + "/oauth2/token";
        String result = HttpRequest.post(url).header("content-type", "application/x-www-form-urlencoded").form(paramMap).execute().body();
        LOGGER.info(String.format("响应结果：%s",result));
        JSONObject jsonObject = JSONUtil.parseObj(result);
        String token = String.format("%s %s",jsonObject.getStr("token_type"),jsonObject.getStr("access_token"));
        return token;
    }
}
