package com.example.prime.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prime {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long customerId;
	private String customerName;
	private long payment;
	private boolean notification;
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getPayment() {
		return payment;
	}
	public void setPayment(long payment) {
		this.payment = payment;
	}
	public boolean isNotification() {
		return notification;
	}
	public void setNotification(boolean notification) {
		this.notification = notification;
	}
	public Prime(long customerId, String customerName, long payment, boolean notification) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.payment = payment;
		this.notification = notification;
	}
	public Prime() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Prime [customerId=" + customerId + ", customerName=" + customerName + ", payment=" + payment
				+ ", notification=" + notification + "]";
	}
	

}
