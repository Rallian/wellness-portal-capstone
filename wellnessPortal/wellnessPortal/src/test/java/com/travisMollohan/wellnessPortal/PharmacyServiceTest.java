package com.travisMollohan.wellnessPortal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.travisMollohan.wellnessPortal.service.PharmacyService;

@SpringBootTest
public class PharmacyServiceTest {

	@Autowired
	PharmacyService pharmacyService;
	
	@Test
	public void findPharmacys() {
	Assertions.assertTrue(pharmacyService.findAll().size() > 0);
	}
	
}
