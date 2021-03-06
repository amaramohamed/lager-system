package de.monoem.lager.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Artikel {
	
	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(unique = true)
	private String artikelUuid;
	
	private String artikelNummer;
	private String artikelMarke;
	private String artikelBezeichnung;
	private Long artikelPreis;
	private String artikelBeschreibung;
	private String artikelKategorie;
	private String artikelBild;
	@ManyToMany
	private List<Haendler> artikelHaendler;
	

}
