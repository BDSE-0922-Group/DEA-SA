// TODO: Create volunteer service
// 		 Grab volunteer info  


package com.MoW.DEASA.Repo;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MoW.DEASA.Entity.Caregiver;
import com.MoW.DEASA.Entity.Role;
import com.MoW.DEASA.Entity.User;

@Repository
public interface CaregiverRepository extends JpaRepository<Caregiver, Long>{
	
	Caregiver findById(String name);
	
	// TODO: Get all orders assigned to driver.
	
//	
//	@Query( value = "SELECT id FROM Caregiver" )
//	List<Caregiver> getAllOrders();
//	
	
	@Query( value = "select r from Caregiver r where r.id = :userId" )
	List<Caregiver> findAllActiveOrders(@Param("userId") Long userId);
	
	List<Caregiver> findByUserId(Long userId);
	
	 @Query(nativeQuery = true, value = "SELECT * FROM Caregiver WHERE user_id = :id")
	 List<Caregiver> moveCourseConfirm(long id);
	
}


