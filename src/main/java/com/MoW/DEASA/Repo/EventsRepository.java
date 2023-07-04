package com.MoW.DEASA.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MoW.DEASA.Entity.Events;

public interface EventsRepository extends JpaRepository <Events, Long> {

}
