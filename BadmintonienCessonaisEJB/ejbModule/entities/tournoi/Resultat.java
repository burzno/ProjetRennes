package entities.tournoi;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

/**
 * Entité sérialisable et persistée permettant de gérer les résultats 
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
@EqualsAndHashCode(of={"idResultat"})
public class Resultat implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long idResultat;
	
	@Version
	long version;
	
	@ManyToOne
	Match match;
	@Column(name="set_num")
	int set;
	
	@ManyToOne
	Equipe Equipe1;
	int resultatEquipe1;

	@ManyToOne
	Equipe Equipe2;
	int resultatEquipe2;
}
