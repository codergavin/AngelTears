package com.ruoyi.common.utils.msg.wxwork;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.ruoyi.common.utils.msg.wxwork.entity.group.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Gavin Li
 * @version 1.0
 * @group HummingBird
 * @date 2022/5/22 15:57
 * @desc 发送消息到群聊会话
 */
public class WxWorkSendGroupMsgUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(WxWorkSendGroupMsgUtil.class);
    public static void main(String[] args) {
        List<String> userList = new ArrayList<String>(){{
            add("licheng");
            add("SuiNing");
            add("15995474626");
            add("13962125783");
            add("15062440625");
        }};
//        String result = createGroupChat("企微群消息测试群","licheng",userList);
//        String result = createGroupChat("企微群消息测试群","licheng",userList,"titanwindoctopustest00001");
//        String result = sendGroupTextMessage("titanwindoctopustest00001","这是一条群消息测试");
//        String result = sendGroupImageMessage("titanwindoctopustest00001","3rI-_S-KIDSfI70PU71Bz0dk50nE-m2LmtxHgRnYOAYEQf77dBlX5vWoSfIPvZTF9");
//        String result = sendGroupImageMessageWithFile("titanwindoctopustest00001","D:\\server\\公司logo.png");
//        String result = sendGroupFileMessageWithFile("titanwindoctopustest00001","D:\\server\\生产计划导入模板_f59cbb1b-0a58-4927-b2d5-d760d406402c.xlsx");
        /*String result = sendGroupTextCardMessage("titanwindoctopustest00001","领奖通知","<div class=\"gray\">2022年5月20日</div> <div class=\"normal\">恭喜你们每人抽中iPhone 13一台，领奖码：SFHRTXFGDF</div><div class=\"highlight\">请于2022年10月1日前联系行政同事领取</div>",
                "http://www.baidu.com","更多");*/
//        String result = sendGroupTextMessage("titanwindoctopustest00001","标题：XXX评论了你的2022年5月的任务\n" +
//                "内容：【通过业务流程完成交互体验设计】的评论为：这是一项测试。\n<a href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=ww049c50c431070203&redirect_uri=http%3A%2F%2Fokr.titanwind.com.cn%3A9091%2Fperformance%2F%23%2Flogin%2Fpub%2Fuser%2Flogin&response_type=code&scope=snsapi_base&state=STATE'>点此进入绩效系统</a>");
        /*String result = sendGroupMarkdownMessage("titanwindoctopustest00001","`OTCA`新消息 \n" +
                "                                >标题：XXX评论了你的2022年5月的任务 \n" +
                "                                >内容：【通过业务流程完成交互体验设计】的评论为：这是一项测试。\n" +
                "                                > \n" +
                "                                >点击进入：[OTCA](https://open.weixin.qq.com/connect/oauth2/authorize?appid=ww049c50c431070203&redirect_uri=http%3A%2F%2Fthingworxtest.titanwind.com.cn%3A8902%2FThingworx%2FRuntime%2Findex.html%23%23master%3DTiTan.Lic.Test.Master%26mashup%3DTiTan.Lic.Test.PersonManage.Mashup%26__applyThemeName%3DTiTan.Lic.StyleTheme&response_type=code&scope=snsapi_base&state=STATE)");
*/
        String result = sendGroupMarkdownMessage("titanwindoctopustest00001","`ThingWorx`这个是一条测试消息\n" +
                "                                > \n" +
                "                                >点击进入：[ThingWorx](https://open.weixin.qq.com/connect/oauth2/authorize?appid=ww049c50c431070203&redirect_uri=http%3A%2F%2Fthingworxtest.titanwind.com.cn%3A8902%2FThingworx%2FRuntime%2Findex.html%23%23master%3DTiTan.Lic.Test.Master%26mashup%3DTiTan.Lic.Test.PersonManage.Mashup%26__applyThemeName%3DTiTan.Lic.StyleTheme&response_type=code&scope=snsapi_base&state=STATE)");
        System.out.println(result);
    }

    /**
     * 发送群消息文本消息
     * @param chatId 群ID
     * @param text 文本消息
     * @return
     */
    public static String sendGroupTextMessage(String chatId,String text){
        String accessToken = WxWorkSendMsgUtil.getAccessToken();
        WxWorkGroupTextMsg wxWorkGroupTextMsg = new WxWorkGroupTextMsg(chatId,WxWorkContant.WXWORK_MESSAGE_TYPE_TEXT,text);
        return sendGroupMessage(accessToken,JSON.toJSONString(wxWorkGroupTextMsg));
    }

    /**
     * 发送群消息图片消息
     * @param chatId 群ID
     * @param imageId 图片ID
     * @return
     */
    public static String sendGroupImageMessage(String chatId,String imageId){
        String accessToken = WxWorkSendMsgUtil.getAccessToken();
        WxWorkGroupImageMsg wxWorkGroupImageMsg = new WxWorkGroupImageMsg(chatId,WxWorkContant.WXWORK_MESSAGE_TYPE_IMAGE,imageId);
        return sendGroupMessage(accessToken,JSON.toJSONString(wxWorkGroupImageMsg));
    }

    /**
     * 发送群消息图片消息
     * @param chatId 群ID
     * @param filePath 图片路径
     * @return
     */
    public static String sendGroupImageMessageWithFile(String chatId,String filePath){
        String accessToken = WxWorkSendMsgUtil.getAccessToken();
        String mediaId = WxWorkSendMsgUtil.uploadImageFileTemp(accessToken,filePath);
        WxWorkGroupImageMsg wxWorkGroupImageMsg = new WxWorkGroupImageMsg(chatId,WxWorkContant.WXWORK_MESSAGE_TYPE_IMAGE,mediaId);
        return sendGroupMessage(accessToken,JSON.toJSONString(wxWorkGroupImageMsg));
    }

    /**
     * 发送群消息文件消息
     * @param chatId 群ID
     * @param fileId 图片ID
     * @return
     */
    public static String sendGroupFileMessage(String chatId,String fileId){
        String accessToken = WxWorkSendMsgUtil.getAccessToken();
        WxWorkGroupFileMsg wxWorkGroupFileMsg = new WxWorkGroupFileMsg(chatId,WxWorkContant.WXWORK_MESSAGE_TYPE_FILE,fileId);
        return sendGroupMessage(accessToken,JSON.toJSONString(wxWorkGroupFileMsg));
    }

    /**
     * 发送群消息文件消息
     * @param chatId 群ID
     * @param filePath 图片路径
     * @return
     */
    public static String sendGroupFileMessageWithFile(String chatId,String filePath){
        String accessToken = WxWorkSendMsgUtil.getAccessToken();
        String mediaId = WxWorkSendMsgUtil.uploadCommonFileTemp(accessToken,filePath);
        WxWorkGroupFileMsg wxWorkGroupFileMsg = new WxWorkGroupFileMsg(chatId,WxWorkContant.WXWORK_MESSAGE_TYPE_FILE,mediaId);
        return sendGroupMessage(accessToken,JSON.toJSONString(wxWorkGroupFileMsg));
    }

    /**
     * 发送企微文本卡片消息
     * @param chatId 群ID
     * @param message 文本消息
     * @return
     */
    public static String sendGroupTextCardMessage(String chatId,String message) {
        String accessToken = WxWorkSendMsgUtil.getAccessToken();
        WxWorkGroupTextCardMsg wxWorkGroupTextCardMsg = new WxWorkGroupTextCardMsg(chatId,WxWorkContant.WXWORK_MESSAGE_TYPE_TEXTCARD,message);

        return sendGroupMessage(accessToken,JSON.toJSONString(wxWorkGroupTextCardMsg));
    }

    /**
     * 发送企微文本卡片消息
     * @param chatId 群ID
     * @return
     */
    public static String sendGroupTextCardMessage(String chatId,String titile,String description,String url,String btntxt) {
        String accessToken = WxWorkSendMsgUtil.getAccessToken();
        WxWorkGroupTextCardMsg wxWorkGroupTextCardMsg = new WxWorkGroupTextCardMsg(chatId,WxWorkContant.WXWORK_MESSAGE_TYPE_TEXTCARD,titile,description,url,btntxt);

        return sendGroupMessage(accessToken,JSON.toJSONString(wxWorkGroupTextCardMsg));
    }

    /**
     * 发送markdown内容
     * @param chatId
     * @param message
     * @return
     */
    public static String sendGroupMarkdownMessage(String chatId,String message) {
        String accessToken = WxWorkSendMsgUtil.getAccessToken();
        WxWorkMarkdownMsg wxWorkGroupTextCardMsg = new WxWorkMarkdownMsg(chatId,WxWorkContant.WXWORK_MESSAGE_TYPE_MARKDOWN,message);

        return sendGroupMessage(accessToken,JSON.toJSONString(wxWorkGroupTextCardMsg));
    }

    /**
     * wrmCquBgAAF5Po8o_lF7D8M6zGZ8fcMg
     * 创建群聊会话
     * https://developer.work.weixin.qq.com/document/path/90245
     * 注意：刚创建的群，如果没有下发消息，在企业微信不会出现该群。
     * @param groupName 群名称
     * @param owner 群主
     * @param userList 用户列表
     * @return 返回群ID
     *
     */
    public static String createGroupChat(String groupName,String owner, List<String> userList) {
        String accessToken = WxWorkSendMsgUtil.getAccessToken();
        WxWorkGroup wxWorkGroup = new WxWorkGroup(groupName,owner,userList);

        String resp = HttpUtil.post(String.format(WxWorkContant.WXWORK_URL_GROUP_CREATE,accessToken),JSON.toJSONString(wxWorkGroup));

        Map<String, Object> map = JSON.parseObject(resp,Map.class);
        if (!"ok".equals(map.get("errmsg").toString())) {
            LOGGER.error(String.format("创建群失败，请求:%s，\n返回的结果%s。",JSON.toJSONString(wxWorkGroup),resp));
            return map.get("chatid").toString();
        } else {
            return map.get("chatid").toString();
        }
    }

    /**
     * 创建群聊会话
     * @param groupName
     * @param owner
     * @param userList
     * @param chatid
     * @return
     */
    public static String createGroupChat(String groupName,String owner, List<String> userList,String chatid) {
        String accessToken = WxWorkSendMsgUtil.getAccessToken();
        WxWorkGroup wxWorkGroup = new WxWorkGroup(groupName,owner,userList,chatid);

        String resp = HttpUtil.post(String.format(WxWorkContant.WXWORK_URL_GROUP_CREATE,accessToken),JSON.toJSONString(wxWorkGroup));

        Map<String, Object> map = JSON.parseObject(resp,Map.class);
        if (!"ok".equals(map.get("errmsg").toString())) {
            LOGGER.error(String.format("创建群失败，请求:%s，\n返回的结果%s。",JSON.toJSONString(wxWorkGroup),resp));
            return map.get("chatid").toString();
        } else {
            return map.get("chatid").toString();
        }
    }

    /**
     * 发送企微消息基类
     * @param accessToken
     * @param message
     * @return
     */
    private static String sendGroupMessage(String accessToken,String message) {
        String resp = HttpUtil.post(String.format(WxWorkContant.WXWORK_URL_SEND_GROUP_MESSAGE,accessToken),message);

        return WxWorkSendMsgUtil.buildResponseStr(resp,message);
    }
}
