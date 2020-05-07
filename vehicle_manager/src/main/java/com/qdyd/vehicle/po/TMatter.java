package com.qdyd.vehicle.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_matter")
public class TMatter {

    @TableField("t_id")
    private String tid;
    @TableField("t_cause")
    private String cause;
    @TableField("t_create_date")
    private Date createDate;
    @TableField("t_data_status")
    private Integer dataStatus;
	public TMatter(String tid, String cause, Date createDate, Integer dataStatus) {
		super();
		this.tid = tid;
		this.cause = cause;
		this.createDate = createDate;
		this.dataStatus = dataStatus;
	}
	public TMatter() {
		super();
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getDataStatus() {
		return dataStatus;
	}
	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}
	@Override
	public String toString() {
		return "TMatter [tid=" + tid + ", cause=" + cause + ", createDate=" + createDate + ", dataStatus=" + dataStatus
				+ "]";
	}

}
