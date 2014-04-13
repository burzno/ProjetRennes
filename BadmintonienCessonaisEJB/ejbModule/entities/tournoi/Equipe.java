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
	@Column(columnDefinition="VARCHAR(36)")
	String idEquipe = UUID.randomUUID().toString();
	
	@ManyToOne
	Adherent adherent;
	@ManyToOne
	Adherent partenaire;
	
	@ManyToOne
	Poule poule;
	@ManyToOne
	TableauElimination tableauElimination;
	
	@OneToMany
	List<Match> matchs = new ArrayList<>();
	
}
