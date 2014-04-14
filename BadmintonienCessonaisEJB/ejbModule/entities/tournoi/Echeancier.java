package entities.tournoi;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

@SuppressWarnings("serial")
@Entity
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@EqualsAndHashCode(of={"idEcheancier"})
public class Echeancier implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long idEcheancier;
	@Version
	long version;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	Date horaire;
	
	@ManyToOne
	Tournoi tournoi;
	@OneToOne
	Match match;
}
