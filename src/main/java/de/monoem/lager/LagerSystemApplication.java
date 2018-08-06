package de.monoem.lager;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.common.collect.Lists;

import de.monoem.lager.entity.Haendler;
import de.monoem.lager.entity.Kontaktdaten;
import de.monoem.lager.entity.Artikel;
import de.monoem.lager.repository.HandlerRepository;
import de.monoem.lager.repository.KontaktdatenRepo;
import de.monoem.lager.repository.WarenRepository;

@SpringBootApplication
public class LagerSystemApplication {
	
	@Autowired
	WarenRepository warenRepository;
	
	@Autowired
	HandlerRepository handlerRepository;
	
	@Autowired
	KontaktdatenRepo kontaktdatenRepo;

	public static void main(String[] args) {
		SpringApplication.run(LagerSystemApplication.class, args);
	}
	
	@PostConstruct
	public void initDaten() {
		Kontaktdaten kontaktdaten = Kontaktdaten.builder()
				.kontaktdatenEmail("volkswagen@vw.de")
				.kontaktdatenTelefonnummer("0049111222333")
				.build();
		
		Haendler haendler = Haendler.builder()
				.haendlerName("Volkswagen")
				.haendlerKontaktdaten(Lists.newArrayList(kontaktdatenRepo.save(kontaktdaten)))
				.build();
		
//		Artikel ware = Artikel.builder()
//				.warenName("Linkrad")
//				.warenBeschreibung("In einem sehr guten Stand.")
//				.warenMarke("VW")
//				.warenPreis(22L)
//				.warenHaendler(Lists.newArrayList(handlerRepository.save(haendler)))
//				.build();
		
//		warenRepository.save(ware);
	}
}
