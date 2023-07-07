package com.MoW.DEASA.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.MoW.DEASA.Entity.Role;
import com.MoW.DEASA.Entity.User;
import com.MoW.DEASA.Repo.RoleRepository;
import com.MoW.DEASA.Repo.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}
	
	public List<Role> getRoles() {
		return roleRepository.findRoles();
	}
	
	public String save(User user, String role) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		user.setRoles(new HashSet<>(roleRepository.findBySpecificRoles(role)));
		
		userRepository.save(user);
		
		return "User saved successfully";
	}
	
	public User findLoginUser(String userName) {
	
		return userRepository.findByUserName(userName);
		
	}
	
	public User findUsername(String userName) {
		
		return userRepository.findByUserName(userName);
	}
	
	public List<User> showAllUser(){
		
		return userRepository.findAll();
	}
	
	public String update(User user) {
		
		userRepository.save(user);
		
		return "User updated";
		
	}
	
	public Optional<User> getUserInfo(long uid){
		
		return userRepository.findById(uid);
		
	}
	
	public void deleteUser(long uid) {
		
		userRepository.deleteById(uid);
	}
	
	public void assignNewRole(User user, String role) {
		
		user.getRoles().clear();
		user.setRoles(new HashSet<>(roleRepository.findBySpecificRoles(role)));
		userRepository.save(user);
	}

	public User getUserById(Long userId) {
		return userRepository.getById(userId);
	}

}
