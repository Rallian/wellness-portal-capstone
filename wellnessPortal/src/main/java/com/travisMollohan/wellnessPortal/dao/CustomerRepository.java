package com.travisMollohan.wellnessPortal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.travisMollohan.wellnessPortal.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	@Transactional
	@Modifying
	@Query(
			value= "DELETE FROM customer_prescriptions WHERE customer_id = :customerId and prescription_id = :prescriptionId",
			nativeQuery = true)
	void deletePrescriptionsById(@Param("customerId") int customerId, @Param("prescriptionId") int prescriptionId);
	
	
	Customer findByEmail(String email);
}
