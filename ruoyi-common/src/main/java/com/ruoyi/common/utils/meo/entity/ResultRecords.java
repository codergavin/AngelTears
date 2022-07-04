package com.ruoyi.common.utils.meo.entity;

/**
 * @author Gavin Li
 * @version 1.0
 * @group HummingBird
 * @date 2022/7/1 13:04
 * @desc
 */
public class ResultRecords {
    private Integer totalSize;
    private Integer count;
    private String records;

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getRecords() {
        return records;
    }

    public void setRecords(String records) {
        this.records = records;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResultRecords{");
        sb.append("totalSize=").append(totalSize);
        sb.append(", count=").append(count);
        sb.append(", records='").append(records).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
