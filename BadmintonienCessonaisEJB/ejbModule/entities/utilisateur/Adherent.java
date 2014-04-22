package entities.utilisateur;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import entities.reference.Categorie;

@SuppressWarnings("serial")
@Entity
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@NamedQueries({

	@NamedQuery(name="allAdherents",query="select ad from Adherent ad"),
	@NamedQuery(name="findAdherentByMail",query="select ad from Adherent ad WHERE ad.adresseMail = :mailAdherent")

})
public class Adherent extends Utilisateur implements Serializable {

	
	String licenceFcd;
	String licenceFfba;
	boolean referent;
	@Enumerated(EnumType.STRING)
	Categorie categorie;
	@ManyToOne
	Club club;
	@OneToOne(cascade=CascadeType.ALL)
	ClassementFFBA Classement;

	@OneToOne(cascade=CascadeType.ALL)
	Pieces pieces;
}
