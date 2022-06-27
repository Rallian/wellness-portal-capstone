package com.travisMollohan.wellnessPortal.service;
import java.util.List;

import com.travisMollohan.wellnessPortal.entity.Pharmacy;

public interface PharmacyService {

	public Pharmacy findById(int id);

	List<Pharmacy> findAll();
}
