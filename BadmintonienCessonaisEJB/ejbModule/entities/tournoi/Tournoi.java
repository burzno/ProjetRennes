package entities.tournoi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

@SuppressWarnings("serial")
@Entity
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@EqualsAndHashCode(of={"idTournoi"})
public class Tournoi implements Serializable {

	@Id
	@Column(columnDefinition="VARCHAR(36)")
	String idTournoi = UUID.randomUUID().toString();
	String nom;
	@Temporal(TemporalType.DATE)
	Date dateTournoi;
	String lieu;
	int dureeMatch;
	int dureeRecup;
	int nbTerrain;
	
	@OneToMany
	List<Tableau> tableaux = new ArrayList<>();
	@OneToMany
	List<Echeancier> echeanciers = new ArrayList<>();
	
}
