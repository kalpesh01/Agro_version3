package com.agro.com.model;

import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity(name="farmer")
@Table(name="farmer")

public class Farmer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pid=100;
	
	@Column(name="pname")
	private String pname;
	
	//pimage
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String img;
	
	//pprice
	@Column(name="minPrice")
	private double minPrice;
	
	//pbdate
	@Column(name="endBDate")
	private Date endBDate;
	
	//pquantity
	@Column(name="quantity")
	private double quantity;
	
	@Column(name="status")
	private boolean status=false;
	
	@Column(name="highestBid")
	private double highestBid=0.0;
	
	@Column(name="winnerId")
	private String winnerId;
	
//	@ManyToOne(fetch =FetchType.LAZY)
//	@JoinColumn(name="uid",referencedColumnName = "id")
//	private User user;
	
	public String getWinnerId() {
		return winnerId;
	}
	
	@Override
	public String toString() {
		return "Farmer [pid=" + pid + ", pname=" + pname + ", img=" + img + ", minPrice=" + minPrice + ", endBDate="
				+ endBDate + ", quantity=" + quantity + ", status=" + status + ", highestBid=" + highestBid
				+ ", winnerId=" + winnerId + ", uid=" + uid + "]";
	}

	public void setWinnerId(String winnerId) {
		this.winnerId = winnerId;
	}

	@Column(name="uid")
private String uid;

	public Farmer() {
		
	}

	
	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getImg() {
		return img;
	}

	
	public void setImg(String img) {
		this.img = img;
	}

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	public Date getEndBDate() {
		return endBDate;
	}

	public void setEndBDate(Date endBDate) {
		this.endBDate = endBDate;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public double getHighestBid() {
		return highestBid;
	}

	public void setHighestBid(double highestBid) {
		this.highestBid = highestBid;
	}


	public String getUid() {
		return uid;
	}


	public void setUid(String uid) {
		this.uid = uid;
	}


	public Farmer(long pid, String pname, String img, double minPrice, Date endBDate, double quantity, boolean status,
			double highestBid, String uid) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.img = img;
		this.minPrice = minPrice;
		this.endBDate = endBDate;
		this.quantity = quantity;
		this.status = status;
		this.highestBid = highestBid;
		this.uid = uid;
	}






	




	



	

	
	
		
}
