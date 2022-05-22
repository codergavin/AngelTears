package com.ruoyi.common.utils.msg.wxwork.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gavin Li
 * @version 1.0
 * @group HummingBird
 * @date 2022/5/21 22:46
 * @desc 文本消息
 */
public class WxTextMessage extends WxMsgBase {

    /**
     * 是否必填：是
     * 消息内容
     */
    private Object text;

    /**
     * 表示是否开启id转译，0表示否，1表示是，默认0。仅第三方应用需要用到，企业自建应用可以忽略。
     */
    private Integer enable_id_trans = 0;


    public WxTextMessage(){}

    public WxTextMessage(Integer agentid, String msgtype, String touser, String text){
        setAgentid(agentid);
        setMsgtype(msgtype);
        setTouser(touser);
        Map<Object, Object> content = new HashMap<>();
        content.put("content", text);
        this.text = content;
    }

    public Object getText() {
        return text;
    }

    public void setText(Object text) {
        Map<Object, Object> content = new HashMap<>();
        content.put("content", text);
        this.text = content;
    }


    public Integer getEnable_id_trans() {
        return enable_id_trans;
    }

    public void setEnable_id_trans(Integer enable_id_trans) {
        this.enable_id_trans = enable_id_trans;
    }

}
