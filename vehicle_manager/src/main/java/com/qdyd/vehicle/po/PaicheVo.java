package com.qdyd.vehicle.po;

import lombok.Data;

import java.util.Date;

@Data
public class PaicheVo {

    private String paicheId;//'要删除的id'
    private String no;
    private Date date;
    private String useMan;
    private String deptId;
    private String cause;
    private Integer weight;
    private String carId;
    private String driverId;
    private String destination;
    private String driveTime;
    private Integer goMileage;
    private Integer comeMileage;
    private Integer mileage;
    private String comMander;
    private String auditLeaderShip;
    // 实际返场时间
    private String returnTime;
    // 实际出场时间
    private String storageTime;
    private String gujiRetureTime;
    private String gujiStorageTime;
    private String remark;

    private String useName;
    private String driverName;
    private String matter;
    private String carNo;
    private String desName;
    private Integer dataStatus;
    private String carType;
    private String carTypeId;

	public PaicheVo(String paicheId, String no, Date date, String useMan, String deptId, String cause, Integer weight, String carId, String driverId, String destination, String driveTime, Integer goMileage, Integer comeMileage, Integer mileage, String comMander, String auditLeaderShip, String returnTime, String storageTime, String gujiRetureTime, String gujiStorageTime, String remark, String useName, String driverName, String matter, String carNo, String desName, Integer dataStatus, String carType, String carTypeId) {
		this.paicheId = paicheId;
		this.no = no;
		this.date = date;
		this.useMan = useMan;
		this.deptId = deptId;
		this.cause = cause;
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
		this.remark = remark;
		this.useName = useName;
		this.driverName = driverName;
		this.matter = matter;
		this.carNo = carNo;
		this.desName = desName;
		this.dataStatus = dataStatus;
		this.carType = carType;
		this.carTypeId = carTypeId;
	}

	public PaicheVo() {
		super();
	}

	public String getCarTypeId() {
		return carTypeId;
	}

	public void setCarTypeId(String carTypeId) {
		this.carTypeId = carTypeId;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getUseName() {
		return useName;
	}
	public void setUseName(String useName) {
		this.useName = useName;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getMatter() {
		return matter;
	}
	public void setMatter(String matter) {
		this.matter = matter;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getDesName() {
		return desName;
	}
	public void setDesName(String desName) {
		this.desName = desName;
	}
	public Integer getDataStatus() {
		return dataStatus;
	}
	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	@Override
	public String toString() {
		return "PaicheVo [paicheId=" + paicheId + ", no=" + no + ", date=" + date + ", useMan=" + useMan + ", deptId="
				+ deptId + ", cause=" + cause + ", weight=" + weight + ", carId=" + carId + ", driverId=" + driverId
				+ ", destination=" + destination + ", driveTime=" + driveTime + ", goMileage=" + goMileage
				+ ", comeMileage=" + comeMileage + ", mileage=" + mileage + ", comMander=" + comMander
				+ ", auditLeaderShip=" + auditLeaderShip + ", returnTime=" + returnTime + ", storageTime=" + storageTime
				+ ", gujiRetureTime=" + gujiRetureTime + ", gujiStorageTime=" + gujiStorageTime + ", remark=" + remark
				+ ", useName=" + useName + ", driverName=" + driverName + ", matter=" + matter + ", carNo=" + carNo
				+ ", desName=" + desName + ", dataStatus=" + dataStatus + ", carType=" + carType + "]";
	}

}
