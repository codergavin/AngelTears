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
public class WxWorkMarkdownMsg extends WxWorkMsgBase {
    private Object markdown;
    public WxWorkMarkdownMsg(){}

    public WxWorkMarkdownMsg(Integer agentid, String msgtype, String touser, Object textcard){
        setAgentid(agentid);
        setMsgtype(msgtype);
        setTouser(touser);
        this.markdown = textcard;
    }

    public WxWorkMarkdownMsg(Integer agentid, String msgtype, String touser,String text){
        setAgentid(agentid);
        setMsgtype(msgtype);
        setTouser(touser);
        Map<Object, Object> content = new HashMap<>();
        content.put("content", text);
        this.markdown = content;
    }

    public Object getMarkdown() {
        return markdown;
    }

    public void setMarkdown(Object markdown) {
        this.markdown = markdown;
    }
}
