package com.qdyd.vehicle.po;
/**
 * @author 作者 : Czyer
 * @version 创建时间：2019年9月3日 
 * 类说明：hk车闸接口请求格式
  	请求数据
   {
	"parkCode" : "6DEA23BC2376F1",
	"plateNo" : "浙 A8888",
	"passTime" : "20181211094656200",
	"vehType" : 0
	}
	返回数据
	{
	"code": 0
	"errDesc":"放行"
	}

 */
public class HkPms {
		private String parkCode;//停车场编号
		private String plateNo;//车牌号
		private String passTime;//车辆通行时间
		private int vehType;//车辆类型
		public HkPms() {
			super();
		}
		
		

		public String getParkCode() {
			return parkCode;
		}



		public void setParkCode(String parkCode) {
			this.parkCode = parkCode;
		}



		public String getPlateNo() {
			return plateNo;
		}



		public void setPlateNo(String plateNo) {
			this.plateNo = plateNo;
		}



		public String getPassTime() {
			return passTime;
		}



		public void setPassTime(String passTime) {
			this.passTime = passTime;
		}



		public int getVehType() {
			return vehType;
		}



		public void setVehType(int vehType) {
			this.vehType = vehType;
		}



		public HkPms(String parkCode, String plateNo, String passTime, int vehType) {
			super();
			this.parkCode = parkCode;
			this.plateNo = plateNo;
			this.passTime = passTime;
			this.vehType = vehType;
		}



		@Override
		public String toString() {
			return "HkPms [parkCode=" + parkCode + ", plateNo=" + plateNo + ", passTime=" + passTime + ", vehType="
					+ vehType + "]";
		}
		
		
}
