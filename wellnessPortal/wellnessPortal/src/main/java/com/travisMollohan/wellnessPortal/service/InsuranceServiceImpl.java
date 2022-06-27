package com.travisMollohan.wellnessPortal.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travisMollohan.wellnessPortal.dao.InsuranceRepository;
import com.travisMollohan.wellnessPortal.entity.Insurance;

@Service
public class InsuranceServiceImpl implements InsuranceService {

	private InsuranceRepository insuranceRepository;
	
	@Autowired
	public InsuranceServiceImpl(InsuranceRepository theInsuranceRepository) {
		insuranceRepository = theInsuranceRepository;
	}
	
	@Override
	public List<Insurance> findAll() {
		return insuranceRepository.findAll();
	}

	@Override
	public Insurance findById(int id) {
		Optional<Insurance> result = insuranceRepository.findById(id);
		Insurance theInsurance = null;
		if(result.isPresent()) {
			theInsurance = result.get();
		} else {
			throw new RuntimeException("No insurance with that id found");
		}
		return theInsurance;
	}

}
