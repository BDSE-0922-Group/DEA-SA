package com.MoW.DEASA.Controller;

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
    
    @GetMapping("register")
    public String onRegister(Model model) {
    	List<Role> role = userService.getRoles();
    	
    	model.addAttribute("role", role);
    	
    	return "Auth/registration";
    }
	
    @PostMapping("register_user") 
    public String registerNewUser(@ModelAttribute("user") User user, @RequestParam String role) {
    	userService.save(user, role);
    	
    	return "Auth/confirmation";	
    }
    
}
