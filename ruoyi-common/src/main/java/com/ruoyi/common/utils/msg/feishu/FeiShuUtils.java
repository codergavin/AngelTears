package com.ruoyi.common.utils.msg.feishu;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author Gavin Li
 * @version 1.0
 * @date 2021-07-29 16:32
 * @desc 飞书工具类
 */
public class FeiShuUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(FeiShuUtils.class);
    public static String APP_ID = "";
    public static String APP_SECRET = "";
    public static String VERIFICATION_TOKEN = "";

    /**登陆URL*/
    public static final String URL_LOGIN = "https://open.feishu.cn/open-apis/auth/v3/tenant_access_token/internal/";
    /**根据手机号或者邮箱或者userId的URL*/
    public static final String URL_GET_USER_ID = "https://open.feishu.cn/open-apis/user/v1/batch_get_id";
    /**发送消息*/
    public static final String URL_SEND_MSG = "https://open.feishu.cn/open-apis/im/v1/messages?receive_id_type=user_id";


    public static void main(String[] args) throws Exception {
        APP_ID = "cli_a1c95542fd389013";
        APP_SECRET = "RYxTYSKZy7fjAk9K0NpSBbdIR23dKJrQ";
        VERIFICATION_TOKEN = "rmykDcnJZY11jSctixusCeOHqLvWyxS1";
//        sendMessageToUserWithUserId("bac8efe7",String.format("审批类型【%s】下的审批流【%s】需要您审批，审批节点为：【%s】","调整申请","员工[赵兴]的调整申请","直属领导"));
//        sendMessageToUserWithUserId("bac8efe7",String.format("test"));

        System.out.println(sendMessageToUserWithOpenId("18248629158"));

    }

    /**
     * 获取用户ID
     * 返回样例：{"code":0,"data":{"mobile_users":{"18248629158":[{"open_id":"ou_48ed3a9fc9c7fb3c1464d2ca51c35a31","user_id":"bac8efe7"}]},"mobiles_not_exist":[]},"msg":"success"}
     *
     * @param phone
     * @throws IOException
     */
    public static String sendMessageToUserWithOpenId(String phone) throws IOException {
        String result = "";
        String token = getAccessToken();
        if (!StringUtils.isEmpty(token)) {
            String authorization = "Bearer " + token;

            result = HttpRequest.get(String.format(URL_GET_USER_ID + "?mobiles=%s",phone))
                    .header("Authorization",authorization)
                    .header("Content-Type","application/json; charset=utf-8")
                    .execute().body();
        }
        return result;
    }


    /**
     * 飞书发送个人消息
     * @param userId 用户ID（飞书获得的，存在redis）
     * @param msg 消息
     */
    public static void sendMessageToUserWithUserId(String userId,String msg) throws IOException {
        String token = getAccessToken();
        if (!StringUtils.isEmpty(token)) {
                String authorization = "Bearer " + token;
//                System.out.println(authorization);

            HashMap<String, Object> body = new HashMap<>();
            body.put("content", String.format("{\"text\":\"%s\"}",msg));
            body.put("msg_type", "text");
            body.put("receive_id",userId);

            String result = HttpRequest.post(URL_SEND_MSG)
                    .header("Authorization",authorization)
                    .header("Content-Type","application/json; charset=utf-8")
                    .body(JSON.toJSONString(body))
                    .execute().body();
            LOGGER.info(String.format("飞书消息发送结果：%s",result));
        }
    }

    /**
     * 通过手机或者邮件获取用户的userId
     * @param phone 手机
     * @param email 邮箱
     * @return
     */
    public static String getUserIdWithPhoneOrEmail(String phone,String email){
        String userId = "";
        String token = getAccessToken();
        if (StringUtils.isEmpty(token)) {
            return userId;
        }
        String authorization = "Bearer " + token;
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("mobiles", phone);
        paramMap.put("emails", email);
        String result = HttpRequest.get(URL_GET_USER_ID).header("Authorization",authorization).form(paramMap).execute().body();
        JSONObject jsonObj = JSON.parseObject(result);
        if (jsonObj.getIntValue("code") == 0) {
            JSONObject obj = jsonObj.getJSONObject("data").getJSONObject("mobile_users");
            JSONArray array = obj != null ? obj.getJSONArray(phone) : null;
            if (array != null && array.size() > 0) {
                JSONObject target = array.getJSONObject(0);
                userId = target.getString("user_id");
                return userId;
            } else {
                LOGGER.error(String.format("请求飞书的UserId失败，url:%s；phone:%s；email:%s；result:%s。",URL_GET_USER_ID,phone,email,result));
            }
        } else {
            LOGGER.error(String.format("请求飞书的UserId失败，url:%s；phone:%s；email:%s；result:%s。",URL_GET_USER_ID,phone,email,result));
        }
        return userId;
    }

    /**
     * 获取Token
     * @return
     */
    public static String getAccessToken(){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("app_id", APP_ID);
        paramMap.put("app_secret", APP_SECRET);

        String result = HttpUtil.post(URL_LOGIN, paramMap);
        JSONObject jsonObj = JSON.parseObject(result);
        if (jsonObj.getIntValue("code") == 0) {
            return jsonObj.getString("tenant_access_token");
        } else {
            LOGGER.error(String.format("请求飞书的TOKEN失败，url:%s；app_id:%s；app_secret:%s；result:%s。",URL_LOGIN,APP_ID,APP_SECRET,result));
            return "";
        }
    }
}
