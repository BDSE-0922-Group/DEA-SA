package com.MoW.DEASA.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MoW.DEASA.Entity.Donation;
import com.MoW.DEASA.Entity.User;
import com.MoW.DEASA.Service.DonationService;
import com.MoW.DEASA.Service.EmailSenderService;
import com.MoW.DEASA.Service.UserService;

@Controller
public class DonationController {

	@Autowired
	UserService userService;

	@Autowired
	DonationService dService;
	
	@Autowired
	EmailSenderService emailSender;

	@GetMapping("donation")
	public String onDonation(Model model, @ModelAttribute("donation") Donation donation) {

		return "Donator/donation";
	}

	@PostMapping("add_donation")
	public String registerNewUser(@ModelAttribute("donation") Donation donation, Model model, Principal principal) {
    	String username = principal.getName();
    	
    	User user = userService.findLoginUser(username);
    	
    	donation.setDonId(user.getId());
    	
    	String toEmail = user.getEmail();
    	String subject = "Donation has been received";
    	String body = "Dear " + user.getName() + ",\r\n" + 
    			"\r\n" + 
    			"We are writing to express our sincere gratitude for your generous donation to our organization. Your contribution will help us continue our mission of providing quality education and health care to underprivileged children in our community. We are truly grateful for your support and trust in our work.\r\n" + 
    			"\r\n" + 
    			"Thank you for being a part of our team and making a difference in the lives of many.\r\n" + 
    			"\r\n" + 
    			"Sincerely,\r\n" + 
    			"MerryMeal";
    	
    	emailSender.sendEmail(toEmail, subject, body);
    
		dService.save(donation);
		return "Donator/confirmation";
	}

}
