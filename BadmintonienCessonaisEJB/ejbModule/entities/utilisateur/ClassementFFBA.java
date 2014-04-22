package entities.utilisateur;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import entities.reference.Classement;
import entities.reference.Format;

@SuppressWarnings("serial")
@Entity
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@EqualsAndHashCode(of={"idClassement"})
public class ClassementFFBA implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long idClassement;
	@Version
	long version;
	@OneToOne(mappedBy="Classement")
	Adherent adherent;
	
	@MapKeyEnumerated(EnumType.STRING)
	Map<Format, Classement> classement = new HashMap<Format, Classement>();
		
}