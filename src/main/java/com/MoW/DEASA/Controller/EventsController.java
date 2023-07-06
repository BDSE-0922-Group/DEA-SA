package com.MoW.DEASA.Controller;

import java.io.IOException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.MoW.DEASA.Entity.Events;
import com.MoW.DEASA.Service.EventsService;

@Controller
public class EventsController {
	
	@Autowired
	EventsService eventService;
	
	@GetMapping("post-events")
	public String postEventForm(@ModelAttribute("events")Events events) {
		
		return "Volunteer/events";
	}
	
	@PostMapping("post-events")
	public String postEvents(Model model, @ModelAttribute("Events") Events events, Principal principal) throws IOException {
		

		eventService.save(events);

		
		return "Volunteer/dashboard";
	}
}

