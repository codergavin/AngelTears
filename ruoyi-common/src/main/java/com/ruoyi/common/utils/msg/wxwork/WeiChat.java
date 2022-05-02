package com.ruoyi.common.utils.msg.wxwork;

/**
 * @author Gavin Li
 * @group CoderBean
 * @date 2022/1/6 11:43
 * @desc 企业微信管理后台：https://work.weixin.qq.com/wework_admin/frame#apps
 * 错误码查询：https://open.work.weixin.qq.com/devtool/query?e=81013
 */
public class WeiChat {
    public static void main(String[] args) {
        WeChatMsgSend swx = new WeChatMsgSend();
        try {
            String token = swx.getToken("ww19b1921d75b9a23d","f9iMFCTMqmVGOrvLaNxytGunHfMMZ9S0nJ-QC0a0Am0");
            String postdata = swx.createpostdata("LiCheng", "text",
                    1000002, "content","这是一条测试信息");
            String resp = swx.post("utf-8", WeChatMsgSend.CONTENT_TYPE,(new WeChatUrlData()).getSendMessage_Url(), postdata, token);
            System.out.println("获取到的token======>" + token);
            System.out.println("请求数据======>" + postdata);
            System.out.println("发送微信的响应数据======>" + resp);
        }catch (Exception e) {
            e.getStackTrace();

        }
    }
}
