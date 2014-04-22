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
@EqualsAndHashCode(of={"idPieces"})
public class Pieces implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long idPieces;
	@Version
	long version;
	
	boolean formulaireFcd;
	boolean chequeFcd;
	boolean licenceFcd;
	boolean certificatMedical;
	boolean chequeCsa;

}
