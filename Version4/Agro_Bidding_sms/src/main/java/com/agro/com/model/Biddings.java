package com.agro.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Biddings")
public class Biddings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bid;
	
	@Column(name="pid")
	private long pid;
	
	@Column(name="bid_price")
	private float bid_price;
	
	@Column(name="buyerId")
	private	String buyerId;

	public long getBid() {
		return bid;
	}

	public void setBid(long bid) {
		this.bid = bid;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public float getBid_price() {
		return bid_price;
	}

	public void setBid_price(float bid_price) {
		this.bid_price = bid_price;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	
	public Biddings() {
		// TODO Auto-generated constructor stub
	}

	public Biddings(long bid, long pid, float bid_price, String buyerId) {
		super();
		this.bid = bid;
		this.pid = pid;
		this.bid_price = bid_price;
		this.buyerId = buyerId;
	}
	
	
}
