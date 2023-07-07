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
	
	List<Caregiver> findByUserId(Long userId);
	
	// Refactor: Break up into smaller get functions.
	//				- Orders
	//				- Meal
	//				- Users
	
	//HQL query
	 @Query("SELECT o.id,m.name,u.name,o.status FROM Caregiver c " 
			 + "INNER JOIN Orders o ON c.orderId=o.id "
			 + "LEFT JOIN Meal m ON o.mealId=m.id "
			 + "LEFT JOIN User u ON o.recipientId=u.id "
			 + "WHERE c.userId=:userId")
	 public List<Object[]> findDetails(@Param("userId") Long userId);
}


