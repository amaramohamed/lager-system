package de.monoem.lager.repository;

import org.springframework.data.repository.CrudRepository;

import de.monoem.lager.entity.Haendler;

public interface HandlerRepository extends CrudRepository<Haendler, String> {

}
