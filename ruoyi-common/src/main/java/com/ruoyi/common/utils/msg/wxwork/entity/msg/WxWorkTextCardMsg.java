package com.ruoyi.common.utils.msg.wxwork.entity.msg;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gavin Li
 * @version 1.0
 * @group HummingBird
 * @date 2022/5/22 0:06
 * @desc 文本卡片消息
 */
public class WxWorkTextCardMsg extends WxWorkMsgBase {
    private Object textcard;
    public WxWorkTextCardMsg(){}

    public WxWorkTextCardMsg(Integer agentid, String msgtype, String touser, Object textcard){
        setAgentid(agentid);
        setMsgtype(msgtype);
        setTouser(touser);
        this.textcard = textcard;
    }

    public WxWorkTextCardMsg(Integer agentid, String msgtype, String touser,
                             String title, String description, String url, String btntxt){
        setAgentid(agentid);
        setMsgtype(msgtype);
        setTouser(touser);
        Map<Object, Object> content = new HashMap<>();
        content.put("title", title);
        content.put("description", description);
        content.put("url", url);
        content.put("btntxt", btntxt);
        this.textcard = content;
    }

    public Object getTextcard() {
        return textcard;
    }

    public void setTextcard(Object textcard) {
        this.textcard = textcard;
    }

}
