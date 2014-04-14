package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@SuppressWarnings("serial")
@Entity
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@NamedQueries({

	@NamedQuery(name="allAdherents",query="select ad from Adherent ad"),
	@NamedQuery(name="findAdherentByMail",query="select ad from Adherent ad WHERE ad.adresse_mail = :mailAdherent")

})
public class Adherent extends Utilisateur implements Serializable {

	
	String licence_fcd;
	String licence_ffba;
	boolean referent;
	@ManyToOne(targetEntity=Categorie.class)
	Categorie categorie;
	@ManyToOne(targetEntity=Club.class)
	Club club;
	@OneToMany
	List<Classement> listeClassements = new ArrayList<>();


}
