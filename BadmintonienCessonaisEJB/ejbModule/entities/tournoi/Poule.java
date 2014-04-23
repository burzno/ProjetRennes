package entities.tournoi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

/**
 * Entité sérialisable et persistée permettant de gérer les poules 
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
@EqualsAndHashCode(of={"idPoule"})
public class Poule implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long idPoule;
	
	@Version
	long version;
	
	String nom;
	
	@ManyToOne
	Tableau tableau;
	@OneToMany(mappedBy="poule", cascade=CascadeType.ALL, orphanRemoval=true)
	List<Match> matchs =  new ArrayList<>();
	@OneToMany(mappedBy="poule", cascade=CascadeType.ALL, orphanRemoval=true)
	List<Equipe> equipes = new ArrayList<>();
	
}
