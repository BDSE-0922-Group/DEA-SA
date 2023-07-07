package com.MoW.DEASA.Controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MoW.DEASA.Entity.Role;
import com.MoW.DEASA.Entity.User;
import com.MoW.DEASA.Service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;
	
    @GetMapping("login")
    public String onLogin() {
        return "Auth/login";
    }
    
    @GetMapping("login_error")
    public String onLoginError(Model model) {
        System.out.println("Incorrect Password or Username");
        String error_msg = "Incorrect credentials";
        model.addAttribute("error_msg", error_msg);
        return "Auth/login";
    }
    
    @GetMapping("login_success")
    public String onLoginSuccess(Model model, Principal principal) {
    	
    	String username = principal.getName();
    	
    	User user = userService.findLoginUser(username);
    	
    	String[] role= user.getRoles().stream().map(Role::getName).toArray(String[]::new);
    	
    	String userRole = role[0];
    	
    	String[] roleNames= userService.getAllRoles().stream().map(Role::getName).toArray(String[]::new);
    	
    	for (String roleName: roleNames) {
    		if(roleName == userRole) {
    			System.out.println("Logged in successfully as " + userRole);
    			String success_msg = "Logged in successfully. Click here to go to dashboard.";
    			model.addAttribute("success_msg", success_msg);
    			return "Auth/login";
    		}
    		
    	}
    	
    	System.out.println("Logged in failed");
        String error_msg = "Logged in failed";
        model.addAttribute("error_msg", error_msg);
    	return "Auth/login";
    }
    
    @GetMapping("logout")
    public String onLogoutSuccess(Model model) {
    	
    	String success_logout = "Successfully logged out! Click here to login.";
        model.addAttribute("success_logout", success_logout);
    	
    	return "Common/home";
    }
    
    @GetMapping("register")
    public String onRegister(Model model, @ModelAttribute("user") User user) {
    	List<Role> role = userService.getRoles();
    	
    	model.addAttribute("role", role);
    	
    	return "Auth/registration";
    }
	
    @PostMapping("register_user") 
    public String registerNewUser(@ModelAttribute("user") User user, @RequestParam String role, Model model) {
    	
    	
    	if (userService.findUsername(user.getUserName()) == null|| userService.findUsername(user.getUserName()).getUserName() == null ) {
    		userService.save(user, role);
    		return "Auth/confirmation";	
    	}
    	
    	System.out.println("Username already exists");
        String error_msg = "Username already exists";
        model.addAttribute("error_msg", error_msg);
    	return "Auth/registration";	
    }
    
    @GetMapping("profile")
    public String viewProfile(Principal principal, Model model) {
    	
    	String username = principal.getName();
    	
    	User userdata = userService.findLoginUser(username);
    	
    	String[] role= userdata.getRoles().stream().map(Role::getName).toArray(String[]::new);
    	
    	String userRole = role[0];
    	
    	String[] roleNames= userService.getAllRoles().stream().map(Role::getName).toArray(String[]::new);
    	
    	List<User> user = new ArrayList<User>();
    	user.add(userdata);
    	
    	model.addAttribute("user", user);
    	
		for (String roleName: roleNames) {
    		if(roleName == userRole && userRole.equalsIgnoreCase("Administrator")) {
    			adminProfile();
    			return userRole + "/profile";
    		}
    		if(roleName == userRole && userRole.equalsIgnoreCase("Member")) {
    			memberProfile();
    			return userRole + "/profile";
    		}
    		if(roleName == userRole && userRole.equalsIgnoreCase("Caregiver")) {
    			caregiverProfile();
    			return userRole + "/profile";
    		}
    		if(roleName == userRole && userRole.equalsIgnoreCase("Partner")) {
    			partnerProfile();
    			return userRole + "/profile";
    		}
    		if(roleName == userRole && userRole.equalsIgnoreCase("Volunteer")) {
    			volunteerProfile();
    			return userRole + "/profile";
    		}
    		if(roleName == userRole && userRole.equalsIgnoreCase("Donator")) {
    			donatorProfile();
    			return userRole + "/profile";
    		}
    		if(roleName == userRole && userRole.equalsIgnoreCase("Drivers")) {
    			driverProfile();
    			return userRole + "/profile";
    		}
		}
    	return "redirect:accessdenied";
	}
	
	public void adminProfile() {	
        System.out.println("View profile as Administrator");
	}
	
	public void memberProfile() {	
        System.out.println("View profile as Member");
	}
	
	public void caregiverProfile() {	
        System.out.println("View profile as Caregiver");
	}
	
	public void partnerProfile() {	
        System.out.println("View profile as Partner");
	}
	
	public void volunteerProfile() {	
        System.out.println("View profile as Volunteer");
	}
	
	public void donatorProfile() {	
        System.out.println("View profile as Donator");
	}
	
	public void driverProfile() {	
        System.out.println("View profile as Driver");
	}
	
	@PostMapping("update-profile")
	public String  updateProfile(Principal principal, @ModelAttribute User u) {
		String userName = principal.getName();
		
		User user = userService.findLoginUser(userName);
		
		user.setName(u.getName());
		user.setEmail(u.getEmail());
		user.setAddress(u.getAddress());
		user.setMobile(u.getMobile());
		
		userService.update(user);
		
		return "redirect:profile";
	}
}