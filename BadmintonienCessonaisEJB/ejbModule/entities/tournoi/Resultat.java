package entities.tournoi;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

@SuppressWarnings("serial")
@Entity
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@EqualsAndHashCode(of={"idResultat"})
public class Resultat implements Serializable {

	@Id
	@Column(columnDefinition="VARCHAR(36)")
	String idResultat = UUID.randomUUID().toString();
	
	@ManyToOne
	Match match;
	int set;
	
	@ManyToOne
	Equipe Equipe1;
	int resultatEquipe1;

	@ManyToOne
	Equipe Equipe2;
	int resultatEquipe2;
}
