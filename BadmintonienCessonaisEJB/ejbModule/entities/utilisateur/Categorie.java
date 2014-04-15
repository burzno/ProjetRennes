package entities.utilisateur;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;


@SuppressWarnings("serial")
@Entity
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@EqualsAndHashCode(of={"idCategorie"})
public class Categorie implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long idCategorie;
	@Version
	long version;
	String libelleCategorie;
	String libelleCategorieCourt;

}
