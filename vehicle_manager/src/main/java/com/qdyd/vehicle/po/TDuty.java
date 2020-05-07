package com.qdyd.vehicle.po;

import lombok.Data;

import java.util.Date;

@Data
public class TDuty {
    private String dutyId;
    private String dutyCompany;
    private Date dutyCreateDate;
    private String dutyWeek;
    private String dutyDate;
    private String dutyLeader;
    private String dutyMan;

    public TDuty(Object[] values){
        this.dutyCompany=values[1].toString();
        this.dutyDate=values[2].toString();
        this.dutyWeek=values[3].toString();
        this.dutyLeader=values[4].toString();
        this.dutyMan=values[5].toString();
    }

	public TDuty(String dutyId, String dutyCompany, Date dutyCreateDate, String dutyWeek, String dutyDate,
			String dutyLeader, String dutyMan) {
		super();
		this.dutyId = dutyId;
		this.dutyCompany = dutyCompany;
		this.dutyCreateDate = dutyCreateDate;
		this.dutyWeek = dutyWeek;
		this.dutyDate = dutyDate;
		this.dutyLeader = dutyLeader;
		this.dutyMan = dutyMan;
	}

	public TDuty() {
		super();
	}

	public String getDutyId() {
		return dutyId;
	}

	public void setDutyId(String dutyId) {
		this.dutyId = dutyId;
	}

	public String getDutyCompany() {
		return dutyCompany;
	}

	public void setDutyCompany(String dutyCompany) {
		this.dutyCompany = dutyCompany;
	}

	public Date getDutyCreateDate() {
		return dutyCreateDate;
	}

	public void setDutyCreateDate(Date dutyCreateDate) {
		this.dutyCreateDate = dutyCreateDate;
	}

	public String getDutyWeek() {
		return dutyWeek;
	}

	public void setDutyWeek(String dutyWeek) {
		this.dutyWeek = dutyWeek;
	}

	public String getDutyDate() {
		return dutyDate;
	}

	public void setDutyDate(String dutyDate) {
		this.dutyDate = dutyDate;
	}

	public String getDutyLeader() {
		return dutyLeader;
	}

	public void setDutyLeader(String dutyLeader) {
		this.dutyLeader = dutyLeader;
	}

	public String getDutyMan() {
		return dutyMan;
	}

	public void setDutyMan(String dutyMan) {
		this.dutyMan = dutyMan;
	}

	@Override
	public String toString() {
		return "TDuty [dutyId=" + dutyId + ", dutyCompany=" + dutyCompany + ", dutyCreateDate=" + dutyCreateDate
				+ ", dutyWeek=" + dutyWeek + ", dutyDate=" + dutyDate + ", dutyLeader=" + dutyLeader + ", dutyMan="
				+ dutyMan + "]";
	}
    
}
