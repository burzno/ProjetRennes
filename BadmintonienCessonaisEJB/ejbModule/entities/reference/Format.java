package entities.reference;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

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
