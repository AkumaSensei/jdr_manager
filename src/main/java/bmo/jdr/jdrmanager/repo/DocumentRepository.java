package bmo.jdr.jdrmanager.repo;

import org.springframework.data.repository.CrudRepository;

import bmo.jdr.jdrmanager.model.Document;

public interface DocumentRepository extends CrudRepository<Document, Long> {

}