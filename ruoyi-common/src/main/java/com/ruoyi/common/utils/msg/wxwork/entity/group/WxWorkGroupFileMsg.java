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
public class WxWorkGroupFileMsg extends WxWorkGroupMsgBase {
    private Object file;
    public WxWorkGroupFileMsg(){}

    public WxWorkGroupFileMsg(String chatid, String msgtype, String imageId){
        setChatid(chatid);
        setMsgtype(msgtype);
        Map<Object, Object> content = new HashMap<>();
        content.put("media_id", imageId);
        this.file = content;
    }

    public Object getFile() {
        return file;
    }

    public void setFile(Object file) {
        this.file = file;
    }
}
