package com.ruoyi.common.utils.hrms;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.ruoyi.common.utils.hrms.entity.*;
import com.ruoyi.common.utils.meo.entity.ContractDeliveryPlan;
import com.ruoyi.common.utils.meo.entity.Result;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Gavin Li
 * @version 1.0
 * @group HummingBird
 * @date 2022/7/5 9:07
 * @desc
 */
public class HrmsUtil {
    private static Logger LOGGER = LoggerFactory.getLogger("HrmsUtil");
    //企业ID
    private static String CORP_ID_STR = "360677fb29b34ed18d05fb775f2dde6d";
    //应用key
    private static String APP_KEY_STR = "6885624ed6f0474ea51b1bfffed74308";
    //应用Secret
    private static String APP_SECRET_STR = "1bf4781d837440b9867d353f77ca7f8c";

    //URL-获取Token
    private static String URL_TOKEN = "http://hrec.titanwind.com.cn:32070/forward_webfront/api/pti-oapi/token/get";
    //URL-获取部门
    private static String URL_ORG = "http://hrec.titanwind.com.cn:32070/forward_webfront/api/pti-oapi/v2/api/hr/workunit/query-simple?token=%s";
    //URL-获取成员
    private static String URL_PERSON = "http://hrec.titanwind.com.cn:32070/forward_webfront/api/pti-oapi/v2/api/tianshun/employee/query?token=%s";

    public static void main(String[] args) {
        String token = getToken();
        System.out.println(token);
        List<OrgEntity> orgList = getOrgList(token,null);
        System.out.println(JSON.toJSONString(orgList));
        List<String> unitCodeList = new ArrayList<>();
        unitCodeList.add("000147");
        unitCodeList.add("000155");
        List<EmployeeEntity> personList = getPersonList(token,unitCodeList);
        System.out.println(JSON.toJSONString(personList));
    }

    /**
     * 获取 人员的基本信息
     * @param token
     * @param unitCodeList 组织编码。
     * @return
     */
    public static List<EmployeeEntity> getPersonList(String token, List<String> unitCodeList){
        /*if (StringUtils.isEmpty(unitCode)) {
            LOGGER.error(String.format("获取人员的基本信息失败，组织编码：%s。",unitCode));
            return new ArrayList<>();
        }*/
        Map<String,Object> map = new HashMap<>();

        map.put("unitCodeList",unitCodeList);
        //页码，从1开始，表示第一页；不传默认表示第一页
        map.put("nowPageIndex",1);
        //分页大小；不传默认返回每页30条数据，最大不能超过2000
        map.put("pageSize",1000);
        String result = HttpUtil.post(String.format(URL_PERSON,token),JSON.toJSONString(map));
        ResultEntity resultEntity = JSON.parseObject(result, ResultEntity.class);
        if (resultEntity.getCode().intValue() == 0) {
            //List<EmployeeEntity> employeeList = JSON.parseObject(resultEntity.getData(),new TypeReference<List<EmployeeEntity>>(){});

            EmployeePageEntity pageEntity = JSON.parseObject(resultEntity.getData(), EmployeePageEntity.class);
            LOGGER.info(String.format("获取人员的基本信息，分页信息总条数：%s。分页信息总页数：%s。",String.valueOf(pageEntity.getTotalItem()),String.valueOf(pageEntity.getTotalPage())));
            return pageEntity.getList();
        } else {
            LOGGER.error(String.format("获取人员的基本信息失败，返回结果内容：%s。",result));
        }
        return new ArrayList<>();
    }

    /**
     * 获取 部门的组织架构
     * @param token
     * @param unitCodeList 组织编码的List，可以不传。
     * @return
     */
    public static List<OrgEntity> getOrgList(String token,List<String> unitCodeList){
        Map<String,Object> map = new HashMap<>();
        if (unitCodeList != null && unitCodeList.size() > 0) {
            map.put("unitCode",unitCodeList);
        }
        String result = HttpUtil.post(String.format(URL_ORG,token),JSON.toJSONString(map));
        ResultEntity resultEntity = JSON.parseObject(result, ResultEntity.class);
        if (resultEntity.getCode().intValue() == 0) {

            List<OrgEntity> orgEntityList = JSON.parseObject(resultEntity.getData(),new TypeReference<List<OrgEntity>>(){});
            return orgEntityList;
        } else {
            LOGGER.error(String.format("获取部门的组织架构失败，返回结果内容：%s。",result));
        }
        return new ArrayList<>();
    }

    /**
     * 获取Token
     * @return
     */
    public static String getToken(){
        Map<String,Object> map = new HashMap<>();
        map.put("corpId",CORP_ID_STR);
        map.put("appKey",APP_KEY_STR);
        map.put("appSecret",APP_SECRET_STR);
        String result = HttpUtil.post(URL_TOKEN,JSON.toJSONString(map));
        ResultEntity resultEntity = JSON.parseObject(result, ResultEntity.class);
        System.out.println(resultEntity);
        if (resultEntity.getCode().intValue() == 0) {
            TokenEntity tokenEntity = JSON.parseObject(resultEntity.getData(), TokenEntity.class);
            return tokenEntity.getToken();
        } else {
            LOGGER.error(String.format("获取Token失败，返回结果内容：%s。",result));
        }
        return "";
    }


}
