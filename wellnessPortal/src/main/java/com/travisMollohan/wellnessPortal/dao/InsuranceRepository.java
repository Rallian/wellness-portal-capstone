package com.travisMollohan.wellnessPortal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travisMollohan.wellnessPortal.entity.Insurance;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {

}
