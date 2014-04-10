package entities;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@EqualsAndHashCode(of={"id"})

@NamedQueries({

	@NamedQuery(name="allAdherents",query="select ad from Adherent ad"),
	@NamedQuery(name="findAdherentByName",query="select ad from Adherent ad WHERE ad.nom = :nomAdherent")

})

public class Adherent implements Serializable {

	@Id
	@Column(columnDefinition="VARCHAR(36)")
	String id = UUID.randomUUID().toString();
	String nom;
	String prenom;
	String licence_fcd;
	String licence_ffba;


}
