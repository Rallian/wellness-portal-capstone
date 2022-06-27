package com.travisMollohan.wellnessPortal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.travisMollohan.wellnessPortal.dao.InsuranceRepository;
import com.travisMollohan.wellnessPortal.entity.Insurance;
import com.travisMollohan.wellnessPortal.service.InsuranceService;

@SpringBootTest
public class InsuranceServiceTest {
	
	@Autowired
	InsuranceService insuranceService;
	
	@Autowired
	InsuranceRepository iRepo;
	
	@Test
	public void findInsuranceTest() {
		Insurance insurance = insuranceService.findById(3);
		System.out.println(insurance.getPlanName());
		Assertions.assertTrue(insurance.getMonthlyCost() == 300);
	}
	
	@Test
	public void createNewPlanTest() {
		Insurance insurance = new Insurance("Platinum", 600.00, 1000.00);
		iRepo.save(insurance);
		Assertions.assertTrue(iRepo.findByPlanName("Platinum").getMonthlyCost() == 600);
	}
	
	@Test
	public void deletePlan() {
		iRepo.deleteById(iRepo.findByPlanName("Platinum").getId());
		Assertions.assertTrue(iRepo.findByPlanName("Platinum") == null);
	}

}
