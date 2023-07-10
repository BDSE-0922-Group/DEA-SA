package com.MoW.DEASA.Controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

		
		return "redirect:dashboard";
	}
	
	@GetMapping("all_event")
	public ModelAndView allEvents( @ModelAttribute("event") Events events) throws IOException {
		
		List<Events> event =eventService.getAllEvents();
		System.out.println(event);
		
		return new ModelAndView ("dashboard", "event", event);
		

		
//		return "Volunteer/dashboard;  
	} 
	
	@GetMapping("delete")
    public String deleteEvent(@RequestParam long eid) {
    	
    	eventService.deleteEvent(eid);
    	
    	return "redirect:dashboard";
    }
	
	@PostMapping("edit")
    public String editEvents(@RequestParam long eid,
    		@ModelAttribute("events") Events e) {
    	
    	Optional<Events> event_info = eventService.getEventsInfo(eid);
    	System.out.println(event_info);
    	
    	Events event = event_info.get();
    	
    	event.setName(e.getName());
    	event.setDescription(e.getDescription());
    	event.setVenue(e.getVenue());
    	event.setDate(e.getDate());

    	
    	eventService.update(event);
    	System.out.println("Edit Event Successful");
    	System.out.println(event);
    	
    	return "redirect:dashboard";
    }
}

