package com.travisMollohan.wellnessPortal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travisMollohan.wellnessPortal.entity.Pharmacy;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, Integer> {

	
	Pharmacy findByName(String Name);
}
