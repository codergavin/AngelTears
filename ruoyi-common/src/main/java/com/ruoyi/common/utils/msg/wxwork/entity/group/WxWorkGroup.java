package com.ruoyi.common.utils.msg.wxwork.entity.group;

import java.util.List;

/**
 * @author Gavin Li
 * @version 1.0
 * @group HummingBird
 * @date 2022/5/22 15:59
 * @desc
 */
public class WxWorkGroup {
    /**
     * 是否必须:否
     * 群聊名，最多50个utf8字符，超过将截断
     */
    private String name;
    /**
     * 是否必须:否
     * 指定群主的id。如果不指定，系统会随机从userlist中选一人作为群主
     */
    private String owner;
    /**
     * 是否必须:是
     * 群成员id列表。至少2人，至多2000人
     */
    private Object userlist;
    /**
     * 是否必须:否
     * 群聊的唯一标志，不能与已有的群重复；字符串类型，最长32个字符。只允许字符0-9及字母a-zA-Z。如果不填，系统会随机生成群id
     */
    private String chatid;

    public WxWorkGroup(){}

    public WxWorkGroup(String name, String owner, List<String> userList){
        this.name = name;
        this.owner = owner;
        this.userlist = userList;
    }

    public WxWorkGroup(String name, String owner, List<String> userList,String chatid){
        this.name = name;
        this.owner = owner;
        this.userlist = userList;
        this.chatid = chatid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Object getUserlist() {
        return userlist;
    }

    public void setUserlist(Object userlist) {
        this.userlist = userlist;
    }

    public String getChatid() {
        return chatid;
    }

    public void setChatid(String chatid) {
        this.chatid = chatid;
    }
}
