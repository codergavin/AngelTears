package com.ruoyi.common.utils.crm.entity;

import java.util.Date;

/**
 * @author Gavin Li
 * @version 1.0
 * @group HummingBird
 * @date 2022/7/1 10:26
 * @desc 合同交付计划
 */
public class ContractDeliveryPlan {
    /** ID */
    private Long id;
    /** 批次 */
    private Integer bat_num__c;
    /** 套数 */
    private Integer set_qty__c;
    /** 批次交付日期 */
    private Long bat_deliv_date__c;
    /** 批次描述 */
    private String desc__c;
    /** 合同 ID */
    private Long customItem5__c;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBat_num__c() {
        return bat_num__c;
    }

    public void setBat_num__c(Integer bat_num__c) {
        this.bat_num__c = bat_num__c;
    }

    public Integer getSet_qty__c() {
        return set_qty__c;
    }

    public void setSet_qty__c(Integer set_qty__c) {
        this.set_qty__c = set_qty__c;
    }

    public Long getBat_deliv_date__c() {
        return bat_deliv_date__c;
    }

    public void setBat_deliv_date__c(Long bat_deliv_date__c) {
        this.bat_deliv_date__c = bat_deliv_date__c;
    }

    public String getDesc__c() {
        return desc__c;
    }

    public void setDesc__c(String desc__c) {
        this.desc__c = desc__c;
    }

    public Long getCustomItem5__c() {
        return customItem5__c;
    }

    public void setCustomItem5__c(Long customItem5__c) {
        this.customItem5__c = customItem5__c;
    }
}
