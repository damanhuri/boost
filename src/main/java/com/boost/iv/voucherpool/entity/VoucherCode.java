package com.boost.iv.voucherpool.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "voucher_code")
public class VoucherCode {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="code")
    private String code;

	@ManyToOne(optional=false)
	@JoinColumn(name = "receipient_id", referencedColumnName="id")
	private Receipient receipient;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "special_offer_id", referencedColumnName="id")
	private SpecialOffer specialOffer;
    
    @Column(name="expiry_date")
    private Date expiryDate;
    
    @Column(name="usage_date")
    private Date usageDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Receipient getReceipient() {
		return receipient;
	}

	public void setReceipient(Receipient receipient) {
		this.receipient = receipient;
	}

	public SpecialOffer getSpecialOffer() {
		return specialOffer;
	}

	public void setSpecialOffer(SpecialOffer specialOffer) {
		this.specialOffer = specialOffer;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getUsageDate() {
		return usageDate;
	}

	public void setUsageDate(Date usageDate) {
		this.usageDate = usageDate;
	}
    
}
