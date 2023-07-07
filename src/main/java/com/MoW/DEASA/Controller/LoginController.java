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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.MoW.DEASA.Entity.Donation;
import com.MoW.DEASA.Entity.Role;
import com.MoW.DEASA.Entity.User;
import com.MoW.DEASA.Service.DonationService;
import com.MoW.DEASA.Service.EmailSenderService;
import com.MoW.DEASA.Service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;
	
	@Autowired
	DonationService dService;
	
	@Autowired
	EmailSenderService emailSender;
	
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
    public String onLogoutSuccess(Model model, RedirectAttributes redir) {
    	
    	String success_logout = "Successfully logged out! Click here to login.";
        redir.addFlashAttribute("success_logout", success_logout);
    	
    	return "redirect:home";
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

        	String toEmail = user.getEmail();
        	String subject = "Thank you for registering with Meals on Wheels";
        	String body = "Dear " + user.getName() + ",\r\n" + 
        			"\r\n" + 
        			"We are delighted to welcome you to Meals on Wheels, the online platform that connects you with nutritious and affordable meals delivered to your doorstep. By registering with us, you are joining a community of people who care about healthy eating and social impact.\r\n" + 
        			"\r\n" + 
        			"As a new member, you can enjoy some exclusive benefits, such as:\r\n" + 
        			"\r\n" + 
        			"- Access to a variety of menus and cuisines from local chefs and restaurants\r\n" + 
        			"- Flexible delivery options and payment methods\r\n" + 
        			"- Discounts and rewards for referrals and feedback\r\n" + 
        			"- Support for seniors and low-income households in need of food assistance\r\n" + 
        			"\r\n" + 
        			"To start ordering your meals, simply log in to your account and browse our selection of delicious dishes. You can also customize your preferences and dietary requirements in your profile.\r\n" + 
        			"\r\n" + 
        			"If you have any questions or concerns, please feel free to contact us at support@mealsonwheels.com or call us at 1-800-555-1234. We are always happy to hear from you and help you with your needs.\r\n" + 
        			"\r\n" + 
        			"Thank you for choosing Meals on Wheels. We hope you enjoy your meals and our service.\r\n" + 
        			"\r\n" + 
        			"Sincerely,\r\n" + 
        			"The Meals on Wheels Team\r\n" + 
        			"";
        	
        	emailSender.sendEmail(toEmail, subject, body);
        	
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
    			adminProfile(principal, model);
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
    			donatorProfile(model, principal);
    			return userRole + "/profile";
    		}
		}
    	return "redirect:accessdenied";
	}
	
	public void adminProfile(Principal principal, Model model) {
		// view own profile as admin 
		String adminUsername = principal.getName();
	    User adminUser = userService.findLoginUser(adminUsername);
	    model.addAttribute("user", adminUser);		
		
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
	
	public void donatorProfile(Model model, Principal principal) {
    	String username = principal.getName();
    	
    	User user = userService.findLoginUser(username);
    	
    	long uId = user.getId();
    	
    	List<Donation> donation = dService.getSpecificDonation(uId);
    	
		model.addAttribute("donation", donation);
	}
	
	@PostMapping("update-profile")
	public String  updateProfile(Principal principal, @ModelAttribute("user") User u, RedirectAttributes redir) {
		String userName = principal.getName();
		
		User user = userService.findLoginUser(userName);
		
		user.setName(u.getName());
		user.setGender(u.getGender());
		user.setAddress(u.getAddress());
		user.setMobile(u.getMobile());
		
		userService.update(user);
		
		String success_msg = "Profile has been updated";
		
		redir.addFlashAttribute("success_msg", success_msg);
		
		return "redirect:profile";
	}
	
}
