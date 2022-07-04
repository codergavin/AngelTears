package com.ruoyi.common.utils.meo.entity;

import java.util.List;

/**
 * @author Gavin Li
 * @version 1.0
 * @group HummingBird
 * @date 2022/7/1 17:24
 * @desc 项目
 */
public class Project {
    private Long id;
    //项目名称
    private String opportunityName;
    //客户名称
    private Long accountId;
    private String accountName;

    private String proj_num__c;
    //塔筒机型1
    private Long tower_machine__c;
    private String tower_machine__c_str;
    //机型1套数
    private Integer set_qty__c;

    //塔筒机型2
    private Long tower_2__c__c;
    private String tower_2__c__c_str;
    //机型2套数
    private Integer tower_2_qty__c;
    //塔筒机型3
    private Long tower_3__c;
    private String tower_3__c_str;
    //机型3套数
    private Integer tower_3_qty__c;
    //塔筒机型4
    private Long tower_4__c;
    private String tower_4__c_str;
    //机型4套数
    private Integer tower_4_qty__c;
    //跟进人
    private Long follower__c;
    private String follower__c_str;
    //项目位置（国家）
    private Integer country__c;
    private String country__c_str;
    //项目位置（省份）
    private Integer province__c;
    private String province__c_str;
    //项目详细位置
    private String address__c;

    List<Contract> contractList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpportunityName() {
        return opportunityName;
    }

    public void setOpportunityName(String opportunityName) {
        this.opportunityName = opportunityName;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Long getTower_machine__c() {
        return tower_machine__c;
    }

    public void setTower_machine__c(Long tower_machine__c) {
        this.tower_machine__c = tower_machine__c;
    }

    public String getTower_machine__c_str() {
        return tower_machine__c_str;
    }

    public void setTower_machine__c_str(String tower_machine__c_str) {
        this.tower_machine__c_str = tower_machine__c_str;
    }

    public Integer getSet_qty__c() {
        return set_qty__c;
    }

    public void setSet_qty__c(Integer set_qty__c) {
        this.set_qty__c = set_qty__c;
    }

    public Long getTower_2__c__c() {
        return tower_2__c__c;
    }

    public void setTower_2__c__c(Long tower_2__c__c) {
        this.tower_2__c__c = tower_2__c__c;
    }

    public Long getTower_3__c() {
        return tower_3__c;
    }

    public void setTower_3__c(Long tower_3__c) {
        this.tower_3__c = tower_3__c;
    }

    public Long getTower_4__c() {
        return tower_4__c;
    }

    public void setTower_4__c(Long tower_4__c) {
        this.tower_4__c = tower_4__c;
    }

    public String getTower_2__c__c_str() {
        return tower_2__c__c_str;
    }

    public void setTower_2__c__c_str(String tower_2__c__c_str) {
        this.tower_2__c__c_str = tower_2__c__c_str;
    }

    public Integer getTower_2_qty__c() {
        return tower_2_qty__c;
    }

    public void setTower_2_qty__c(Integer tower_2_qty__c) {
        this.tower_2_qty__c = tower_2_qty__c;
    }

    public String getTower_3__c_str() {
        return tower_3__c_str;
    }

    public void setTower_3__c_str(String tower_3__c_str) {
        this.tower_3__c_str = tower_3__c_str;
    }

    public Integer getTower_3_qty__c() {
        return tower_3_qty__c;
    }

    public void setTower_3_qty__c(Integer tower_3_qty__c) {
        this.tower_3_qty__c = tower_3_qty__c;
    }

    public String getTower_4__c_str() {
        return tower_4__c_str;
    }

    public void setTower_4__c_str(String tower_4__c_str) {
        this.tower_4__c_str = tower_4__c_str;
    }

    public Integer getTower_4_qty__c() {
        return tower_4_qty__c;
    }

    public void setTower_4_qty__c(Integer tower_4_qty__c) {
        this.tower_4_qty__c = tower_4_qty__c;
    }

    public Long getFollower__c() {
        return follower__c;
    }

    public void setFollower__c(Long follower__c) {
        this.follower__c = follower__c;
    }

    public String getFollower__c_str() {
        return follower__c_str;
    }

    public void setFollower__c_str(String follower__c_str) {
        this.follower__c_str = follower__c_str;
    }

    public Integer getCountry__c() {
        return country__c;
    }

    public void setCountry__c(Integer country__c) {
        this.country__c = country__c;
    }

    public String getCountry__c_str() {
        return country__c_str;
    }

    public void setCountry__c_str(String country__c_str) {
        this.country__c_str = country__c_str;
    }

    public Integer getProvince__c() {
        return province__c;
    }

    public void setProvince__c(Integer province__c) {
        this.province__c = province__c;
    }

    public String getProvince__c_str() {
        return province__c_str;
    }

    public void setProvince__c_str(String province__c_str) {
        this.province__c_str = province__c_str;
    }

    public String getAddress__c() {
        return address__c;
    }

    public void setAddress__c(String address__c) {
        this.address__c = address__c;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public String getProj_num__c() {
        return proj_num__c;
    }

    public void setProj_num__c(String proj_num__c) {
        this.proj_num__c = proj_num__c;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Project{");
        sb.append("id=").append(id);
        sb.append(", opportunityName='").append(opportunityName).append('\'');
        sb.append(", accountId=").append(accountId);
        sb.append(", accountName='").append(accountName).append('\'');
        sb.append(", proj_num__c='").append(proj_num__c).append('\'');
        sb.append(", tower_machine__c=").append(tower_machine__c);
        sb.append(", tower_machine__c_str='").append(tower_machine__c_str).append('\'');
        sb.append(", set_qty__c=").append(set_qty__c);
        sb.append(", tower_2__c__c=").append(tower_2__c__c);
        sb.append(", tower_2__c__c_str='").append(tower_2__c__c_str).append('\'');
        sb.append(", tower_2_qty__c=").append(tower_2_qty__c);
        sb.append(", tower_3__c=").append(tower_3__c);
        sb.append(", tower_3__c_str='").append(tower_3__c_str).append('\'');
        sb.append(", tower_3_qty__c=").append(tower_3_qty__c);
        sb.append(", tower_4__c=").append(tower_4__c);
        sb.append(", tower_4__c_str='").append(tower_4__c_str).append('\'');
        sb.append(", tower_4_qty__c=").append(tower_4_qty__c);
        sb.append(", follower__c=").append(follower__c);
        sb.append(", follower__c_str='").append(follower__c_str).append('\'');
        sb.append(", country__c=").append(country__c);
        sb.append(", country__c_str='").append(country__c_str).append('\'');
        sb.append(", province__c=").append(province__c);
        sb.append(", province__c_str='").append(province__c_str).append('\'');
        sb.append(", address__c='").append(address__c).append('\'');
        sb.append(", contractList=").append(contractList);
        sb.append('}');
        return sb.toString();
    }
}
