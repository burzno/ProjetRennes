package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@EqualsAndHashCode(of={"id"})
@NamedQueries({

	@NamedQuery(name="allAdherents",query="select ad from Adherent ad"),
	@NamedQuery(name="findAdherentByName",query="select ad from Adherent ad WHERE ad.nom = :nomAdherent")

})
public class Utilisateur implements Serializable{
	
	
	@Id
	@Column(columnDefinition="VARCHAR(36)")
	String id = UUID.randomUUID().toString();
	String nom;
	String prenom;
	String adresse_mail;
	String mot_de_passe;
	Date date_naissance;
	String adresse;
	int code_postale;
	String ville;
	String fixe;
	String mobile;
	@Enumerated(EnumType.STRING)
	Sexe sexe;
}
