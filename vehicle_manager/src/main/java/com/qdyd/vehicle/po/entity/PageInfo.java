package com.qdyd.vehicle.po.entity;

import java.util.Collections;
import java.util.List;

public class PageInfo<T> {

    /**
     * 总数
     */
    public Integer total;

    /**
     * 当前页
     */
    public Integer pageNum;

    /**
     * 页大小
     */
    public Integer pageSize;

    /**
     * 数据列表
     */
    public List<T> records = Collections.emptyList();

    public PageInfo() {
    }

    public PageInfo(Integer total, Integer pageNum, Integer pageSize, List<T> records) {
        this.total = total;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.records = records;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
