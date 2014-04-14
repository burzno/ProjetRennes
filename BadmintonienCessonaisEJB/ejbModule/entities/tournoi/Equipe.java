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
import entities.Adherent;

@SuppressWarnings("serial")
@Entity
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@EqualsAndHashCode(of={"idEquipe"})
public class Equipe implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long idEquipe;
	
	@Version
	long version;
	
	@ManyToOne
	Adherent adherent;
	@ManyToOne
	Adherent partenaire;
	
	@ManyToOne
	Poule poule;
	@ManyToOne
	TableauElimination tableauElimination;
	
	//TODO Refaire cette partie en prenant en compte le fait que
	//le mapping doit se faire sur l'equipe1 ou l'équipe2
	//c'est une union des deux listes
	@OneToMany(mappedBy="equipe1", cascade=CascadeType.ALL, orphanRemoval=true)
	List<Match> matchs = new ArrayList<>();
}
