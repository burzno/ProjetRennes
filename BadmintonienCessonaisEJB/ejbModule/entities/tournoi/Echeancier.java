package entities.tournoi;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@EqualsAndHashCode(of={"idEcheancier"})
public class Echeancier implements Serializable {

	@Id
	@Column(columnDefinition="VARCHAR(36)")
	String idEcheancier = UUID.randomUUID().toString();
	
	@Temporal(TemporalType.TIMESTAMP)
	Date horaire;
	
	@ManyToOne
	Tournoi tournoi;
	@OneToOne
	Match match;
}
