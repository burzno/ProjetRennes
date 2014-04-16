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
@EqualsAndHashCode(of={"idFormat"})
public class Format implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long idFormat;
	@Version
	long version;
	String libelleFormat;
	String libelleFormatCourt;
	


}
