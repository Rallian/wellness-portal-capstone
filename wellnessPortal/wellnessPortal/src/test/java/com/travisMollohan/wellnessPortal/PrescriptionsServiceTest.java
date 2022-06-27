package com.travisMollohan.wellnessPortal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.travisMollohan.wellnessPortal.service.PrescriptionsService;

@SpringBootTest
public class PrescriptionsServiceTest {

	
	@Autowired
	PrescriptionsService psService;
	
	@Test
	public void findAllPrescriptions() {
		Assertions.assertTrue(psService.findAll().size() > 0);
	}
}
