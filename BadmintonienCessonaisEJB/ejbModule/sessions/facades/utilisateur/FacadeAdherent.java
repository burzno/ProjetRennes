package sessions.facades.utilisateur;

import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import sessions.dao.DaoAdherent;
import sessions.dao.DaoPieces;
import sessions.facades.references.FacadeReferences;
import webservice.ClassementFFBAWS;
import webservice.ClassementInterop;
import webservice.ClassementInteropService;
import entities.reference.Classement;
import entities.reference.Format;
import entities.utilisateur.Adherent;
import entities.utilisateur.ClassementFFBA;
import entities.utilisateur.Sexe;

/**
 * Exemple D'EJB SESSION
 * @author lucas.guerrot
 *
 */
@Stateless
public class FacadeAdherent {


	@EJB
	private DaoAdherent daoAdherent;
	@EJB
	private DaoPieces daoPieces;
	@EJB
	private FacadeReferences facadeRef;

	/**
	 * création d'un adhérent
	 * @param t
	 */
	public void create(Adherent t){
		daoAdherent.create(t);

	}


	/**
	 * Nouvelle instance d'un adhérent
	 * @return
	 */
	public Adherent newInstance() {
		Adherent a = daoAdherent.newInstance();
		a.setPieces(daoPieces.newInstance());

		return a;
	}

	/**
	 * Instanciation d'un nouveau classement
	 * @return
	 */
	public ClassementFFBA newClassementFFBA() {
		return new ClassementFFBA();
	}

	/**
	 * lecture d'un adhérent à partir de son id
	 * @param id
	 * @return
	 */
	public Adherent read(Object id) {
		return daoAdherent.read(id);
	}

	/**
	 * Lecture de tous les adhérents
	 * @return
	 */
	public List<Adherent> readAll() {

		return daoAdherent.readAll();
	}


	/**
	 * Mise à jour d'un adhérent
	 * @param t
	 * @return
	 */
	public Adherent update(Adherent t) {

		return daoAdherent.update(t);
	}

	/**
	 * Suppression d'un adhérent
	 * @param t
	 */
	public void delete(Adherent t) {
		daoAdherent.delete(t);

	}

	/**
	 * Récupération de la liste des sexes sous forme d'un tableau
	 * @return
	 */
	public String[] getListeSexeStringTab(){
		String[] sexes = new String[Sexe.values().length];
		int cpt=0;
		for (Sexe s : Sexe.values()) {
			sexes[cpt] =  s.getLibelle();
			cpt++;
		}
		return sexes;
	}

	/**
	 * Récupération de la liste des sexes sous forme de liste
	 * @return
	 */
	public List<Sexe> getListeSexeList(){
		return Arrays.asList(Sexe.values());
	}

	/**
	 * Récupère le classement FFBA à partir du webservice
	 * @param t
	 * @return
	 */
	public ClassementFFBA getClassementFFBAWebService(Adherent t){
		ClassementInterop ws = new ClassementInteropService().getClassementInteropPort();
		ClassementFFBAWS classement = ws.getClassementFfba(t.getLicenceFfba());

		ClassementFFBA classementFbba = newClassementFFBA();
		try{
			classementFbba.getClassement().put(Format.SPL, Classement.valueOf(classement.getSimple()));
		}catch(Exception e){
		}
		try{
			classementFbba.getClassement().put(Format.DBL, Classement.valueOf(classement.getDouble()));
		}catch(Exception e){
		}
		try{
			classementFbba.getClassement().put(Format.DBM, Classement.valueOf(classement.getDoubleMixte()));
		}catch(Exception e){
		}
		return classementFbba;
	}


	/**
	 * Récupère l'adhérent à partir de son mail
	 * @param mailAdherent
	 * @return
	 */
	public Adherent getAdherentByMail(String mailAdherent){
		return daoAdherent.getAdherentByMail(mailAdherent);
	}

	/**
	 *Vérifie si le mail de l'adhérent existe 
	 * @param mailAdherent
	 * @return
	 */
	public boolean isExistAdherent(String mailAdherent){
		return daoAdherent.isExistAdherent(mailAdherent);
	}

	/**
	 * récupère la liste des adhérents actifs (non désactivés)
	 * 
	 */
	public List<Adherent> getListeAdherentsActifs(){
		return daoAdherent.search("actif", true, "nom");
	}


}

