package com.goodlook.dao.bo;

/**
 * Created by admin on 10.09.2017.
 */
public class SelectionCriteria {
    private String region;
    private String category;
    private int priority;
    private long minNum;
    private long maxNum;
    private int recordsCount;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public long getMinNum() {
        return minNum;
    }

    public void setMinNum(long minNum) {
        this.minNum = minNum;
    }

    public long getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(long maxNum) {
        this.maxNum = maxNum;
    }

    public int getRecordsCount() {
        return recordsCount;
    }

    public void setRecordsCount(int recordsCount) {
        this.recordsCount = recordsCount;
    }
}
