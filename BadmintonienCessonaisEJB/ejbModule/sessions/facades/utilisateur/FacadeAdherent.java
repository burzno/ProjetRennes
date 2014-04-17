package sessions.facades.utilisateur;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import sessions.dao.DaoAdherent;
import sessions.facades.references.FacadeReferences;
import webservice.ClassementFFBA;
import webservice.ClassementInterop;
import webservice.ClassementInteropService;
import entities.utilisateur.Adherent;
import entities.utilisateur.Classement;

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
	private FacadeReferences facadeRef;


	public void create(Adherent t) {
		daoAdherent.create(t);
	}



	public Adherent newInstance() {

		return daoAdherent.newInstance();
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

}

