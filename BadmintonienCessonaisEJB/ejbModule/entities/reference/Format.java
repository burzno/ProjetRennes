package entities.reference;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Enum référençant les formats des matchs
 * Les getters sont générés automatiquement par lombok
 * Les attributs privés sont générés automatiquement
 * @author g.joseph-mondesir
 *
 */
@Getter
@FieldDefaults(level=AccessLevel.PRIVATE)
public enum Format {
	SPL("Simple"),
	DBL("Double"),
	DBM("DoubleMixte");

	String libelle;
	
	Format(String libelle) {
		this.libelle = libelle;
	}
}
