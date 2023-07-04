package com.MoW.DEASA.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.MoW.DEASA.Entity.Role;
import com.MoW.DEASA.Entity.User;
import com.MoW.DEASA.Service.UserService;

@Controller
public class DashboardController {

	@Autowired
	UserService userService;
	

	@GetMapping("dashboard") 
	public String dashboard(Principal principal, Model model) {
    	String username = principal.getName();
    	
    	User user = userService.findLoginUser(username);
    	
    	String[] role= user.getRoles().stream().map(Role::getName).toArray(String[]::new);
    	
    	String userRole = role[0];
    	
    	String[] roleNames= userService.getAllRoles().stream().map(Role::getName).toArray(String[]::new);
    	
		for (String roleName: roleNames) {
    		if(roleName == userRole && userRole.equalsIgnoreCase("Administrator")) {
    			adminDashboard();
    			return userRole + "/dashboard";
    		}
    		if(roleName == userRole && userRole.equalsIgnoreCase("Member")) {
    			memberDashboard();
    			return userRole + "/dashboard";
    		}
    		if(roleName == userRole && userRole.equalsIgnoreCase("Caregiver")) {
    			caregiverDashboard();
    			return userRole + "/dashboard";
    		}
    		if(roleName == userRole && userRole.equalsIgnoreCase("Partner")) {
    			partnerDashboard();
    			return userRole + "/dashboard";
    		}
    		if(roleName == userRole && userRole.equalsIgnoreCase("Volunteer")) {
    			volunteerDashboard();
    			return userRole + "/dashboard";
    		}
    		if(roleName == userRole && userRole.equalsIgnoreCase("Donator")) {
    			donatorDashboard();
    			return userRole + "/dashboard";
    		}
		}
    	return "redirect:accessdenied";
	}
	
	public void adminDashboard() {	
        System.out.println("Logged in as Administrator");
	}
	
	public void memberDashboard() {	
        System.out.println("Logged in as Member");
	}
	
	public void caregiverDashboard() {	
        System.out.println("Logged in as Caregiver");
	}
	
	public void partnerDashboard() {	
        System.out.println("Logged in as Partner");
	}
	
	public void volunteerDashboard() {	
        System.out.println("Logged in as Volunteer");
	}
	
	public void donatorDashboard() {	
        System.out.println("Logged in as Donator");
	}
}
