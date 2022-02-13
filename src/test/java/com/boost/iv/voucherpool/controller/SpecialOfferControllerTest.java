package com.boost.iv.voucherpool.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.boost.iv.voucherpool.controller.SpecialOfferController;
import com.boost.iv.voucherpool.entity.SpecialOffer;
import com.boost.iv.voucherpool.repo.ReceipientRepo;
import com.boost.iv.voucherpool.repo.SpecialOfferRepo;
import com.boost.iv.voucherpool.repo.VoucherCodeRepo;
import com.boost.iv.voucherpool.service.SpecialOfferService;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {SpecialOfferController.class, SpecialOfferService.class})
@WebMvcTest
public class SpecialOfferControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
    @Autowired
    ObjectMapper mapper;
    
    @MockBean
    SpecialOfferRepo specialOfferRepo;
    
    @MockBean
    ReceipientRepo receipientRepo;
    
    @MockBean
    VoucherCodeRepo voucherCodeRepo;
    
    @Test
    public void testCreateSpecialOffer() throws Exception {
    	createSpecialOffer(new SpecialOffer("CNY Promotion", new Float(17.5)));
    }
    
    public void createSpecialOffer(SpecialOffer so) throws Exception {
    	   mockMvc.perform(MockMvcRequestBuilders.post("/api/specialoffers")
    			   .content(asJsonString(so))
                   .contentType(MediaType.APPLICATION_JSON)
                   .accept(MediaType.APPLICATION_JSON))
    			   .andExpect(status().isCreated());

    }
    
    public static String asJsonString(final Object obj) {
        try {
          return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    
}
