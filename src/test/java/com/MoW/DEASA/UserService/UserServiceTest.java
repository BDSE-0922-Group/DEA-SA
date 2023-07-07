package com.MoW.DEASA.UserService;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.MoW.DEASA.Entity.User;
import com.MoW.DEASA.Repo.RoleRepository;
import com.MoW.DEASA.Repo.UserRepository;
import com.MoW.DEASA.Service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@InjectMocks
	UserService userService;
	
	@Mock
	RoleRepository roleRepository;
	
	@Mock
	PasswordEncoder passwordEncoder;
	
	@Mock
	UserRepository userRepository;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void saveRegisterUserData() {
		User user = new User();
		user.setId((long)1);
		user.setName("Jonathan Hunter");
		user.setUserName("Jonathan");
		user.setEmail("jHunter@gmail.com");
		String encodedPassword = passwordEncoder.encode("jonathan123");
		user.setPassword(encodedPassword);
		String role = "Donator";
		user.setRoles(new HashSet<>(roleRepository.findBySpecificRoles(role)));
		Mockito.when(userRepository.save(user)).thenReturn(user);
		String userResponse = userService.save(user, role);
		Assert.assertEquals("User saved successfully", userResponse);
	}
	
	@Test
	public void updateRegisterUserData() {
		User user = new User();
		user.setId((long)1);
		user.setName("Jonathan Hunter");
		user.setUserName("Jonathan");
		user.setEmail("jHunter@gmail.com");
		Mockito.when(userRepository.save(user)).thenReturn(user);
		String userResponse = userService.update(user);
		Assert.assertEquals("User updated", userResponse);
	}
	
	@Test
	public void isPersonExistbyUsername() {
		User user = new User();
		String username = "Jonathan";
		user.setUserName(username);
		Mockito.when(userRepository.findByUserName(username)).thenReturn(user);
		User loginUser = userService.findLoginUser(username);
		Assert.assertEquals(user, loginUser);
	}
}
