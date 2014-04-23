package entities.reference;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Enum permettant l'initialisation des catégories
 * @author g.joseph-mondesir
 *
 */
@Getter
@FieldDefaults(level=AccessLevel.PRIVATE)
public enum Categorie {
	SNR("Sénior"),
	VT1("Vétéran 1"),
	VT2("Vétéran 2"),
	VT3("Vétéran 3"),
	VT4("Vétéran 4");

	String libelle;
	
	private Categorie(String libelle) {
		this.libelle = libelle;
	}
}
