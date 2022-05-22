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
public class WxWorkGroupTextMsg extends WxWorkGroupMsgBase {
    private Object text;
    public WxWorkGroupTextMsg(){}

    public WxWorkGroupTextMsg(String chatid,String msgtype,String text){
        setChatid(chatid);
        setMsgtype(msgtype);
        Map<Object, Object> content = new HashMap<>();
        content.put("content", text);
        this.text = content;
    }

    public Object getText() {
        return text;
    }

    public void setText(Object text) {
        this.text = text;
    }
}
