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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

	@NamedQuery(name="findallUtilisateurs",query="select u from Utilisateur u"),
	@NamedQuery(name="findUtilisateurByMail",query="select u from Utilisateur u WHERE u.adresse_mail = :mailUtilisateur")

})
public class Utilisateur implements Serializable{
	
	
	@Id
	@Column(columnDefinition="VARCHAR(36)")
	String id = UUID.randomUUID().toString();
	String nom;
	String prenom;
	String adresse_mail;
	String mot_de_passe;
	@Temporal(TemporalType.DATE)
	Date date_naissance;
	String adresse;
	int code_postale;
	String ville;
	String fixe;
	String mobile;
	@Enumerated(EnumType.STRING)
	Sexe sexe;
}
