package com.MoW.DEASA.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MoW.DEASA.Entity.Caregiver;
import com.MoW.DEASA.Repo.CaregiverRepository;

@Service
@Transactional
public class CaregiverService {
	
	@Autowired
	private CaregiverRepository CaregiverRepo;
	
	public Caregiver save(Caregiver caregiver) {
		return CaregiverRepo.save(caregiver);
	}
	
	public List<Caregiver> getAllCaregivers() {
		return CaregiverRepo.findAll();
	}
	
	public void deleteUser(long uid) {
		CaregiverRepo.deleteById(uid);
	}

}
