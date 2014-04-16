package entities.utilisateur;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

@SuppressWarnings("serial")
@Entity
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@EqualsAndHashCode(of={"idClassement"})
public class Classement implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long idClassement;
	@Version
	long version;
	String libelleClassement;
	@ManyToOne
	Format format;
	String licenceFfba;
	
}
