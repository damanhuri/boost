package com.boost.iv.voucherpool.service;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.boost.iv.voucherpool.entity.SpecialOffer;
import com.boost.iv.voucherpool.resource.SpecialOfferResource;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SpecialOfferServiceTest {
	
	@Autowired
    SpecialOfferService specialOfferService;
    
    @BeforeAll
    void setUp() {
    	SpecialOfferResource specialOffer = new SpecialOfferResource();
    	specialOffer.setName("CNY Offer");
    	specialOffer.setDiscount(new Float(12.5));
    	specialOffer.setExpirationDate(new Date());
    	specialOfferService.createSpecialOffer(specialOffer);
    }
    
    @Test
    void testFindAll() {
        Assertions.assertFalse(specialOfferService.getSpecialOffers().isEmpty());
    }
    
    @Test
    public void testCreateSpecialOffer() throws Exception {

    	List<SpecialOffer> result = specialOfferService.getSpecialOffers();
    	Assertions.assertEquals("CNY Offer", result.get(0).getName());
    	
    }
    
    
}
