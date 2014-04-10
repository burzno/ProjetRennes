package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@SuppressWarnings("serial")
@Entity
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@NamedQueries({

	@NamedQuery(name="allAdherents",query="select ad from Adherent ad"),
	@NamedQuery(name="findAdherentByName",query="select ad from Adherent ad WHERE ad.nom = :nomAdherent")

})
public class Adherent extends Utilisateur implements Serializable {

	
	String licence_fcd;
	String licence_ffba;
	Boolean isReferent;


}
