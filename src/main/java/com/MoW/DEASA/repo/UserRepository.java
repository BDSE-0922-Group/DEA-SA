package com.MoW.DEASA.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MoW.DEASA.entity.User;
import com.MoW.DEASA.enums.UserRole;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserEmail(String userEmail);

	User getByUserId(Long userId);

	List<User> findByUserRole(UserRole userRole);
}

