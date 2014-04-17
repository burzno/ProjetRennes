package init;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map.Entry;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import sessions.dao.DaoCategorie;
import sessions.dao.DaoClub;
import sessions.dao.DaoFormat;
import sessions.facades.utilisateur.FacadeAdherent;
import sessions.facades.utilisateur.FacadeProfil;
import sun.util.logging.resources.logging;
import entities.utilisateur.Adherent;
import entities.utilisateur.Categorie;
import entities.utilisateur.Club;
import entities.utilisateur.Format;
import entities.utilisateur.Profil;
import entities.utilisateur.Sexe;


@SuppressWarnings("serial")
@FieldDefaults(level=AccessLevel.PRIVATE)
@Singleton
@Startup
public class Lancement implements Serializable{

	Log log = LogFactory.getLog(this.getClass());
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@EJB
	FacadeAdherent facadeAdherent;
	@EJB
	FacadeProfil facadeProfil;
	@EJB
	DaoFormat daoFormat;
	@EJB
	DaoCategorie daoCategorie;
	@EJB
	DaoClub daoClub;

	@PostConstruct
	public void init(){
			try {
				log.debug("-------------------------Init chargment BDD-------------------------");
				Properties prop = new Properties();
				prop.load(this.getClass().getResourceAsStream("jeuDeDonnees.properties"));
				genererData(prop);
				log.debug("-------------------------Fin chargment BDD-------------------------");
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	private void genererData(Properties dataProperties){
			String init = dataProperties.getProperty("init");
			log.debug("Tables chargées : "+init);
			if(init != null && !init.trim().equals("")){
				for (Entry<Object, Object> entry : dataProperties.entrySet()){
					String key = entry.getKey().toString();
					key = key.split("_")[0];
					if(init.contains(key)){
						String[] data = entry.getValue().toString().split(",");
						switch (key) {
							case "Format":
								creerFormat(data);
								break;
							case "Categorie":
								creerCategorie(data);
								break;
							case "Profil":
								creerProfil(data);
								break;
							case "Club":
								creerClub(data);
								break;
							case "Adherent":
								creerAdherent(data);
								break;
							default:
								break;
						}
					}
				}
			}
	}

	private void creerFormat(String[] data){
		log.debug("Chargement table -Format-");
		Format f = daoFormat.newInstance();
		f.setLibelleFormat(data[0]);
		f.setLibelleFormatCourt(data[1]);
		daoFormat.create(f);
	}
	
	private void creerCategorie(String[] data){
		log.debug("Chargement table -Categorie-");
		Categorie c = daoCategorie.newInstance();
		c.setLibelleCategorie(data[0]);
		c.setLibelleCategorieCourt(data[1]);
		daoCategorie.create(c);
	}
	
	private void creerProfil(String[] data){
		log.debug("Chargement table -Profil-");
		Profil p = facadeProfil.newInstance();
		p.setLibelleProfil(data[0]);
		facadeProfil.create(p);
	}
	
	private void creerClub(String[] data){
		log.debug("Chargement table -Club-");
		Club c = daoClub.newInstance();
		c.setNomClub(data[0]);
		daoClub.create(c);
	}

	private void creerAdherent(String[] data){
		log.debug("Chargement table -Adhérent-");
		try {
			Adherent a = facadeAdherent.newInstance();
			a.setLicenceFcd(data[0]);
			a.setLicenceFfba(data[1]);
			a.setNom(data[2]);
			a.setPrenom(data[3]);
			a.setSexe(Sexe.valueOf(data[4])); 
			a.setDateNaissance(sdf.parse(data[5]));
			a.setReferent(Boolean.getBoolean(data[6]));
			a.setProfil(facadeProfil.getProfilByLibelle(data[7]));
			facadeAdherent.create(a);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}


}

