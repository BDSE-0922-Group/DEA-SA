package com.MoW.DEASA.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MealsOnWheelsController {

	@GetMapping("/")
	public String handleRootRequest() {

		return "redirect:home";
	}
	
	@GetMapping("home")
	public String homePage() {
		return "Common/home";
	}
	
	@GetMapping("accessdenied")
	public String accessDeniedPage() {
		return "Common/access-denied";
	}
	
	@GetMapping("About-Us")
	public String AboutUsPage() {
		return "Common/About-Us";
	}
	
	@GetMapping("Terms-and-Conditions")
	public String TermsAndConditionsPage() {
		return "Common/Terms-and-Conditions";
	}
	
	@GetMapping("Contact-Us")
	public String ContactUsPage() {
		return "Common/Contact-Us";
	}
}