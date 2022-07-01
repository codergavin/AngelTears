package com.ruoyi.common.utils.crm.entity;

/**
 * @author Gavin Li
 * @version 1.0
 * @group HummingBird
 * @date 2022/7/1 16:31
 * @desc 通用选项集
 */
public class GlobalPickOptionRecord {
    private String apiKey;
    private boolean custom;
    private String pickOption;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public boolean isCustom() {
        return custom;
    }

    public void setCustom(boolean custom) {
        this.custom = custom;
    }

    public String getPickOption() {
        return pickOption;
    }

    public void setPickOption(String pickOption) {
        this.pickOption = pickOption;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GlobalPickOptionRecord{");
        sb.append("apiKey='").append(apiKey).append('\'');
        sb.append(", custom=").append(custom);
        sb.append(", pickOption='").append(pickOption).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
