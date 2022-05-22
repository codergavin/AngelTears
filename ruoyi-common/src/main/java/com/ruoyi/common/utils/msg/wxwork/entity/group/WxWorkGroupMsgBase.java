package com.ruoyi.common.utils.msg.wxwork.entity.group;

/**
 * @author Gavin Li
 * @version 1.0
 * @group HummingBird
 * @date 2022/5/22 16:33
 * @desc 群消息基类
 * https://developer.work.weixin.qq.com/document/path/90248
 */
public class WxWorkGroupMsgBase {
    private String chatid;
    private String msgtype;
    private Integer safe = 0;

    public String getChatid() {
        return chatid;
    }

    public void setChatid(String chatid) {
        this.chatid = chatid;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public Integer getSafe() {
        return safe;
    }

    public void setSafe(Integer safe) {
        this.safe = safe;
    }
}
