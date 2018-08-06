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

import de.monoem.lager.entity.Artikel;
import de.monoem.lager.service.WarenService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
public class WarenController {

	@Autowired
	private WarenService mWarenService;
	
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
	
}
