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

import com.boost.iv.voucherpool.controller.ReceipientController;
import com.boost.iv.voucherpool.entity.Receipient;
import com.boost.iv.voucherpool.repo.ReceipientRepo;
import com.boost.iv.voucherpool.service.ReceipientService;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {ReceipientController.class, ReceipientService.class})
@WebMvcTest
public class ReceipientControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
    @Autowired
    ObjectMapper mapper;
    
    @MockBean
    ReceipientRepo receipientRepo;
    
    @Test
    public void testCreateReceipient() throws Exception {
    	createReceipient(new Receipient(null, "Ali", "ali@gmail.com"));
    }
    
    public void createReceipient(Receipient r) throws Exception {
    	   mockMvc.perform(MockMvcRequestBuilders.post("/api/receipients")
    			   .content(asJsonString(r))
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
