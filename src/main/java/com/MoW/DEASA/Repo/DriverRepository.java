// TODO: Create volunteer service
// 		 Grab volunteer info  


package com.MoW.DEASA.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MoW.DEASA.Entity.Driver;
import com.MoW.DEASA.Entity.User;

@Repository
public interface DriverRepository extends JpaRepository<User, Long>{
	
	Driver findByUserName(String name);

}


