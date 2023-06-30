package com.MoW.DEASA.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DonatorController {

	@GetMapping("dashboard")
	public String dashboard() {
		return "Donator/donator-dashboard";
	}
	
}
