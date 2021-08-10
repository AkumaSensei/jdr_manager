package bmo.jdr.jdrmanager.repo;

import org.springframework.data.repository.CrudRepository;

import bmo.jdr.jdrmanager.model.Event;

public interface EventRepository extends CrudRepository<Event, Long> {

}