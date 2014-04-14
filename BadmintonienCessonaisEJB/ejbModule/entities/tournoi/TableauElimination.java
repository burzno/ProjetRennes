package entities.tournoi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

@SuppressWarnings("serial")
@Entity
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@EqualsAndHashCode(of={"idTableauElimination"})
public class TableauElimination implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long idTableauElimination;
	
	@Version
	long version;
	
	@OneToOne
	Tableau tableau;
	@OneToMany(mappedBy="tableauElimination", cascade=CascadeType.ALL, orphanRemoval=true)
	List<Match> matchs =  new ArrayList<>();
	@OneToMany(mappedBy="tableauElimination", cascade=CascadeType.ALL, orphanRemoval=true)
	List<Equipe> equipes = new ArrayList<>();
}
