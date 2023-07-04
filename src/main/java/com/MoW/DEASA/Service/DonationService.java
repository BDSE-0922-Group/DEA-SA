package com.MoW.DEASA.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MoW.DEASA.Entity.Donation;
import com.MoW.DEASA.Entity.Role;
import com.MoW.DEASA.Repo.DonationRepository;

@Service
@Transactional
public class DonationService {

	@Autowired
	DonationRepository dRepo;

	public String save(Donation donation) {
		dRepo.save(donation);

		return "Donation saved successfully";
	}
	
	public List<Donation> getAllDonations() {
		return dRepo.findAll();
	}
	
	
}
