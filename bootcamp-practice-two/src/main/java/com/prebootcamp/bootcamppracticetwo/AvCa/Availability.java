package com.prebootcamp.bootcamppracticetwo.AvCa;

import java.util.Date;

public class Availability {
	
	private String storeNo;
	private String productId;
	private Date date;
	private Double availQty;
	
	
	public Availability() {}
	public Availability(String storeNo, String productId, Date date, Double availQty) {
		super();
		this.storeNo = storeNo;
		this.productId = productId;
		this.date = date;
		this.availQty = availQty;
	}
	public Availability(String storeNo, Date date) {
		super();
		this.storeNo = storeNo;
		this.date = date;
	}
	public String getStoreNo() {
		return storeNo;
	}
	@Override
	public String toString() {
		return "Availability [storeNo=" + storeNo + ", productId=" + productId + ", date=" + date + ", availQty="
				+ availQty + "]";
	}
	public void setStoreNo(String storeNo) {
		this.storeNo = storeNo;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getAvailQty() {
		return availQty;
	}
	public void setAvailQty(Double availQty) {
		this.availQty = availQty;
	}
	

}
