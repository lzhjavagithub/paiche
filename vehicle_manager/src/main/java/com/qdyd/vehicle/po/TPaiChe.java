package com.qdyd.vehicle.po;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 派车单表
 */
@Data
@ToString
@Entity
@Table(name = "t_paiche")
public class TPaiChe {

	@Id
	@Column(name ="t_paiche_id")
	private String paicheId;//'要删除的id'

	@Column(name ="t_no")
	private String no;

	@Column(name ="t_date")
	private Date date;

	@Column(name ="t_use_man")
	private String useMan;

	@Column(name = "t_dept_id")
	private String deptId;

	@Column(name ="t_cause")
	private String cause;

	@Column(name ="t_car_type")
	private String carType;

	@Column(name = "t_man")
	private String man;

	@Column(name ="t_weight")
	private Integer weight;

	@Column(name ="t_car_id")
	private String carId;

	@Column(name ="t_driver_id")
	private String driverId;

	@Column(name ="t_des_id")
	private String destination;

	@Column(name ="t_drive_time")
	private String driveTime;

	@Column(name ="t_go_mileage")
	private Integer goMileage;

	@Column(name ="t_come_mileage")
	private Integer comeMileage;

	@Column(name ="t_mileage")
	private Integer mileage;

	@Column(name ="t_com_mander")
	private String comMander;

	@Column(name ="t_audit_leadership")
	private String auditLeaderShip;

	// 实际返场时间
	@Column(name ="t_return_time")
	private String returnTime;

	// 实际出场时间
	@Column(name ="t_storage_time")
	private String storageTime;

	@Column(name = "t_guji_reture_time")
	private String gujiRetureTime;

	@Column(name = "t_guji_storage_time")
	private String gujiStorageTime;

	@Column(name ="t_update_time")
	private Date updateTime;

	@Column(name ="t_delete_time")
	private Date deleteTime;

	@Column(name ="t_data_status")
	private Integer dataStatus;

	@Column(name ="t_remark")
	private String remark;

	@Column(name = "t_status")
	private String status;// 派车单审核状态 0：待审  1 审核未通过  2 审核通过

	public TPaiChe(String paicheId, String no, Date date, String useMan, String deptId, String cause, String carType,
			String man, Integer weight, String carId, String driverId, String destination, String driveTime,
			Integer goMileage, Integer comeMileage, Integer mileage, String comMander, String auditLeaderShip,
			String returnTime, String storageTime, String gujiRetureTime, String gujiStorageTime, Date updateTime,
			Date deleteTime, Integer dataStatus, String remark, String status) {
		super();
		this.paicheId = paicheId;
		this.no = no;
		this.date = date;
		this.useMan = useMan;
		this.deptId = deptId;
		this.cause = cause;
		this.carType = carType;
		this.man = man;
		this.weight = weight;
		this.carId = carId;
		this.driverId = driverId;
		this.destination = destination;
		this.driveTime = driveTime;
		this.goMileage = goMileage;
		this.comeMileage = comeMileage;
		this.mileage = mileage;
		this.comMander = comMander;
		this.auditLeaderShip = auditLeaderShip;
		this.returnTime = returnTime;
		this.storageTime = storageTime;
		this.gujiRetureTime = gujiRetureTime;
		this.gujiStorageTime = gujiStorageTime;
		this.updateTime = updateTime;
		this.deleteTime = deleteTime;
		this.dataStatus = dataStatus;
		this.remark = remark;
		this.status = status;
	}

	public TPaiChe() {
		super();
	}

	public String getPaicheId() {
		return paicheId;
	}

	public void setPaicheId(String paicheId) {
		this.paicheId = paicheId;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUseMan() {
		return useMan;
	}

	public void setUseMan(String useMan) {
		this.useMan = useMan;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getMan() {
		return man;
	}

	public void setMan(String man) {
		this.man = man;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDriveTime() {
		return driveTime;
	}

	public void setDriveTime(String driveTime) {
		this.driveTime = driveTime;
	}

	public Integer getGoMileage() {
		return goMileage;
	}

	public void setGoMileage(Integer goMileage) {
		this.goMileage = goMileage;
	}

	public Integer getComeMileage() {
		return comeMileage;
	}

	public void setComeMileage(Integer comeMileage) {
		this.comeMileage = comeMileage;
	}

	public Integer getMileage() {
		return mileage;
	}

	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}

	public String getComMander() {
		return comMander;
	}

	public void setComMander(String comMander) {
		this.comMander = comMander;
	}

	public String getAuditLeaderShip() {
		return auditLeaderShip;
	}

	public void setAuditLeaderShip(String auditLeaderShip) {
		this.auditLeaderShip = auditLeaderShip;
	}

	public String getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}

	public String getStorageTime() {
		return storageTime;
	}

	public void setStorageTime(String storageTime) {
		this.storageTime = storageTime;
	}

	public String getGujiRetureTime() {
		return gujiRetureTime;
	}

	public void setGujiRetureTime(String gujiRetureTime) {
		this.gujiRetureTime = gujiRetureTime;
	}

	public String getGujiStorageTime() {
		return gujiStorageTime;
	}

	public void setGujiStorageTime(String gujiStorageTime) {
		this.gujiStorageTime = gujiStorageTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TPaiChe [paicheId=" + paicheId + ", no=" + no + ", date=" + date + ", useMan=" + useMan + ", deptId="
				+ deptId + ", cause=" + cause + ", carType=" + carType + ", man=" + man + ", weight=" + weight
				+ ", carId=" + carId + ", driverId=" + driverId + ", destination=" + destination + ", driveTime="
				+ driveTime + ", goMileage=" + goMileage + ", comeMileage=" + comeMileage + ", mileage=" + mileage
				+ ", comMander=" + comMander + ", auditLeaderShip=" + auditLeaderShip + ", returnTime=" + returnTime
				+ ", storageTime=" + storageTime + ", gujiRetureTime=" + gujiRetureTime + ", gujiStorageTime="
				+ gujiStorageTime + ", updateTime=" + updateTime + ", deleteTime=" + deleteTime + ", dataStatus="
				+ dataStatus + ", remark=" + remark + ", status=" + status + "]";
	}

//	private String sTime;
//
//	private String rTime;




}
