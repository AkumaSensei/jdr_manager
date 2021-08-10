package bmo.jdr.jdrmanager.repo;

import org.springframework.data.repository.CrudRepository;

import bmo.jdr.jdrmanager.model.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {

}