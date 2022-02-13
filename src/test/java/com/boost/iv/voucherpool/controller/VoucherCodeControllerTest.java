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

import com.boost.iv.voucherpool.repo.ReceipientRepo;
import com.boost.iv.voucherpool.repo.VoucherCodeRepo;
import com.boost.iv.voucherpool.resource.VoucherCodeResource;
import com.boost.iv.voucherpool.service.VoucherCodeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {VoucherCodeController.class})
@WebMvcTest
public class VoucherCodeControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
    @Autowired
    ObjectMapper mapper;

    @MockBean
    VoucherCodeService voucherCodeService;
    
    @MockBean
    ReceipientRepo receipientRepo;
    
    @MockBean
    VoucherCodeRepo voucherCodeRepo;
    
    @Test
    public void testUseVoucherCode() throws Exception {
    	useVoucherCode(new VoucherCodeResource("1df64495bf404605b231d6016db154eb", "ali@gmail.com"));
    }
    
    public void useVoucherCode(VoucherCodeResource resource) throws Exception {
    	   mockMvc.perform(MockMvcRequestBuilders.post("/api/vouchercodes")
    			   .content(asJsonString(resource))
                   .contentType(MediaType.APPLICATION_JSON)
                   .accept(MediaType.APPLICATION_JSON))
    			   .andExpect(status().isOk());
    }
    
    public static String asJsonString(final Object obj) {
        try {
          return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    
}
