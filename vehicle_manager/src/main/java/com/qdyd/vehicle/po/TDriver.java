package com.qdyd.vehicle.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author 作者 : Czyer
 * @version 创建时间：2019年8月12日 下午12:03:03 
 * 类说明：驾驶员信息表
 */
@TableName(value = "t_driver")
public class TDriver {

	@TableId
	@TableField("t_driver_id")
	private String driverId;

	@TableField("t_drive_name")
	private String driverName;

	@TableField("t_department")
	private String department;

	@TableField("t_tel")
	private String tel;

	@TableField("t_card_id")
	private String cardId;

	@TableField("t_status")
	private Integer status;

	@TableField("t_data_status")
	private Integer dataStatus;

	@TableField("t_remark")
	private String remark;

	public TDriver() {
		super();
	}

	public TDriver(String driverId, String driverName, String department, String tel, String cardId, Integer status,
			Integer dataStatus, String remark) {
		super();
		this.driverId = driverId;
		this.driverName = driverName;
		this.department = department;
		this.tel = tel;
		this.cardId = cardId;
		this.status = status;
		this.dataStatus = dataStatus;
		this.remark = remark;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "TDriver [driverId=" + driverId + ", driverName=" + driverName + ", department=" + department + ", tel="
				+ tel + ", cardId=" + cardId + ", status=" + status + ", dataStatus=" + dataStatus + ", remark="
				+ remark + "]";
	}

}
