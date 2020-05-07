package com.qdyd.vehicle.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author 作者 : Czyer
 * @version 创建时间：2019年8月12日 下午12:03:03 
 * 类说明：用车人信息表
 */
@TableName(value = "t_driver_use_man")
public class TDriverUseMan {

	@TableId
	@TableField("t_driver_id")
	private String driverId;

	@TableField("t_use_name")
	private String useName;

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

	public TDriverUseMan() {
		super();
	}

	public TDriverUseMan(String driverId, String useName, String department, String tel, String cardId, Integer status,
						 Integer dataStatus, String remark) {
		super();
		this.driverId = driverId;
		this.useName = useName;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getUseName() { return useName; }

	public void setUseName(String useName) { this.useName = useName; }

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
		return "TDriver [driverId=" + driverId + ", useName=" + useName + ", department=" + department + ", tel="
				+ tel + ", cardId=" + cardId + ", status=" + status + ", dataStatus=" + dataStatus + ", remark="
				+ remark + "]";
	}

}
