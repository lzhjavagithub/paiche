package com.qdyd.vehicle.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 作者 : Czyer
 * @version 创建时间：2019年8月12日 下午12:03:03 
 * 类说明：派车车辆表
 */
@Entity
@Table(name = "t_paiche_car")
public class TPaiCheCar {
	@Id
	@Column(name ="id")
	private String id;

	@Column(name ="t_paiche_id")
	private String paiCheId;

	@Column(name ="t_car_id")
	private String carId;

	public TPaiCheCar() {
		super();
	}

	public TPaiCheCar(String id, String paiCheId, String carId) {
		super();
		this.id = id;
		this.paiCheId = paiCheId;
		this.carId = carId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPaiCheId() {
		return paiCheId;
	}

	public void setPaiCheId(String paiCheId) {
		this.paiCheId = paiCheId;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

}
