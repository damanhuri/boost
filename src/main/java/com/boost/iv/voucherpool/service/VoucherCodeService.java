package com.boost.iv.voucherpool.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boost.iv.voucherpool.entity.Receipient;
import com.boost.iv.voucherpool.entity.VoucherCode;
import com.boost.iv.voucherpool.repo.ReceipientRepo;
import com.boost.iv.voucherpool.repo.VoucherCodeRepo;
import com.boost.iv.voucherpool.resource.VoucherCodeResource;

@Service
public class VoucherCodeService {

	Logger logger = LogManager.getLogger(VoucherCodeService.class);
	
	@Autowired
	private ReceipientRepo receipientRepo;
	
	@Autowired
	private VoucherCodeRepo voucherCodeRepo;
	
	public VoucherCodeResource useVoucherCode(VoucherCodeResource resource) {
		
		List<VoucherCode> result = voucherCodeRepo.findByCode(resource.getCode());
		
		if (result.size() == 0) {
			throw new EntityNotFoundException("Voucher code not found!");
		}

		VoucherCode voucherCode = result.get(0);
		if (!voucherCode.getReceipient().getEmail().equals(resource.getEmail())) {
			throw new EntityNotFoundException("Email is invalid for this code!");
		}

		voucherCode.setUsageDate(new Date());
		voucherCodeRepo.save(voucherCode);
		
		resource.setUsageDate(voucherCode.getUsageDate());
		resource.setDiscount(voucherCode.getSpecialOffer().getDiscount());
		
		return resource;
		
	}
	
	public List<VoucherCode> getVoucherCodes() {
	    return voucherCodeRepo.findAll();
	}
	
	public List<VoucherCodeResource> getVoucherCodes(String email) {
		
		List<Receipient> receipients = receipientRepo.findByEmail(email);
		
		if (receipients.size() == 0) {
			throw new EntityNotFoundException("Email is invalid!");
		}
		
		Receipient receipient = receipients.get(0);
		
		List<VoucherCode> voucherCodes = voucherCodeRepo.findByReceipient_Id(receipient.getId());
		
		List<VoucherCodeResource> resources = new ArrayList<VoucherCodeResource>();
		for (VoucherCode voucherCode : voucherCodes) {
			VoucherCodeResource resource = new VoucherCodeResource();
			resource.setCode(voucherCode.getCode());
			resource.setDiscount(voucherCode.getSpecialOffer().getDiscount());
			resource.setSpecialOfferName(voucherCode.getSpecialOffer().getName());
			resource.setEmail(voucherCode.getReceipient().getEmail());
			resource.setUsageDate(voucherCode.getUsageDate());
			
			resources.add(resource);
		}
		return resources;
	}
	
}
