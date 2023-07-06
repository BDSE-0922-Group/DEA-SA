package com.MoW.DEASA.Service;

import java.util.List;

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
}
