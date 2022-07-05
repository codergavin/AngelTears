package com.ruoyi.common.utils.hrms.entity;

import java.util.List;

/**
 * @author Gavin Li
 * @version 1.0
 * @group HummingBird
 * @date 2022/7/5 11:15
 * @desc
 */
public class EmployeePageEntity {
    private Integer totalItem;
    private Integer totalPage;
    private List<EmployeeEntity> list;

    public Integer getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Integer totalItem) {
        this.totalItem = totalItem;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<EmployeeEntity> getList() {
        return list;
    }

    public void setList(List<EmployeeEntity> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EmployeePageEntity{");
        sb.append("totalItem=").append(totalItem);
        sb.append(", totalPage=").append(totalPage);
        sb.append(", list=").append(list);
        sb.append('}');
        return sb.toString();
    }
}
