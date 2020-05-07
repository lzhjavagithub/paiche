package com.qdyd.vehicle.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 作者 : Czyer
 * @version 创建时间：2019年8月12日 下午12:14:57 
 * 类说明：用户表
 */
@Entity
@Table(name = "t_user")
public class TUser {
	@Id
	@Column(name ="id")
	private String id;

	@Column(name ="username")
	private String userName;

	@Column(name ="account")
	private String account;

	@Column(name ="password")
	private String passWord;

	@Column(name ="t_data_status")
	private Integer dataStatus;

	@Column(name ="t_remark")
	private String remark;

	@Column(name ="t_per")
	private Integer per;

	public TUser() {
		super();
	}

	public TUser(String id, String userName, String account, String passWord, Integer dataStatus, String remark,Integer per) {
		super();
		this.id = id;
		this.userName = userName;
		this.account = account;
		this.passWord = passWord;
		this.dataStatus = dataStatus;
		this.remark = remark;
		this.per=per;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
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

	public Integer getPer() { return per; }

	public void setPer(Integer per) { this.per = per; }

}
