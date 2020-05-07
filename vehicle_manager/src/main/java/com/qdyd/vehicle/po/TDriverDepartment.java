package com.qdyd.vehicle.po;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * @author 作者 : Czyer
 * @version 创建时间：2019年8月16日 
 * 类说明：驾驶员部门类
 */
@TableName(value = "t_driver")
public class TDriverDepartment {
	
	@TableId
	@TableField("department_id")
	private String departmentId;
	
	@TableField("department_num")
	private String departmentNum;
	
	@TableField("department_name")
	private String departmentName;

	@TableField("department_date")
	private Date departmentDate;

	@TableField("t_data_status")
	private Integer dataStatus;
	
	
	
	public TDriverDepartment() {
		super();
	}

	public TDriverDepartment(String departmentId, String departmentNum, String departmentName, Date departmentDate, Integer dataStatus) {
		this.departmentId = departmentId;
		this.departmentNum = departmentNum;
		this.departmentName = departmentName;
		this.departmentDate = departmentDate;
		this.dataStatus = dataStatus;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public Integer getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}



	public String getDepartmentNum() {
		return departmentNum;
	}



	public void setDepartmentNum(String departmentNum) {
		this.departmentNum = departmentNum;
	}



	public String getDepartmentName() {
		return departmentName;
	}



	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}



	public Date getDepartmentDate() {
		return departmentDate;
	}



	public void setDepartmentDate(Date departmentDate) {
		this.departmentDate = departmentDate;
	}



	@Override
	public String toString() {
		return "TDriverDepartment [departmentId=" + departmentId + ", departmentNum=" + departmentNum
				+ ", departmentName=" + departmentName + ", departmentDate=" + departmentDate + "]";
	}



	
	
	
	
}
