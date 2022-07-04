package com.ruoyi.common.utils.meo.entity;

import java.util.List;

/**
 * @author Gavin Li
 * @version 1.0
 * @group HummingBird
 * @date 2022/7/1 10:26
 * @desc 合同
 */
public class Contract {
    // ID
    private Long id;
    // 项目ID
    private Long opportunityId;
    // 合同编号
    private String title;
    // 贸易术语
    private Integer price_term__c;
    private String price_term__c_str;
    // 交货地点
    private String del_addr__c;

    List<ContractDeliveryPlan> contractDeliveryPlanList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOpportunityId() {
        return opportunityId;
    }

    public void setOpportunityId(Long opportunityId) {
        this.opportunityId = opportunityId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice_term__c() {
        return price_term__c;
    }

    public void setPrice_term__c(Integer price_term__c) {
        this.price_term__c = price_term__c;
    }

    public String getDel_addr__c() {
        return del_addr__c;
    }

    public void setDel_addr__c(String del_addr__c) {
        this.del_addr__c = del_addr__c;
    }

    public String getPrice_term__c_str() {
        return price_term__c_str;
    }

    public void setPrice_term__c_str(String price_term__c_str) {
        this.price_term__c_str = price_term__c_str;
    }

    public List<ContractDeliveryPlan> getContractDeliveryPlanList() {
        return contractDeliveryPlanList;
    }

    public void setContractDeliveryPlanList(List<ContractDeliveryPlan> contractDeliveryPlanList) {
        this.contractDeliveryPlanList = contractDeliveryPlanList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Contract{");
        sb.append("id=").append(id);
        sb.append(", opportunityId=").append(opportunityId);
        sb.append(", title='").append(title).append('\'');
        sb.append(", price_term__c=").append(price_term__c);
        sb.append(", price_term__c_str='").append(price_term__c_str).append('\'');
        sb.append(", del_addr__c='").append(del_addr__c).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
