package entities.actua;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Version;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

@SuppressWarnings("serial")
@Entity
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@EqualsAndHashCode(of={"idActualite"})
public class Actualite implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long idActualite;
	
	@Version
	long version;
	
	String name;
	
	String libelle;
	
	String image;
	
	@Lob
	String descriptif;
}
