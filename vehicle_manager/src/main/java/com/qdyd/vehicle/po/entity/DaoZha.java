package com.qdyd.vehicle.po.entity;
/**
 * @author 作者 : Czyer
 * @version 创建时间：2019年9月4日 
 * 类说明：
 */
public class DaoZha {
		private Integer code;
		private String errDesc;
		public DaoZha(Integer code, String errDesc) {
			super();
			this.code = code;
			this.errDesc = errDesc;
		}
		@Override
		public String toString() {
			return "DaoZha [code=" + code + ", errDesc=" + errDesc + "]";
		}
		public Integer getCode() {
			return code;
		}
		public void setCode(Integer code) {
			this.code = code;
		}
		public String getErrDesc() {
			return errDesc;
		}
		public void setErrDesc(String errDesc) {
			this.errDesc = errDesc;
		}
		
		
		
}
