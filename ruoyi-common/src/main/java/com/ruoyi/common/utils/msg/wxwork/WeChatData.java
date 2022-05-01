package com.ruoyi.common.utils.msg.wxwork;

/**
 * @author Gavin Li
 * @group CoderBean
 * @date 2022/1/6 11:47
 * @desc 微信消息发送实体类
 */
public class WeChatData {
    /**
     * 成员账号
     */
    private String touser;

    /**
     * 消息类型
     */
    private String msgtype;

    /**
     * 企业用用的agentid
     */
    private String agentid;

    /**
     * 十几接收map类型数据
     */
    private Object text;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid;
    }

    public Object getText() {
        return text;
    }

    public void setText(Object text) {
        this.text = text;
    }
}
