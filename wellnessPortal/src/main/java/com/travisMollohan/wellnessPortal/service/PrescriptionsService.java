package com.travisMollohan.wellnessPortal.service;

import java.util.List;
import com.travisMollohan.wellnessPortal.entity.Prescriptions;

public interface PrescriptionsService {

public List<Prescriptions> findAll();
	
	public Prescriptions findById(int id);
}
