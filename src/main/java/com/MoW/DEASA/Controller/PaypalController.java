package com.MoW.DEASA.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MoW.DEASA.Entity.Donation;
import com.MoW.DEASA.Entity.User;
import com.MoW.DEASA.Service.DonationService;
import com.MoW.DEASA.Service.EmailSenderService;
import com.MoW.DEASA.Service.PaypalService;
import com.MoW.DEASA.Service.UserService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

@Controller
public class PaypalController {

	@Autowired
	PaypalService service;
	
	@Autowired
	DonationService dService;
	
	@Autowired
	EmailSenderService emailSender;
	
	@Autowired
	UserService userService;

	public static final String SUCCESS_URL = "success";
	public static final String CANCEL_URL = "pay/cancel";

	@GetMapping("/paypal")
	public String home() {
		return "Paypal/paypal";
	}

	@PostMapping("/pay")
	public String payment(@ModelAttribute("donation") Donation donation, Principal principal) {
        try {
            Payment payment = service.createPayment( donation.getAmount(), donation.getCurrency(), donation.getMethod(),
                    donation.getIntent(), donation.getDescription(), "http://localhost:8080/" + CANCEL_URL,
                    "http://localhost:8080/" + SUCCESS_URL);
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
        	
            for(Links link:payment.getLinks()) {
                if(link.getRel().equals("approval_url")) {
                    return "redirect:"+link.getHref();
                }
            }

        } catch (PayPalRESTException e) {

            e.printStackTrace();
        }
		return "redirect:paypal";
	}
	
	 @GetMapping(value = CANCEL_URL)
	    public String cancelPay() {
	        return "redirect:paypal";
	    }

	    @GetMapping(value = SUCCESS_URL)
	    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
	        try {
	            Payment payment = service.executePayment(paymentId, payerId);
	            System.out.println(payment.toJSON());
	            if (payment.getState().equals("approved")) {
	                return "Donator/confirmation";
	            }
	        } catch (PayPalRESTException e) {
	         System.out.println(e.getMessage());
	        }
	        return "redirect:paypal";
	    }

}
