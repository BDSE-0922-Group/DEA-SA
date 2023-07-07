package com.MoW.DEASA.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MoW.DEASA.Entity.Driver;
import com.MoW.DEASA.Repo.DriverRepository;

@Service
@Transactional
public class DriverService {
	
	@Autowired
	private DriverRepository driverRepo;
	
	public Driver save(Driver driver) {
		return driverRepo.save(driver);
	}
	
	public List<Driver> getAllDrivers() {
		return driverRepo.findAll();
	}
	
	public void deleteUser(long uid) {
		driverRepo.deleteById(uid);
	}

}
