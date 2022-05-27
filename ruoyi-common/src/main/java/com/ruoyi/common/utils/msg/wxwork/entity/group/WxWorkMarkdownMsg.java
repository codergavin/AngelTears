package com.ruoyi.common.utils.msg.wxwork.entity.group;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gavin Li
 * @version 1.0
 * @group HummingBird
 * @date 2022/5/22 16:35
 * @desc
 */
public class WxWorkMarkdownMsg extends WxWorkGroupMsgBase {
    private Object markdown;
    public WxWorkMarkdownMsg(){}

    public WxWorkMarkdownMsg(String chatid, String msgtype, String text){
        setChatid(chatid);
        setMsgtype(msgtype);
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
