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
	public String addNewDonation(@ModelAttribute("donation") Donation donation, Model model, Principal principal) {
    	String username = principal.getName();
    	
    	User user = userService.findLoginUser(username);
    	
    	donation.setDonId(user.getId());
  
		dService.save(donation);
		
    	String toEmail = user.getEmail();
    	String subject = "Thank you for your donation to Meals on Wheels";
    	String body = "Dear "+ user.getName() +",\r\n" + 
    			"\r\n" + 
    			"We are writing to express our sincere gratitude for your generous contribution to Meals on Wheels. Your donation will help us provide nutritious meals and friendly visits to seniors and people with disabilities in our community.\r\n" + 
    			"\r\n" + 
    			"Your support means a lot to us and to the people we serve. Thanks to you, we can continue our mission of reducing hunger and isolation among our most vulnerable neighbors.\r\n" + 
    			"\r\n" + 
    			"We hope you will stay connected with us through our website, newsletter, and social media channels. You can also volunteer with us or join our events to see the impact of your donation firsthand.\r\n" + 
    			"\r\n" + 
    			"Thank you again for your kindness and generosity. You are making a difference in the lives of many.\r\n" + 
    			"\r\n" + 
    			"Sincerely,\r\n" + 
    			"\r\n" + 
    			"Meals on Wheels Team";
    	
    	emailSender.sendEmail(toEmail, subject, body);
    	
		return "Donator/confirmation";
	}

}
