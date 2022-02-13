package com.boost.iv.voucherpool.service;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boost.iv.voucherpool.entity.Receipient;
import com.boost.iv.voucherpool.repo.ReceipientRepo;

@Service
public class ReceipientService {
	
	@Autowired
	private ReceipientRepo receipientRepo;
	
	public Receipient createReceipient(Receipient receipient) {
		
		List<Receipient> result = receipientRepo.findByEmail(receipient.getEmail());
		
		if (result.size() > 0) {
			throw new ConstraintViolationException("Email already exist!", null, "");
		}
		
		return receipientRepo.save(receipient);
	}

	public List<Receipient> getReceipients() {
	    return receipientRepo.findAll();
	}
	
}
