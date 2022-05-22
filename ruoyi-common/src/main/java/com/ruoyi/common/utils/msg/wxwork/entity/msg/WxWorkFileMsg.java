package com.ruoyi.common.utils.msg.wxwork.entity.msg;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gavin Li
 * @version 1.0
 * @group HummingBird
 * @date 2022/5/22 0:06
 * @desc 文件消息
 */
public class WxWorkFileMsg extends WxWorkMsgBase {
    private Object file;
    public WxWorkFileMsg(){}

    public WxWorkFileMsg(Integer agentid, String msgtype, String touser, String image){
        setAgentid(agentid);
        setMsgtype(msgtype);
        setTouser(touser);
        Map<Object, Object> content = new HashMap<>();
        content.put("media_id", image);
        this.file = content;
    }

    public Object getFile() {
        return file;
    }

    public void setFile(Object file) {
        Map<Object, Object> content = new HashMap<>();
        content.put("media_id", file);
        this.file = content;
    }

}
