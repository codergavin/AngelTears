package com.ruoyi.common.utils.msg.wxwork.entity.group;

import com.ruoyi.common.utils.msg.wxwork.entity.msg.WxWorkMsgBase;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gavin Li
 * @version 1.0
 * @group HummingBird
 * @date 2022/5/22 0:06
 * @desc 文本卡片消息
 */
public class WxWorkGroupTextCardMsg extends WxWorkGroupMsgBase {
    private Object textcard;
    public WxWorkGroupTextCardMsg(){}

    public WxWorkGroupTextCardMsg(String chatid, String msgtype, Object textcard){
        setChatid(chatid);
        setMsgtype(msgtype);
        this.textcard = textcard;
    }

    public WxWorkGroupTextCardMsg(String chatid, String msgtype, String title, String description, String url, String btntxt){
        setChatid(chatid);
        setMsgtype(msgtype);
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
