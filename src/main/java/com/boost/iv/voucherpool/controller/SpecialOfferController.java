package com.boost.iv.voucherpool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boost.iv.voucherpool.entity.SpecialOffer;
import com.boost.iv.voucherpool.resource.SpecialOfferResource;
import com.boost.iv.voucherpool.service.SpecialOfferService;

@RestController
@RequestMapping("/api")
public class SpecialOfferController {
	
	@Autowired
	private SpecialOfferService specialOfferService;

	@RequestMapping(value="/specialoffers", method=RequestMethod.POST)
	public ResponseEntity<SpecialOffer> createSpecialOffer(@RequestBody SpecialOfferResource resource) {
	    SpecialOffer specialOffer = specialOfferService.createSpecialOffer(resource);
	    
	    return new ResponseEntity<SpecialOffer>(specialOffer, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/specialoffers", method=RequestMethod.GET)
	public List<SpecialOffer> readSpecialOffers() {
	    return specialOfferService.getSpecialOffers();
	}

}
