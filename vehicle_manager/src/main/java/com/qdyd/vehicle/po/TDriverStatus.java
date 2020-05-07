package com.qdyd.vehicle.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author 作者 : Czyer
 * @version 创建时间：2019年8月15日 类说明：人员状态类
 */
@TableName(value = "t_driver_status")
public class TDriverStatus {

	@TableId
	@TableField("driver_status_id")
	private String driverStatusId;

	@TableField("status_num")
	private String statusNum;

	@TableField("status_name")
	private String statusName;

	public TDriverStatus() {
		super();
	}

	public TDriverStatus(String driverStatusId, String statusNum, String statusName) {
		super();
		this.driverStatusId = driverStatusId;
		this.statusNum = statusNum;
		this.statusName = statusName;
	}

	public String getDriverStatusId() {
		return driverStatusId;
	}

	public void setDriverStatusId(String driverStatusId) {
		this.driverStatusId = driverStatusId;
	}

	public String getStatusNum() {
		return statusNum;
	}

	public void setStatusNum(String statusNum) {
		this.statusNum = statusNum;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	@Override
	public String toString() {
		return "TDriverStatus [driverStatusId=" + driverStatusId + ", statusNum=" + statusNum + ", statusName="
				+ statusName + "]";
	}

}
