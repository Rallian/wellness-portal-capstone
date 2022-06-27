package com.travisMollohan.wellnessPortal.service;

import java.util.List;
import com.travisMollohan.wellnessPortal.entity.Insurance;

public interface InsuranceService {

public List<Insurance> findAll();
	
public Insurance findById(int id);

}
