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
public class WxWorkGroupImageMsg extends WxWorkGroupMsgBase {
    private Object image;
    public WxWorkGroupImageMsg(){}

    public WxWorkGroupImageMsg(String chatid, String msgtype, String imageId){
        setChatid(chatid);
        setMsgtype(msgtype);
        Map<Object, Object> content = new HashMap<>();
        content.put("media_id", imageId);
        this.image = content;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }
}
