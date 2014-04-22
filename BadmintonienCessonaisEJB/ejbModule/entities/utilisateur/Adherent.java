package entities.utilisateur;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
	@NamedQuery(name="findAdherentByMail",query="select ad from Adherent ad WHERE ad.adresseMail = :mailAdherent")

})
public class Adherent extends Utilisateur implements Serializable {

	
	String licenceFcd;
	String licenceFfba;
	boolean referent;
	@ManyToOne
	Categorie categorie;
	@ManyToOne
	Club club;
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(referencedColumnName = "licenceFfba", name="LICENCEFFBA")
	List<Classement> listeClassements = new ArrayList<>();
	@ManyToOne
	Pieces piece;
}
