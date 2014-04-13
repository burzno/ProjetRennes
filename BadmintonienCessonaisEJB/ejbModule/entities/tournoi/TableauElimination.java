package entities.tournoi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@EqualsAndHashCode(of={"idTableauElimination"})
public class TableauElimination implements Serializable {

	@Id
	@Column(columnDefinition="VARCHAR(36)")
	String idTableauElimination = UUID.randomUUID().toString();
	
	@OneToOne
	Tableau tableau;
	@OneToMany
	List<Match> matchs =  new ArrayList<>();
	@OneToMany
	List<Equipe> equipes = new ArrayList<>();
}
