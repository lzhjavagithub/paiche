package com.qdyd.vehicle.po;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

@Data
public class PaicheRecord {

    private String paicheno;//派车单号
    private String paichedate;//开单日期
    private String department;//用车人部门
    private String useMan;//用车人
    private String cause;//用车事由
    private String man;//人数
    private String weight;//载重
    private String destination;//目的地
    private String carNo;//车牌号
    private String carType;//车辆类型
    private String driverName;//驾驶员
    private String comMander;//派车人
    private String auditLeaderShip;//审核领导

	private String gujistorageTime;//估计出场时间
	private String gujireturnTime;//估计回场时间

    private String storageTime;//开车时间
    private String returnTime;//回厂时间
    private String drivingTime;//行车时间
    private Integer mileage;//行驶里程
    private Integer status;
	public PaicheRecord(String paicheno, String paichedate, String department, String useMan, String cause, String man,
			String weight, String destination, String carNo, String carType, String driverName, String comMander,
			String auditLeaderShip, String storageTime, String returnTime, String drivingTime, Integer mileage,
			Integer status) {
		super();
		this.paicheno = paicheno;
		this.paichedate = paichedate;
		this.department = department;
		this.useMan = useMan;
		this.cause = cause;
		this.man = man;
		this.weight = weight;
		this.destination = destination;
		this.carNo = carNo;
		this.carType = carType;
		this.driverName = driverName;
		this.comMander = comMander;
		this.auditLeaderShip = auditLeaderShip;
		this.storageTime = storageTime;
		this.returnTime = returnTime;
		this.drivingTime = drivingTime;
		this.mileage = mileage;
		this.status = status;
	}
	public PaicheRecord() {
		super();
	}
	public String getPaicheno() {
		return paicheno;
	}
	public void setPaicheno(String paicheno) {
		this.paicheno = paicheno;
	}
	public String getPaichedate() {
		return paichedate;
	}
	public void setPaichedate(String paichedate) {
		this.paichedate = paichedate;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getUseMan() {
		return useMan;
	}
	public void setUseMan(String useMan) {
		this.useMan = useMan;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public String getMan() {
		return man;
	}
	public void setMan(String man) {
		this.man = man;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
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
	public String getStorageTime() {
		return storageTime;
	}
	public void setStorageTime(String storageTime) {
		this.storageTime = storageTime;
	}
	public String getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}
	public String getDrivingTime() {
		return drivingTime;
	}
	public void setDrivingTime(String drivingTime) {
		this.drivingTime = drivingTime;
	}
	public Integer getMileage() {
		return mileage;
	}
	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "PaicheRecord [paicheno=" + paicheno + ", paichedate=" + paichedate + ", department=" + department
				+ ", useMan=" + useMan + ", cause=" + cause + ", man=" + man + ", weight=" + weight + ", destination="
				+ destination + ", carNo=" + carNo + ", carType=" + carType + ", driverName=" + driverName
				+ ", comMander=" + comMander + ", auditLeaderShip=" + auditLeaderShip + ", storageTime=" + storageTime
				+ ", returnTime=" + returnTime + ", drivingTime=" + drivingTime + ", mileage=" + mileage + ", status="
				+ status + "]";
	}


}
