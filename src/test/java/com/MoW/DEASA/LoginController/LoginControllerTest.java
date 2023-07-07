package com.MoW.DEASA.LoginController;

import java.security.Principal;
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
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.MoW.DEASA.Controller.LoginController;
import com.MoW.DEASA.Entity.Donation;
import com.MoW.DEASA.Entity.Role;
import com.MoW.DEASA.Entity.User;
import com.MoW.DEASA.Repo.RoleRepository;
import com.MoW.DEASA.Repo.UserRepository;
import com.MoW.DEASA.Security.UserDetailsServiceImpl;
import com.MoW.DEASA.Service.DonationService;
import com.MoW.DEASA.Service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {
	
	@InjectMocks
	LoginController loginController;
	
	@Mock
	UserService userService;
	
	@Mock
	DonationService donationService;
	
	@Mock
	Model model;

	
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testLoadLoginPage() {
		ModelAndView mav = new ModelAndView();
		String loginViewName = loginController.onLogin();
		mav.setViewName(loginViewName);
		Assert.assertEquals("Auth/login", mav.getViewName());
	}
	
}
