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

@SuppressWarnings("serial")
@Entity
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@EqualsAndHashCode(of={"idPoule"})
public class Poule implements Serializable {

	@Id
	@Column(columnDefinition="VARCHAR(36)")
	String idPoule = UUID.randomUUID().toString();
	String nom;
	
	@ManyToOne
	Tableau tableau;
	@OneToMany
	List<Match> matchs =  new ArrayList<>();
	@OneToMany
	List<Equipe> equipes = new ArrayList<>();
	
}
