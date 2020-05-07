package com.qdyd.vehicle.po;

public class Expert {
    private Integer expertId; //专家id
    private String imgUrl; //专家头像
    private String expert_name; //专家姓名
    private String tag; //标签
    private String job; //工作详情
    private String tips; //提示
    private Integer consultNum;// 咨询人数 暂无

    public Integer getExpertId() {
        return expertId;
    }

    public void setExpertId(Integer expertId) {
        this.expertId = expertId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getExpert_name() {
        return expert_name;
    }

    public void setExpert_name(String expert_name) {
        this.expert_name = expert_name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public Integer getConsultNum() {
        return consultNum;
    }

    public void setConsultNum(Integer consultNum) {
        this.consultNum = consultNum;
    }
}
