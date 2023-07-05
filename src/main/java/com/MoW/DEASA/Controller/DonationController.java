package com.MoW.DEASA.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.MoW.DEASA.Entity.Donation;
import com.MoW.DEASA.Entity.User;
import com.MoW.DEASA.Service.DonationService;
import com.MoW.DEASA.Service.UserService;

@Controller
public class DonationController {

	@Autowired
	UserService userService;

	@Autowired
	DonationService dService;

	@GetMapping("donation")
	public String onDonation(Model model, @ModelAttribute("donation") Donation donation) {

		return "Donator/donation";
	}

	@PostMapping("add_donation")
	public String registerNewUser(@ModelAttribute("donation") Donation donation, Model model, Principal principal) {
    	String username = principal.getName();
    	
    	User user = userService.findLoginUser(username);
    	
    	donation.setDonId(user.getId());
    
		dService.save(donation);
		return "Donator/confirmation";
	}

}