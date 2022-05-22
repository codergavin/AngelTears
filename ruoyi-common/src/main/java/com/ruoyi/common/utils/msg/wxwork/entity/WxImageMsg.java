package com.ruoyi.common.utils.msg.wxwork.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gavin Li
 * @version 1.0
 * @group HummingBird
 * @date 2022/5/22 0:06
 * @desc 图片消息
 */
public class WxImageMsg extends WxMsgBase {
    private Object image;
    public WxImageMsg(){}

    public WxImageMsg(Integer agentid, String msgtype, String touser, String image){
        setAgentid(agentid);
        setMsgtype(msgtype);
        setTouser(touser);
        Map<Object, Object> content = new HashMap<>();
        content.put("media_id", image);
        this.image = content;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        Map<Object, Object> content = new HashMap<>();
        content.put("media_id", image);
        this.image = content;
    }
}
