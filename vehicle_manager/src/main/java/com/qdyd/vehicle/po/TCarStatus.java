package com.qdyd.vehicle.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author 作者 : Czyer
 * @version 创建时间：2019年8月15日 类说明：车辆状态类
 */
@TableName(value = "t_car_status")
public class TCarStatus {

	@TableId
	@TableField("car_status_id")
	private String carStatusId;

	@TableField("status_num")
	private String statusNum;

	@TableField("status_name")
	private String statusName;

	public TCarStatus() {
		super();
	}

	public TCarStatus(String carStatusId, String statusNum, String statusName) {
		super();
		this.carStatusId = carStatusId;
		this.statusNum = statusNum;
		this.statusName = statusName;
	}

	public String getCarStatusId() {
		return carStatusId;
	}

	public void setCarStatusId(String carStatusId) {
		this.carStatusId = carStatusId;
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
		return "TCarStatus [carStatusId=" + carStatusId + ", statusNum=" + statusNum + ", statusName=" + statusName
				+ "]";
	}

}
