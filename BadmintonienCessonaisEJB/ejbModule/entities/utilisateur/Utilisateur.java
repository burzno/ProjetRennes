package entities.utilisateur;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.validator.constraints.Email;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

/**
 * Entité sérialisable et persistée permettant de gérer les utilisateurs 
 * les getters et setters sont générés par lombok
 * les attributs privés sont générés automatiquement
 * equals et hashcode générés automatiquement
 * 
 * @author g.joseph-mondesir
 *
 */
@SuppressWarnings("serial")
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@EqualsAndHashCode(of={"idUtilisateur"})
@NamedQueries({

	@NamedQuery(name="findallUtilisateurs",query="select u from Utilisateur u"),
	@NamedQuery(name="findUtilisateurByMail",query="select u from Utilisateur u WHERE u.adresseMail = :mailUtilisateur")

})
public class Utilisateur implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long idUtilisateur;
	@Version
	long version;
	String nom;
	String prenom;
	@Email
	String adresseMail;
	String motDePasse;
	@Temporal(TemporalType.DATE)
	Date dateNaissance;
	String adresse;
	int codePostale;
	String ville;
	String fixe;
	String mobile;
	@ManyToOne
	Profil profil;
	@Enumerated(EnumType.STRING)
	Sexe sexe;
}
