package bmo.jdr.jdrmanager.repo;

import org.springframework.data.repository.CrudRepository;

import bmo.jdr.jdrmanager.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}