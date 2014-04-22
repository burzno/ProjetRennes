package sessions.facades.utilisateur;

import java.util.ArrayList;
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


	public void create(Adherent t){
		daoAdherent.create(t);

	}



	public Adherent newInstance() {
		Adherent a = daoAdherent.newInstance();
		a.setPieces(daoPieces.newInstance());

		return a;
	}

	public ClassementFFBA newClassementFFBA() {
		return new ClassementFFBA();
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

	public List<Classement> getListeClassementsList(){
		List<Classement> classements = new ArrayList<>();
		for (Classement c : Classement.values()) {
			classements.add(c);
		}
		return classements;
	}

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


	public Adherent getAdherentByMail(String mailAdherent){

		return daoAdherent.getAdherentByMail(mailAdherent);
	}

	public boolean isExistAdherent(String mailAdherent){

		return daoAdherent.isExistAdherent(mailAdherent);
	}
<<<<<<< HEAD
=======



>>>>>>> branch 'master' of https://github.com/burzno/ProjetRennes.git


}

