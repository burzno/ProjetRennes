package entities.tournoi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import org.hibernate.validator.constraints.NotBlank;


/**
 * Entité sérialisable et persistée permettant de gérer les tournois 
 * les getters et setters sont générés par lombok
 * les attributs privés sont générés automatiquement
 * equals et hashcode générés automatiquement
 * 
 * @author g.joseph-mondesir
 *
 */
@SuppressWarnings("serial")
@Entity
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@EqualsAndHashCode(of={"idTournoi"})
public class Tournoi implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long idTournoi;
	
	@Version
	long version;
	
	@NotBlank
	String nom;
	@Temporal(TemporalType.DATE)
	Date dateTournoi;
	@NotBlank
	String lieu;
	int dureeMatch;
	int dureeRecup;
	int nbTerrain;
	
	@OneToMany(mappedBy="tournoi", cascade=CascadeType.ALL, orphanRemoval=true)
	List<Tableau> tableaux = new ArrayList<>();
	@OneToMany(mappedBy="tournoi", cascade=CascadeType.ALL, orphanRemoval=true)
	List<Echeancier> echeanciers = new ArrayList<>();
	
}
