package de.monoem.lager.controller;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

import de.monoem.lager.entity.Artikel;
import de.monoem.lager.entity.Haendler;
import de.monoem.lager.repository.HandlerRepository;
import de.monoem.lager.service.WarenService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
public class WarenController {

	@Autowired
	private WarenService mWarenService;
	
	@Autowired
	HandlerRepository handlerRepo;
	
	@GetMapping("/get")
	public Stream<Artikel> getAlleWaren(@RequestParam(name="marke", required=false) String pWarenMarke,
								   @RequestParam(name="name", required=false) String pWarenName) {
		return mWarenService.getAlleWaren(pWarenName, pWarenMarke);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Artikel> saveWare(@RequestBody Artikel pWare) {
		return mWarenService.saveWare(pWare);
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/delete/{pWareUuid}")
	public ResponseEntity deleteWare(@PathVariable String pWareUuid) throws ObjectNotFoundException {
		return mWarenService.deleteWare(pWareUuid);
	}
	
	@GetMapping("/mockdaten")
	public String mockDaten() {
		Haendler artikelHaendler = Haendler.builder()
				.haendlerName("Audi Wuppertal")
				.build();
		handlerRepo.save(artikelHaendler);
		Artikel artikel = Artikel.builder()
				.artikelBezeichnung("BMW Steuergerät")
				.artikelBeschreibung("Neu")
				.artikelBild("img/bg-img/3.jpg")
				.artikelHaendler(Lists.newArrayList(artikelHaendler))
				.artikelKategorie("Elektronik")
				.artikelMarke("BMW")
				.artikelNummer("3A")
				.artikelPreis(899L)
				.build();
		mWarenService.saveWare(artikel);
		return "erledigt";
	}
	
}
