package beans.adherent;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import lombok.Data;
import sessions.facades.utilisateur.FacadeAdherent;
import sessions.facades.utilisateur.FacadeClub;
import sessions.facades.utilisateur.FacadeProfil;
import entities.utilisateur.Adherent;
import entities.utilisateur.Club;
import entities.utilisateur.Profil;
import entities.utilisateur.Sexe;

@ManagedBean
@Data
public class CreationAdherentBean {

	@EJB
	private FacadeAdherent facadeAdherent;
	@EJB
	private FacadeProfil facadeProfil;
	@EJB
	private FacadeClub facadeClub;

	private Adherent adherent;

	//après construction, init ma méthode
	@PostConstruct
	public void init(){
		adherent = facadeAdherent.newInstance();
	}


	public void enregistrerAdherent(){
		facadeAdherent.create(adherent);
	}

	public List<Profil> getListProfils(){
		return facadeProfil.readAll();
	}

	public List<Club> getListClubs(){
		return facadeClub.readAll();
	}
	
	public List<Sexe> getListSexe(){
		return facadeAdherent.getListeSexeList();
	}


}
