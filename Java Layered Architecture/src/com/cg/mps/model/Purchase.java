package com.cg.mps.model;

import java.util.Date;

public class Purchase {

	private int purchaseId;
	private String customer_name;
	private String mailId;
	private long phoneNo;
	private int mobileId;
	private Date purchaseDate;
	public Purchase(String customer_name, String mailId, long phoneNo, int mobileId) {
		super();
		this.customer_name = customer_name;
		this.mailId = mailId;
		this.phoneNo = phoneNo;
		this.mobileId = mobileId;
	}
	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getMobileId() {
		return mobileId;
	}
	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	@Override
	public String toString() {
		return "Purchase [customer_name=" + customer_name + ", mailId=" + mailId + ", phoneNo=" + phoneNo
				+ ", mobileId=" + mobileId + "]";
	}

	
}
