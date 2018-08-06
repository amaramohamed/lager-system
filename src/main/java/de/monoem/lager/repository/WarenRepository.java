package de.monoem.lager.repository;

import org.springframework.data.repository.CrudRepository;

import de.monoem.lager.entity.Artikel;

public interface WarenRepository extends CrudRepository<Artikel, String> {

}
