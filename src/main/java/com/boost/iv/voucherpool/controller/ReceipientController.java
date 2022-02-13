package com.boost.iv.voucherpool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boost.iv.voucherpool.entity.Receipient;
import com.boost.iv.voucherpool.service.ReceipientService;

@RestController
@RequestMapping("/api")
public class ReceipientController {
	
	@Autowired
	private ReceipientService receipientService;

	@RequestMapping(value="/receipients", method=RequestMethod.POST)
	public ResponseEntity<Receipient> createReceipient(@RequestBody Receipient resource) {
	    Receipient receipient = receipientService.createReceipient(resource);

	    return new ResponseEntity<>(receipient, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/receipients", method=RequestMethod.GET)
	public List<Receipient> readReceipients() {
	    return receipientService.getReceipients();
	}
	
}
