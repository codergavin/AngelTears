package com.ruoyi.common.utils.msg.wxwork;

/**
 * @author Gavin Li
 * @version 1.0
 * @group HummingBird
 * @date 2022/5/21 16:34
 * @desc 企业微信API 常量类
 */
public class WxWorkContant {
    /** 企业ID */
    public static String WXWORK_CORPID_STR = "ww049c50c431070203";
    /** 应用的ID */
    public static Integer WXWORK_APP_ID_INT = 1000091;
    /** 应用的凭证密钥 */
    public static String WXWORK_APP_SECRET_STR = "H4jvoa0Ajk3-rbz_Sy-pngc-zlSa8bGcha97VqlpiJI";

    /*** =================== 企业微信URL =================== ***/
    public static String WXWORK_URL_BASE = "https://qyapi.weixin.qq.com/cgi-bin";
    // 获取Token
    public static String WXWORK_URL_GETTOKEN = WXWORK_URL_BASE + "/gettoken?corpid=%s&corpsecret=%s";
    // 发送消息
    public static String WXWORK_URL_SEND_MESSAGE = WXWORK_URL_BASE + "/message/send?access_token=%s";
    // 发送群消息
    public static String WXWORK_URL_SEND_GROUP_MESSAGE = WXWORK_URL_BASE + "/appchat/send?access_token=%s";
    // 群创建
    public static String WXWORK_URL_GROUP_CREATE = WXWORK_URL_BASE + "/appchat/create?access_token=%s";
    //上传临时素材
    public static String WXWORK_URL_MEDIA_UPLOAD = WXWORK_URL_BASE + "/media/upload?access_token=%s&type=%s";

    /*** =================== 企业微信URL =================== ***/
    /** 文本消息 */
    public static String WXWORK_MESSAGE_TYPE_TEXT = "text";
    /** 图片消息 */
    public static String WXWORK_MESSAGE_TYPE_IMAGE = "image";
    /** 语音消息 */
    public static String WXWORK_MESSAGE_TYPE_VOICE = "voice";
    /** 视频消息 */
    public static String WXWORK_MESSAGE_TYPE_VIDEO = "video";
    /** 文件消息 */
    public static String WXWORK_MESSAGE_TYPE_FILE = "file";
    /** 文本卡片消息 */
    public static String WXWORK_MESSAGE_TYPE_TEXTCARD = "textcard";
    /** 图文消息 */
    public static String WXWORK_MESSAGE_TYPE_NEWS = "news";
    /** 图文消息（mpnews） */
    public static String WXWORK_MESSAGE_TYPE_MPNEWS = "mpnews";
    /** markdown消息 */
    public static String WXWORK_MESSAGE_TYPE_MARKDOWN = "markdown";
    /** 小程序通知消息 */
    public static String WXWORK_MESSAGE_TYPE_MINIPROGRAM_NOTICE= "miniprogram_notice";


}
