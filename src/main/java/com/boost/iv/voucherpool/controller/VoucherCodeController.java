package com.boost.iv.voucherpool.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boost.iv.voucherpool.entity.VoucherCode;
import com.boost.iv.voucherpool.resource.VoucherCodeResource;
import com.boost.iv.voucherpool.service.VoucherCodeService;

@RestController
@RequestMapping("/api")
public class VoucherCodeController {

	Logger logger = LogManager.getLogger(VoucherCodeController.class);
	
	@Autowired
	private VoucherCodeService voucherCodeService;

	@RequestMapping(value="/vouchercodes", method=RequestMethod.POST)
	public ResponseEntity<VoucherCodeResource> useVoucherCode(@RequestBody VoucherCodeResource resource) {
	    VoucherCodeResource result = voucherCodeService.useVoucherCode(resource);
		
		return new ResponseEntity<VoucherCodeResource>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value="/vouchercodes", method=RequestMethod.GET)
	public List<VoucherCode> getAllVoucherCodes() {
	    return voucherCodeService.getVoucherCodes();
	}
	
	@RequestMapping(value="/vouchercodes/email/{emailAddr}", method=RequestMethod.GET)
	public Object getVoucherCodesByEmail(@PathVariable String emailAddr) {
	    List<VoucherCodeResource> result = voucherCodeService.getVoucherCodes(emailAddr);

		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}

}
