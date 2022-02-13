package com.boost.iv.voucherpool.resource;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SpecialOfferResource {
	
	private String name;
	
	private Float discount;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date expirationDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

}
