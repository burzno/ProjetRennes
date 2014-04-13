package entities.tournoi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import entities.Adherent;
import entities.Categorie;
import entities.Classement;
import entities.Format;

@SuppressWarnings("serial")
@Entity
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@EqualsAndHashCode(of={"idTableau"})
public class Tableau implements Serializable {

	@Id
	@Column(columnDefinition="VARCHAR(36)")
	String idTableau = UUID.randomUUID().toString();
	int nbPax;

	@ManyToOne
	Tournoi tounoi;
	
	@ManyToMany
	List<Adherent> adherent = new ArrayList<>();
	
	@ManyToOne
	Format format;
	@ManyToMany
	List<Classement> classements = new ArrayList<>();
	@ManyToMany
	List<Categorie> categories = new ArrayList<>();

	@OneToMany
	List<Poule> poules = new ArrayList<>();
	@OneToOne
	TableauElimination tableauElimintations;
	
}
