package com.MoW.DEASA.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MoW.DEASA.Entity.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
	
		List<Donation> findBydonId(Long id);
		
		
}