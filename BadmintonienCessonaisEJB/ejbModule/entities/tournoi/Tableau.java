package entities.tournoi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import entities.reference.Categorie;
import entities.reference.Classement;
import entities.reference.Format;
import entities.utilisateur.Adherent;

@SuppressWarnings("serial")
@Entity
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@EqualsAndHashCode(of={"idTableau"})
public class Tableau implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long idTableau;
	
	@Version
	long version;
	
	int numTab;
	
	int nbPax;

	@ManyToOne
	Tournoi tournoi;
	
	@ManyToMany
	List<Adherent> adherent = new ArrayList<>();
	
	@Enumerated(EnumType.STRING)
	Format format;
	@Enumerated(EnumType.STRING)
	List<Classement> classements = new ArrayList<>();
	@Enumerated(EnumType.STRING)
	List<Categorie> categories = new ArrayList<>();

	@OneToMany(mappedBy="tableau", cascade=CascadeType.ALL, orphanRemoval=true)
	List<Poule> poules = new ArrayList<>();
	@OneToOne
	TableauElimination tableauElimintations;
	
}
