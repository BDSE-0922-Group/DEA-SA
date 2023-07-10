package com.MoW.DEASA.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MoW.DEASA.Entity.Events;
import com.MoW.DEASA.Repo.EventsRepository;

@Service
@Transactional
public class EventsService {

	@Autowired
	private EventsRepository eventRepo;
	
	public Events save(Events events) {
		return eventRepo.save(events);
	}
	
	public List<Events> getAllEvents(){
		return eventRepo.findAll();
	}

	public void deleteEvent(long eid) {
		
		eventRepo.deleteById(eid);
	}

	public Optional<Events> getEventsInfo(long eid) {
		
		return eventRepo.findById(eid);
	}

	public void update(Events event) {
		
		eventRepo.save(event);
	}
}
