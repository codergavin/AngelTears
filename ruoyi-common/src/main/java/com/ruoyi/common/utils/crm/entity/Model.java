package com.ruoyi.common.utils.crm.entity;

/**
 * @author Gavin Li
 * @version 1.0
 * @group HummingBird
 * @date 2022/7/1 18:40
 * @desc 机型
 */
public class Model {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Model{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
