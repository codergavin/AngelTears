package com.ruoyi.common.utils.hrms.entity;

/**
 * @author Gavin Li
 * @version 1.0
 * @group HummingBird
 * @date 2022/7/5 10:43
 * @desc 部门实体
 */
public class OrgEntity {
    //组织的id；根组织的id为1
    private String did;
    //组织的上级id；根组织的上级组织id为0
    private String parentDid;
    //组织编码
    private String unitCode;
    //组织名称
    private String name;
    //组织状态；effective：生效状态；expired: 失效状态; 接口默认返回的全部是生效状态的组织
    private String workUnitStatus;

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getParentDid() {
        return parentDid;
    }

    public void setParentDid(String parentDid) {
        this.parentDid = parentDid;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkUnitStatus() {
        return workUnitStatus;
    }

    public void setWorkUnitStatus(String workUnitStatus) {
        this.workUnitStatus = workUnitStatus;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrgEntity{");
        sb.append("did='").append(did).append('\'');
        sb.append(", parentDid='").append(parentDid).append('\'');
        sb.append(", unitCode='").append(unitCode).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", workUnitStatus='").append(workUnitStatus).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
