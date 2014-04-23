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
import javax.persistence.OneToOne;
import javax.persistence.Version;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

/**
 * Entité sérialisable et persistée permettant de gérer les matchs 
 * les getters et setters sont générés par lombok
 * les attributs privés sont générés automatiquement
 * equals et hashcode générés automatiquement
 * 
 * @author g.joseph-mondesir
 *
 */
@SuppressWarnings("serial")
@Entity(name="matchs")
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@EqualsAndHashCode(of={"idMatch"})
public class Match implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long idMatch;
	
	@Version
	long version;

	@OneToOne
	Echeancier echeancier;
	
	@ManyToOne
	Poule poule;
	@ManyToOne
	TableauElimination tableauElimination;
	
	@OneToMany(mappedBy="match", cascade=CascadeType.ALL, orphanRemoval=true)
	List<Resultat> resultats = new ArrayList<>();
	
	
	@ManyToOne
	Equipe	equipe1;
	@ManyToOne
	Equipe	equipe2;
	
}
