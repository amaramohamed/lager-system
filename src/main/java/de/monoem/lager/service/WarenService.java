package de.monoem.lager.service;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import de.monoem.lager.entity.Artikel;
import de.monoem.lager.repository.WarenRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class WarenService {

	@Autowired
	WarenRepository mWarenRepository;

	public ResponseEntity<Artikel> saveWare(Artikel pWare) {
		Artikel lWare = mWarenRepository.save(pWare);
		return new ResponseEntity<Artikel>(lWare, HttpStatus.CREATED);
	}

	// zu optimieren: Die Liste soll direkt von dem Repository gefiltert werden.
	public Stream<Artikel> getAlleWaren(String pWarenName, String pWarenMarke) {
		if (pWarenMarke == null && pWarenName == null) {
			return Lists.newArrayList(mWarenRepository.findAll()).stream();
		} else if (!(pWarenMarke == null) && pWarenName == null) {
			return Lists.newArrayList(mWarenRepository.findAll()).stream()
					.filter(ware -> ware.getWarenMarke().equals(pWarenMarke));
		} else if (pWarenMarke == null && !(pWarenName == null)) {
//			return Lists.newArrayList(mWarenRepository.findAll()).stream()
//					.filter(ware -> ware.getWarenName().equals(pWarenName));
			return null;
		} else {
			return Lists.newArrayList(mWarenRepository.findAll()).stream()
					.filter(ware -> ware.getWarenMarke().equals(pWarenMarke));
		}
	}

	@SuppressWarnings("rawtypes")
	public ResponseEntity deleteWare(String pWareUuid) throws ObjectNotFoundException {
		Optional<Artikel> lWare = mWarenRepository.findById(pWareUuid);
		if (lWare.isPresent()) {
			mWarenRepository.delete(lWare.get());
			return new ResponseEntity(HttpStatus.OK);
		} else {
			throw new ObjectNotFoundException("Das Objekt mit dem UUID " + pWareUuid + " existiert nicht.");
		}
	}

}
