package com.boost.iv.voucherpool.resource;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class VoucherCodeResource {
	
	private String code;
	
	private String email;
	
	private Float discount;
	
	private String specialOfferName;
	
	public VoucherCodeResource() { super(); }
	
	public VoucherCodeResource(String code, String email) {
		this.code = code;
		this.email = email;
	}

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date usageDate;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Date getUsageDate() {
		return usageDate;
	}

	public void setUsageDate(Date usageDate) {
		this.usageDate = usageDate;
	}

	public String getSpecialOfferName() {
		return specialOfferName;
	}

	public void setSpecialOfferName(String specialOfferName) {
		this.specialOfferName = specialOfferName;
	}

	
}
