package com.ruoyi.common.utils.crm.entity;

/**
 * @author Gavin Li
 * @version 1.0
 * @group HummingBird
 * @date 2022/7/1 16:31
 * @desc 通用选项集
 */
public class GlobalPickOption {
    // Value
    private String optionLabel;
    // Key
    private Integer optionCode;
    private String optionApiKey;
    private boolean active;
    private Integer optionOrder;
    private String optionLabelKey;
    private String optionLabel_resourceKey;

    public String getOptionLabel() {
        return optionLabel;
    }

    public void setOptionLabel(String optionLabel) {
        this.optionLabel = optionLabel;
    }

    public Integer getOptionCode() {
        return optionCode;
    }

    public void setOptionCode(Integer optionCode) {
        this.optionCode = optionCode;
    }

    public String getOptionApiKey() {
        return optionApiKey;
    }

    public void setOptionApiKey(String optionApiKey) {
        this.optionApiKey = optionApiKey;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Integer getOptionOrder() {
        return optionOrder;
    }

    public void setOptionOrder(Integer optionOrder) {
        this.optionOrder = optionOrder;
    }

    public String getOptionLabelKey() {
        return optionLabelKey;
    }

    public void setOptionLabelKey(String optionLabelKey) {
        this.optionLabelKey = optionLabelKey;
    }

    public String getOptionLabel_resourceKey() {
        return optionLabel_resourceKey;
    }

    public void setOptionLabel_resourceKey(String optionLabel_resourceKey) {
        this.optionLabel_resourceKey = optionLabel_resourceKey;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GlobalPickOption{");
        sb.append("optionLabel='").append(optionLabel).append('\'');
        sb.append(", optionCode=").append(optionCode);
        sb.append(", optionApiKey='").append(optionApiKey).append('\'');
        sb.append(", active=").append(active);
        sb.append(", optionOrder=").append(optionOrder);
        sb.append(", optionLabelKey='").append(optionLabelKey).append('\'');
        sb.append(", optionLabel_resourceKey='").append(optionLabel_resourceKey).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
