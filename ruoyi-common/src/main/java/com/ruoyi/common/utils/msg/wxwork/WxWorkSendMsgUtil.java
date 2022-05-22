package com.ruoyi.common.utils.msg.wxwork;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.ruoyi.common.utils.msg.wxwork.entity.msg.WxWorkFileMsg;
import com.ruoyi.common.utils.msg.wxwork.entity.msg.WxWorkImageMsg;
import com.ruoyi.common.utils.msg.wxwork.entity.msg.WxWorkTextCardMsg;
import com.ruoyi.common.utils.msg.wxwork.entity.msg.WxWorkTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * @author Gavin Li
 * @version 1.0
 * @group HummingBird
 * @date 2022/5/21 15:54
 * @desc
 */
public class WxWorkSendMsgUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(WxWorkSendMsgUtil.class);

    public static void main(String[] args) {

//        System.out.println(getAccessToken());
//        String accessToken = getAccessToken();
//        String result = sendTextMessage("licheng","这是一条测试消息。");
//        String result = sendImageMessage("licheng|15995474626","3rI-_S-KIDSfI70PU71Bz0dk50nE-m2LmtxHgRnYOAYEQf77dBlX5vWoSfIPvZTF9");
//        String result = uploadImageFileTemp("D:\\server\\wx_file_upload.png");
//        String result = sendImageMessage("licheng",uploadImageFileTemp("D:\\server\\wx_file_upload.png"));
//        String result = sendImageMessageWithFile("licheng","D:\\server\\wx_file_upload.png");
//        String result = uploadCommonFileTemp("D:\\server\\生产计划导入模板_f59cbb1b-0a58-4927-b2d5-d760d406402c.xlsx");//3w4HubPgx-qxjwFroUz8bWlTLc_7ZxTAlvUsaWCxalXt05MH7F-E3qCZTaDlOlDFT
//        String result = sendFileMessageWithFile("licheng","D:\\server\\生产计划导入模板_f59cbb1b-0a58-4927-b2d5-d760d406402c.xlsx");
//        String result = sendFileMessage("licheng","3w4HubPgx-qxjwFroUz8bWlTLc_7ZxTAlvUsaWCxalXt05MH7F-E3qCZTaDlOlDFT");
//        String result = sendFileMessageWithFile("licheng","D:\\server\\生产计划导入模板_f59cbb1b-0a58-4927-b2d5-d760d406402c.xlsx");
        String result = sendTextCardMessage("licheng","领奖通知","<div class=\"gray\">2016年9月26日</div> <div class=\"normal\">恭喜你抽中iPhone 7一台，领奖码：xxxx</div><div class=\"highlight\">请于2016年10月10日前联系行政同事领取</div>",
                "http://www.baidu.com","更多");
        System.out.println(result);
    }

    /**
     * 发送企微文本消息
     * https://developer.work.weixin.qq.com/document/path/90236
     * @param userIds 接收者，多人用|分隔开
     * @param message 文本消息
     * @return
     */
    public static String sendTextMessage(String userIds,String message) {
        String accessToken = getAccessToken();
        WxWorkTextMessage wxMessage = new WxWorkTextMessage(WxWorkContant.WXWORK_APP_ID_INT,WxWorkContant.WXWORK_MESSAGE_TYPE_TEXT,userIds,message);

        return sendMessage(accessToken,JSON.toJSONString(wxMessage));
    }

    /**
     * 发送企微图片消息
     * @param userIds 接收者，多人用|分隔开
     * @param mediaId 文件ID
     * @return
     */
    public static String sendImageMessage(String userIds,String mediaId) {
        String accessToken = getAccessToken();

        return sendImageMessageBase(accessToken,userIds,mediaId);
    }

    /**
     * 发送企微图片消息
     * @param userIds 接收者，多人用|分隔开
     * @param filePath 文件路径
     * @return
     */
    public static String sendImageMessageWithFile(String userIds,String filePath) {
        String accessToken = getAccessToken();

        String mediaId = uploadImageFileTemp(accessToken,filePath);

        return sendImageMessageBase(accessToken,userIds,mediaId);
    }

    /**
     * 发送企微图片消息
     * @param accessToken
     * @param userIds
     * @param mediaId
     * @return
     */
    private static String sendImageMessageBase(String accessToken,String userIds,String mediaId) {
        WxWorkImageMsg wxImageMsg = new WxWorkImageMsg(WxWorkContant.WXWORK_APP_ID_INT,WxWorkContant.WXWORK_MESSAGE_TYPE_IMAGE,userIds,mediaId);

        return sendMessage(accessToken,JSON.toJSONString(wxImageMsg));
    }

    /**
     * 发送企微文件消息
     * @param userIds 接收者，多人用|分隔开
     * @param mediaId 文件ID
     * @return
     */
    public static String sendFileMessage(String userIds,String mediaId) {
        String accessToken = getAccessToken();

        return sendFileMessageBase(accessToken,userIds,mediaId);
    }

    /**
     * 发送企微文件消息
     * @param userIds 接收者，多人用|分隔开
     * @param filePath 文件路径
     * @return
     */
    public static String sendFileMessageWithFile(String userIds,String filePath) {
        String accessToken = getAccessToken();

        String mediaId = uploadCommonFileTemp(accessToken,filePath);

        return sendFileMessageBase(accessToken,userIds,mediaId);
    }

    /**
     * 发送企微文件消息
     * @param accessToken
     * @param userIds
     * @param mediaId
     * @return
     */
    private static String sendFileMessageBase(String accessToken,String userIds,String mediaId) {
        WxWorkFileMsg wxWorkFileMsg = new WxWorkFileMsg(WxWorkContant.WXWORK_APP_ID_INT,WxWorkContant.WXWORK_MESSAGE_TYPE_FILE,userIds,mediaId);

        return sendMessage(accessToken,JSON.toJSONString(wxWorkFileMsg));
    }


    /**
     * 发送企微文本卡片消息
     * @param userIds 接收者，多人用|分隔开
     * @param message 文本消息
     * @return
     */
    public static String sendTextCardMessage(String userIds,String message) {
        String accessToken = getAccessToken();
        WxWorkTextCardMsg wxTextCardMsg = new WxWorkTextCardMsg(WxWorkContant.WXWORK_APP_ID_INT,WxWorkContant.WXWORK_MESSAGE_TYPE_TEXTCARD,userIds,message);

        return sendMessage(accessToken,JSON.toJSONString(wxTextCardMsg));
    }

    public static String sendTextCardMessage(String userIds,String titile,String description,String url,String btntxt) {
        String accessToken = getAccessToken();
        WxWorkTextCardMsg wxTextCardMsg = new WxWorkTextCardMsg(WxWorkContant.WXWORK_APP_ID_INT,WxWorkContant.WXWORK_MESSAGE_TYPE_TEXTCARD,userIds,titile,description,url,btntxt);

        return sendMessage(accessToken,JSON.toJSONString(wxTextCardMsg));
    }

    /**
     * 上传临时图片素材
     */
    public static String uploadImageFileTemp(String filePath) {
        String accessToken = getAccessToken();
        return uploadImageFileTemp(accessToken,filePath);
    }

    /**
     * 上传临时图片素材
     */
    public static String uploadImageFileTemp(String accessToken,String filePath) {
        return uploadFileTemp(String.format(WxWorkContant.WXWORK_URL_MEDIA_UPLOAD,
                accessToken,WxWorkContant.WXWORK_MESSAGE_TYPE_IMAGE),new File(filePath));
    }

    /**
     * 上传临时音频素材
     */
    public static String uploadVoiceFileTemp(String filePath) {
        String accessToken = getAccessToken();
        return uploadVoiceFileTemp(accessToken,filePath);
    }

    /**
     * 上传临时音频素材
     */
    public static String uploadVoiceFileTemp(String accessToken,String filePath) {
        return uploadFileTemp(String.format(WxWorkContant.WXWORK_URL_MEDIA_UPLOAD,
                accessToken,WxWorkContant.WXWORK_MESSAGE_TYPE_VIDEO),new File(filePath));
    }

    /**
     * 上传临时视频素材
     */
    public static String uploadVideoFileTemp(String filePath) {
        String accessToken = getAccessToken();
        return uploadVideoFileTemp(accessToken,filePath);
    }

    /**
     * 上传临时视频素材
     */
    public static String uploadVideoFileTemp(String accessToken,String filePath) {
        return uploadFileTemp(String.format(WxWorkContant.WXWORK_URL_MEDIA_UPLOAD,
                accessToken,WxWorkContant.WXWORK_MESSAGE_TYPE_VIDEO),new File(filePath));
    }

    /**
     * 上传临时普通文件素材
     */
    public static String uploadCommonFileTemp(String filePath) {
        String accessToken = getAccessToken();
        return uploadCommonFileTemp(accessToken,filePath);
    }

    /**
     * 上传临时普通文件素材
     */
    public static String uploadCommonFileTemp(String accessToken,String filePath) {
        return uploadFileTemp(String.format(WxWorkContant.WXWORK_URL_MEDIA_UPLOAD,
                accessToken,WxWorkContant.WXWORK_MESSAGE_TYPE_FILE),new File(filePath));
    }



    /**
     * 上传临时素材(基础方法，外部不调用)
     * 素材上传得到media_id，该media_id仅三天内有效
     * @param requestUrl  微信上传临时素材的接口url
     * @param file    要上传的文件
     *                所有文件size必须大于5个字节
     *                  图片（image）：10MB，支持JPG,PNG格式
     *                  语音（voice） ：2MB，播放长度不超过60s，仅支持AMR格式
     *                  视频（video） ：10MB，支持MP4格式
     *                  普通文件（file）：20MB
     * @return String  上传成功后，微信服务器返回的消息
     */
    private static String uploadFileTemp(String requestUrl, File file) {
        StringBuffer buffer = new StringBuffer();

        try{
            //1.建立连接
            URL url = new URL(requestUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();  //打开链接

            //1.1输入输出设置
            httpUrlConn.setDoInput(true);
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setUseCaches(false); // post方式不能使用缓存
            //1.2设置请求头信息
            httpUrlConn.setRequestProperty("Connection", "Keep-Alive");
            httpUrlConn.setRequestProperty("Charset", "UTF-8");
            //1.3设置边界
            String BOUNDARY = "----------" + System.currentTimeMillis();
            httpUrlConn.setRequestProperty("Content-Type","multipart/form-data; boundary="+ BOUNDARY);

            // 请求正文信息
            // 第一部分：
            //2.将文件头输出到微信服务器
            StringBuilder sb = new StringBuilder();
            sb.append("--"); // 必须多两道线
            sb.append(BOUNDARY);
            sb.append("\r\n");
            sb.append("Content-Disposition: form-data;name=\"media\";filelength=\"" + file.length()
                    + "\";filename=\""+ file.getName() + "\"\r\n");
            sb.append("Content-Type:application/octet-stream\r\n\r\n");
            byte[] head = sb.toString().getBytes("utf-8");
            // 获得输出流
            OutputStream outputStream = new DataOutputStream(httpUrlConn.getOutputStream());
            // 将表头写入输出流中：输出表头
            outputStream.write(head);

            //3.将文件正文部分输出到微信服务器
            // 把文件以流文件的方式 写入到微信服务器中
            DataInputStream in = new DataInputStream(new FileInputStream(file));
            int bytes = 0;
            byte[] bufferOut = new byte[1024];
            while ((bytes = in.read(bufferOut)) != -1) {
                outputStream.write(bufferOut, 0, bytes);
            }
            in.close();
            //4.将结尾部分输出到微信服务器
            byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线
            outputStream.write(foot);
            outputStream.flush();
            outputStream.close();


            //5.将微信服务器返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();


        } catch (IOException e) {
            LOGGER.error("发送POST请求出现异常！" + e);
            e.printStackTrace();
        }
        Map<String, Object> map = JSON.parseObject(buffer.toString(),Map.class);
        if (!"ok".equals(map.get("errmsg").toString())) {
            LOGGER.error(String.format("上传文件失败，返回的结果%s。",buffer.toString()));
            return "";
        } else {
            return map.get("media_id").toString();
        }

    }

    /**
     * 获取企微AccessToken
     * https://developer.work.weixin.qq.com/document/path/91039
     * @return
     */
    protected static String getAccessToken() {
        return getAccessToken(WxWorkContant.WXWORK_CORPID_STR, WxWorkContant.WXWORK_APP_SECRET_STR);
    }

    /**
     * 获取企微AccessToken
     * @param corpid 企业ID
     * @param corpsecret 应用的凭证密钥
     * @return
     */
    protected static String getAccessToken(String corpid, String corpsecret) {
        String resp = HttpUtil.get(String.format(WxWorkContant.WXWORK_URL_GETTOKEN,corpid,corpsecret));
        Map<String, Object> map = JSON.parseObject(resp,Map.class);
        return map.get("access_token").toString();
    }

    /**
     * 发送企微消息基类
     * @param accessToken
     * @param message
     * @return
     */
    private static String sendMessage(String accessToken,String message) {
        String resp = HttpUtil.post(String.format(WxWorkContant.WXWORK_URL_SEND_MESSAGE,accessToken),message);

        return buildResponseStr(resp,message);
    }

    /**
     * 处理返回结果
     * @param resp response
     * @return
     */
    public static String buildResponseStr(String resp,String message) {
        Map<String, Object> map = JSON.parseObject(resp,Map.class);
        if (!"ok".equals(map.get("errmsg").toString())) {
            LOGGER.error(String.format("请求失败的消息:%s，\n返回的结果%s。",JSON.toJSONString(message),resp));
        }
        return map.get("errmsg").toString();
    }

}
