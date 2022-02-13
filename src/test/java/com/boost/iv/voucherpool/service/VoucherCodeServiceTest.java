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
import com.boost.iv.voucherpool.entity.VoucherCode;
import com.boost.iv.voucherpool.resource.SpecialOfferResource;
import com.boost.iv.voucherpool.resource.VoucherCodeResource;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class VoucherCodeServiceTest {
	
	@Autowired
    VoucherCodeService voucherCodeService;
    
    @BeforeAll
    void setUp() {
    	VoucherCodeResource resource = new VoucherCodeResource("1df64495bf404605b231d6016db154eb", "ali@gmail.com");
    	voucherCodeService.useVoucherCode(resource);
    }
    
    @Test
    void testFindAll() {
        Assertions.assertFalse(voucherCodeService.getVoucherCodes().isEmpty());
    }
    
    @Test
    public void testUseVoucherCode() throws Exception {

    	List<VoucherCode> result = voucherCodeService.getVoucherCodes();
    	Assertions.assertEquals("1df64495bf404605b231d6016db154eb", result.get(0).getCode());
    	Assertions.assertEquals("ali@gmail.com", result.get(0).getReceipient().getEmail());
    	
    }
    
    @Test
    public void testGetByEmail() throws Exception {

    	List<VoucherCodeResource> result = voucherCodeService.getVoucherCodes("ali@gmail.com");
    	Assertions.assertEquals("1df64495bf404605b231d6016db154eb", result.get(0).getCode());
    	Assertions.assertEquals("ali@gmail.com", result.get(0).getEmail());
    	
    }
    
    
}
