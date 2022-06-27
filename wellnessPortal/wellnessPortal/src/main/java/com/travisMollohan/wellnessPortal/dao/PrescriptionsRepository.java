package com.travisMollohan.wellnessPortal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travisMollohan.wellnessPortal.entity.Prescriptions;

@Repository
public interface PrescriptionsRepository extends JpaRepository<Prescriptions, Integer> {

	Prescriptions findByName(String name);
}
