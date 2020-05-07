package com.qdyd.vehicle.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 作者 : Czyer
 * @version 创建时间：2019年8月12日 下午12:12:17 
 * 类说明：派车驾驶员表
 */
@Entity
@Table(name = "t_paiche_driver")
public class TPaiCheDriver {
	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "t_paiche_id")
	private String paiCheId;

	@Column(name = "t_driver_id")
	private String driverId;

	public TPaiCheDriver() {
		super();
	}

	public TPaiCheDriver(String id, String paiCheId, String driverId) {
		super();
		this.id = id;
		this.paiCheId = paiCheId;
		this.driverId = driverId;
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

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

}
