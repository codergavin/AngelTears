package com.ruoyi.common.utils.meo.entity;

/**
 * @author Gavin Li
 * @version 1.0
 * @group HummingBird
 * @date 2022/7/1 10:26
 * @desc 客户
 */
public class Account {
    private Long id;
    /** 客户名称 */
    private String accountName;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("accountName='").append(accountName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
