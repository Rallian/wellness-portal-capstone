package com.travisMollohan.wellnessPortal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travisMollohan.wellnessPortal.dao.PharmacyRepository;
import com.travisMollohan.wellnessPortal.entity.Pharmacy;

@Service
public class PharmacyServiceImpl implements PharmacyService {

	private PharmacyRepository pharmacyRepository;
	
	@Autowired
	public PharmacyServiceImpl(PharmacyRepository thePharmacyRepository) {
		pharmacyRepository = thePharmacyRepository;
	}
	
	@Override
	public List<Pharmacy> findAll() {
		return pharmacyRepository.findAll();
	}
	
	@Override
	public Pharmacy findById(int id) {
		Optional<Pharmacy> result = pharmacyRepository.findById(id);
		Pharmacy thePharmacy = null;
		if(result.isPresent()) {
			thePharmacy = result.get();
		} else {
			throw new RuntimeException("No Pharmacy with that id found");
		}
		return thePharmacy;
	}

}
