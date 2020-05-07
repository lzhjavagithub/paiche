package com.qdyd.vehicle.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName(value = "t_destination")
public class TDestination {

    @TableField("t_des_id")
    private String desId;
    @TableField("t_des_name")
    private String desName;
    @TableField("t_des_time")
    private Date desTime;
    @TableField("t_data_status")
	private Integer dataStatus;

    public TDestination() {
    }

    public TDestination(String desId, String desName, Date desTime, Integer dataStatus) {
        this.desId = desId;
        this.desName = desName;
        this.desTime = desTime;
        this.dataStatus = dataStatus;
    }

    public String getDesId() {
        return desId;
    }

    public void setDesId(String desId) {
        this.desId = desId;
    }

    public String getDesName() {
        return desName;
    }

    public void setDesName(String desName) {
        this.desName = desName;
    }

    public Date getDesTime() {
        return desTime;
    }

    public void setDesTime(Date desTime) {
        this.desTime = desTime;
    }

    public Integer getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
    }
}
