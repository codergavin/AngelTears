package com.ruoyi.common.utils.msg.wxwork.entity;

/**
 * @author Gavin Li
 * @version 1.0
 * @group HummingBird
 * @date 2022/5/21 23:10
 * @desc
 */
public class WxMsgBase {
    /**
     * 指定接收消息的成员，成员ID列表（多个接收者用‘|’分隔，最多支持1000个）。
     */
    private String touser;
    /**
     * 指定接收消息的部门，部门ID列表，多个接收者用‘|’分隔，最多支持100个。
     */
    private String toparty;
    /**
     * 指定接收消息的标签，标签ID列表，多个接收者用‘|’分隔，最多支持100个。
     */
    private String totag;

    /**
     * 是否必填：是
     * 消息类型
     */
    private String msgtype;

    /**
     * 是否必填：是
     * 企业应用的id，整型。
     */
    private Integer agentid;
    /**
     * 表示是否是保密消息，0表示可对外分享，1表示不能分享且内容显示水印，默认为0
     */
    private Integer safe = 0;
    private Integer enable_id_trans = 0;
    /**
     * 表示是否开启重复消息检查，0表示否，1表示是，默认0
     */
    private Integer enable_duplicate_check = 0;
    /**
     * 表示是否重复消息检查的时间间隔，默认1800s，最大不超过4小时
     */
    private Integer duplicate_check_interval = 1800;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getToparty() {
        return toparty;
    }

    public void setToparty(String toparty) {
        this.toparty = toparty;
    }

    public String getTotag() {
        return totag;
    }

    public void setTotag(String totag) {
        this.totag = totag;
    }

    public Integer getAgentid() {
        return agentid;
    }

    public void setAgentid(Integer agentid) {
        this.agentid = agentid;
    }

    public Integer getSafe() {
        return safe;
    }

    public void setSafe(Integer safe) {
        this.safe = safe;
    }

    public Integer getEnable_duplicate_check() {
        return enable_duplicate_check;
    }

    public void setEnable_duplicate_check(Integer enable_duplicate_check) {
        this.enable_duplicate_check = enable_duplicate_check;
    }

    public Integer getDuplicate_check_interval() {
        return duplicate_check_interval;
    }

    public void setDuplicate_check_interval(Integer duplicate_check_interval) {
        this.duplicate_check_interval = duplicate_check_interval;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public Integer getEnable_id_trans() {
        return enable_id_trans;
    }

    public void setEnable_id_trans(Integer enable_id_trans) {
        this.enable_id_trans = enable_id_trans;
    }
}
