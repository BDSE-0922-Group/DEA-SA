package com.MoW.DEASA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.MoW.DEASA.entity.User;
import com.MoW.DEASA.enums.UserRole;
import com.MoW.DEASA.payload.UpdateUser;
import com.MoW.DEASA.repo.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(String userName, String userEmail, String userPassword, UserRole userRole) {

        if (userRepository.findByUserEmail(userEmail) != null) {
            throw new IllegalArgumentException("User with the provided email already exists.");
        }

        User user = new User(userName, userEmail, passwordEncoder.encode(userPassword), userRole);
        return userRepository.save(user);
    }

    public User findByUserEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail);
    }

    public boolean isPasswordValid(User user, String password) {
        return passwordEncoder.matches(password, user.getUserPassword());
    }

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
    }

    public User updateUser(Long userId, UpdateUser payload) {
        User user = getUserById(userId);
        user.setUserName(payload.getUserName());
        user.setUserEmail(payload.getUserEmail());
        user.setUserPassword(passwordEncoder.encode(payload.getUserPassword()));
        user.setUserRole(UserRole.valueOf(payload.getUserRole()));
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
    
    public List<User> getUsersByRole(UserRole userRole) {
        return userRepository.findByUserRole(userRole);
    }
    
}

