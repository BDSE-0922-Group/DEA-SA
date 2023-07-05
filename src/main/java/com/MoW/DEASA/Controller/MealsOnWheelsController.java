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
	
	@GetMapping("access-denied")
	public String accessDeniedPage() {
		return "Common/access-denied";
	}
}