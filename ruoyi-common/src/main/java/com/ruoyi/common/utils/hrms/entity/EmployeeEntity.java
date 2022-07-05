package com.ruoyi.common.utils.hrms.entity;

/**
 * @author Gavin Li
 * @version 1.0
 * @group HummingBird
 * @date 2022/7/5 11:00
 * @desc 成员信息
 */
public class EmployeeEntity {
    // 员工id
    private Integer eid;
    // 员工工号
    private String employeeCode;
    // 员工姓名
    private String fullName;
    // 员工在职还是离职；true表示在职；false表示离职
    private boolean active;
    // 员工所属组织的id
    private String did;
    // 员工所属组织编码
    private String unitCode;
    // 员工所属组织的名称
    private String unitName;
    // 员工所属岗位编码
    private String positionCode;
    // 员工所属岗位名称
    private String positionName;
    // 员工的公司邮箱
    private String companyEmailAddress;
    // 员工个人邮箱
    private String personalEmailAddress;
    // 员工手机号
    private String mobile;
    // 员工的企业微信userId
    private String wechatWorkUserId;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getCompanyEmailAddress() {
        return companyEmailAddress;
    }

    public void setCompanyEmailAddress(String companyEmailAddress) {
        this.companyEmailAddress = companyEmailAddress;
    }

    public String getPersonalEmailAddress() {
        return personalEmailAddress;
    }

    public void setPersonalEmailAddress(String personalEmailAddress) {
        this.personalEmailAddress = personalEmailAddress;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWechatWorkUserId() {
        return wechatWorkUserId;
    }

    public void setWechatWorkUserId(String wechatWorkUserId) {
        this.wechatWorkUserId = wechatWorkUserId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EmployeeEntity{");
        sb.append("eid=").append(eid);
        sb.append(", employeeCode='").append(employeeCode).append('\'');
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append(", active=").append(active);
        sb.append(", did='").append(did).append('\'');
        sb.append(", unitCode='").append(unitCode).append('\'');
        sb.append(", unitName='").append(unitName).append('\'');
        sb.append(", positionCode='").append(positionCode).append('\'');
        sb.append(", positionName='").append(positionName).append('\'');
        sb.append(", companyEmailAddress='").append(companyEmailAddress).append('\'');
        sb.append(", personalEmailAddress='").append(personalEmailAddress).append('\'');
        sb.append(", mobile='").append(mobile).append('\'');
        sb.append(", wechatWorkUserId='").append(wechatWorkUserId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
