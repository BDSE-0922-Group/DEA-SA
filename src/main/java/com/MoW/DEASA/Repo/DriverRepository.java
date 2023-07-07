// TODO: Create volunteer service
// 		 Grab volunteer info  


package com.MoW.DEASA.Repo;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MoW.DEASA.Entity.Driver;
import com.MoW.DEASA.Entity.Role;
import com.MoW.DEASA.Entity.User;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long>{
	
	Driver findById(String name);
	
	// TODO: Get all orders assigned to driver.
	
	
	@Query( value = "SELECT id FROM Driver" )
	List<Driver> getAllIds();
}


