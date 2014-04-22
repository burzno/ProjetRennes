package sessions.facades.utilisateur;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import sessions.dao.DaoAdherent;
import sessions.dao.DaoPieces;
import sessions.facades.references.FacadeReferences;
import webservice.ClassementFFBA;
import webservice.ClassementInterop;
import webservice.ClassementInteropService;
import entities.utilisateur.Adherent;
//github.com/burzno/ProjetRennes.git
import entities.utilisateur.Classement;
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


	public void create(Adherent t){
		daoAdherent.create(t);
	
	}



	public Adherent newInstance() {
		Adherent a = daoAdherent.newInstance();
		a.setPieces(daoPieces.newInstance());
		
		return a;
	}


	public Adherent read(Object id) {
		return daoAdherent.read(id);
	}


	public List<Adherent> readAll() {

		return daoAdherent.readAll();
	}



	public Adherent update(Adherent t) {

		return daoAdherent.update(t);
	}


	public void delete(Adherent t) {
		daoAdherent.delete(t);

	}

	public String[] getListeSexeStringTab(){
		String[] sexes = new String[Sexe.values().length];
		int cpt=0;
		for (Sexe s : Sexe.values()) {
			sexes[cpt] =  s.getLibelle();
			cpt++;
		}
		return sexes;
	}
	
	public List<Sexe> getListeSexeList(){
		List<Sexe> sexes = new ArrayList<>();
		for (Sexe s : Sexe.values()) {
			sexes.add(s);
		}
		return sexes;
	}

	public List<Classement> getClassementFFBAWebService(Adherent t){
		ClassementInterop ws = new ClassementInteropService().getClassementInteropPort();
		ClassementFFBA classement = ws.getClassementFfba(t.getLicenceFfba());
		List<Classement> classements = new ArrayList<>();
		classements.add(setClassement(t.getLicenceFfba(), classement.getSimple(), "SPL"));
		classements.add(setClassement(t.getLicenceFfba(), classement.getDouble(), "DBL"));
		classements.add(setClassement(t.getLicenceFfba(), classement.getDoubleMixte(), "DBM"));
		return classements;
	}

	private Classement setClassement(String licenceFfba, String classement, String format){
		Classement classe = new Classement();
		classe.setFormat(facadeRef.getFormatByLibelleCourt(format));
		classe.setLibelleClassement(classement);
		classe.setLicenceFfba(licenceFfba);
		return classe;
	}

	public Adherent getAdherentByMail(String mailAdherent){

		return daoAdherent.getAdherentByMail(mailAdherent);
	}
	
	public boolean isExistAdherent(String mailAdherent){

		return daoAdherent.isExistAdherent(mailAdherent);
	}
	


}

