package bmo.jdr.jdrmanager.repo;

import org.springframework.data.repository.CrudRepository;

import bmo.jdr.jdrmanager.model.Character;

public interface CharacterRepository extends CrudRepository<Character, Long> {

}