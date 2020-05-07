package com.qdyd.vehicle.po;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author 作者 : Czyer
 * @version 创建时间：2019年8月12日 下午12:03:03 
 * 类说明：车辆信息表
 */
@TableName(value = "t_car")
public class TCar {

	@TableId
	@TableField("t_car_id")
	private String carId;

	@TableField("t_car_no")
	private String carNo;
	
	@TableField("t_car_driver_id")
	private String carDriverId;

	@TableField("t_car_type")
	private String carType;

	@TableField("t_status")
	private Integer status;

	@TableField("t_create_date")
	private Date createDate;

	@TableField("t_data_status")
	private Integer dataStatus;

	@TableField("t_remark")
	private String remark;

	public TCar() {
		super();
	}

	public TCar(String carId, String carNo, String carDriverId, String carType, Integer status, Date createDate,
			Integer dataStatus, String remark) {
		super();
		this.carId = carId;
		this.carNo = carNo;
		this.carDriverId = carDriverId;
		this.carType = carType;
		this.status = status;
		this.createDate = createDate;
		this.dataStatus = dataStatus;
		this.remark = remark;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public String getCarDriverId() {
		return carDriverId;
	}

	public void setCarDriverId(String carDriverId) {
		this.carDriverId = carDriverId;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "TCar [carId=" + carId + ", carNo=" + carNo + ", carDriverId=" + carDriverId + ", carType=" + carType
				+ ", status=" + status + ", createDate=" + createDate + ", dataStatus=" + dataStatus + ", remark="
				+ remark + "]";
	}

	
	

}
