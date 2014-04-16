package beans.adherent;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import lombok.Data;
import sessions.facades.utilisateur.FacadeAdherent;
import entities.utilisateur.Adherent;

@ManagedBean
@Data
public class CreationAdherentBean {
		
	@EJB
	private FacadeAdherent facadeAdherent;
	
	private Adherent adherent;
	
		//après construction, init ma méthode
		@PostConstruct
		public void init(){
			adherent = facadeAdherent.newInstance();
		}
		
		//avant que le garbageCollector ne passe
		@PreDestroy
		public void shutdown(){
			
		}
		
		public void enregistrerAdherent(){
			facadeAdherent.create(adherent);
		}

}
