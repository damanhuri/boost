package com.boost.iv.voucherpool.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boost.iv.voucherpool.entity.Receipient;
import com.boost.iv.voucherpool.entity.SpecialOffer;
import com.boost.iv.voucherpool.entity.VoucherCode;
import com.boost.iv.voucherpool.repo.ReceipientRepo;
import com.boost.iv.voucherpool.repo.SpecialOfferRepo;
import com.boost.iv.voucherpool.repo.VoucherCodeRepo;
import com.boost.iv.voucherpool.resource.SpecialOfferResource;

@Service
public class SpecialOfferService {
	
	@Autowired
	private SpecialOfferRepo specialOfferRepo;

	@Autowired
	private ReceipientRepo receipientRepo;

	@Autowired
	private VoucherCodeRepo voucherCodeRepo;
	
	public SpecialOffer createSpecialOffer(SpecialOfferResource resource) {
		
		SpecialOffer entity = new SpecialOffer(resource.getName(), resource.getDiscount());
		SpecialOffer savedSpecialOffer = specialOfferRepo.save(entity);
		
		if (null != savedSpecialOffer) {
			List<Receipient> allReceipients = receipientRepo.findAll();
			
			for (Receipient receipient : allReceipients) {
				
				VoucherCode voucherCode = new VoucherCode();
				voucherCode.setCode(UUID.randomUUID().toString().replaceAll("-", ""));
				voucherCode.setExpiryDate(resource.getExpirationDate());
				voucherCode.setReceipient(receipient);
				voucherCode.setSpecialOffer(savedSpecialOffer);
				
				voucherCodeRepo.save(voucherCode);
			}
		}
		
		return savedSpecialOffer;
	}

	public List<SpecialOffer> getSpecialOffers() {
	    return specialOfferRepo.findAll();
	}
	
}
