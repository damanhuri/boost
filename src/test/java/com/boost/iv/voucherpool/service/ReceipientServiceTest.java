package com.boost.iv.voucherpool.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.boost.iv.voucherpool.entity.Receipient;
import com.boost.iv.voucherpool.repo.ReceipientRepo;


//@SpringBootTest(classes = ReceipientService.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ExtendWith(MockitoExtension.class)
public class ReceipientServiceTest {
	
	@InjectMocks
    ReceipientService receipientService;
    
    @Mock
    ReceipientRepo receipientRepo;
    
    @Test
    public void testCreateReceipient() throws Exception {
    	
    	Receipient receipient = new Receipient(null, "Ahmad", "ahmad@gmail.com");
    	receipientService.createReceipient(receipient);

        verify(receipientRepo, times(1)).save(receipient);
    	
    }
    
    
}
