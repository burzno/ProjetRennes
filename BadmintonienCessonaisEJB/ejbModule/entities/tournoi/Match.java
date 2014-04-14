package entities.tournoi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

@SuppressWarnings("serial")
@Entity
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@EqualsAndHashCode(of={"idMatch"})
public class Match implements Serializable {

	@Id
	@Column(columnDefinition="VARCHAR(36)")
	String idMatch = UUID.randomUUID().toString();

	@OneToOne
	Echeancier echeancier;
	
	@ManyToOne
	Poule poule;
	@ManyToOne
	TableauElimination tableauElimination;
	
	@OneToMany
	List<Resultat> resultats = new ArrayList<>();
	
	
	@ManyToOne
	Equipe	equipe1;
	@ManyToOne
	Equipe	equipe2;
	
}
