package com.qdyd.vehicle.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author 作者 : Czyer
 * @version 创建时间：2019年8月15日 类说明：车辆类型类
 */
@TableName(value = "t_car_type")
public class TCarType {

	@TableId
	@TableField("car_type_id")
	private String carTypeId;

	@TableField("type_num")
	private String typeNum;

	@TableField("type_name")
	private String typeName;

	public TCarType() {
		super();
	}

	public TCarType(String carTypeId, String typeNum, String typeName) {
		super();
		this.carTypeId = carTypeId;
		this.typeNum = typeNum;
		this.typeName = typeName;
	}

	public String getCarTypeId() {
		return carTypeId;
	}

	public void setCarTypeId(String carTypeId) {
		this.carTypeId = carTypeId;
	}

	public String getTypeNum() {
		return typeNum;
	}

	public void setTypeNum(String typeNum) {
		this.typeNum = typeNum;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "TCarType [carTypeId=" + carTypeId + ", typeNum=" + typeNum + ", typeName=" + typeName + "]";
	}

}
