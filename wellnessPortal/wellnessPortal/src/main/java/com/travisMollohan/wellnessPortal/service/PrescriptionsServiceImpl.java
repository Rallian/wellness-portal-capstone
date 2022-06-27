package com.travisMollohan.wellnessPortal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travisMollohan.wellnessPortal.dao.PrescriptionsRepository;
import com.travisMollohan.wellnessPortal.entity.Prescriptions;

@Service
public class PrescriptionsServiceImpl implements PrescriptionsService {

	private PrescriptionsRepository prescriptionsRepository;
	
	@Autowired
	public PrescriptionsServiceImpl(PrescriptionsRepository thePrescriptionsRepository) {
		prescriptionsRepository = thePrescriptionsRepository;
	}
	
	@Override
	public List<Prescriptions> findAll() {
		return prescriptionsRepository.findAll();
	}

	@Override
	public Prescriptions findById(int id) {
		Optional<Prescriptions> result = prescriptionsRepository.findById(id);
		Prescriptions thePrescription = null;
		if(result.isPresent()) {
			thePrescription = result.get();
		} else {
			throw new RuntimeException("No Prescrition by that Id found");
		}
		return thePrescription;
	}

}
