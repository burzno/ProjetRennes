package entities.utilisateur;

/**
 * Enum permettant de choisir le sexe
 * @author g.joseph-mondesir
 *
 */
public enum Sexe {

	FEMME("Femme"),
	HOMME("Homme");



	private final String libelle;

	private Sexe(String libelle){
		this.libelle=libelle;
	}

	public String getLibelle() {
		return libelle;
	}

	@Override
	public String toString() {
		return getLibelle();
	}

}
