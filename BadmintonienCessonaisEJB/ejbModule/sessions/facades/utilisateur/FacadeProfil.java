package sessions.facades.utilisateur;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import sessions.dao.DaoProfil;
import entities.utilisateur.Profil;


@Stateless
public class FacadeProfil {
	
	
		@EJB
		private DaoProfil daoProfil;


		public void create(Profil p) {
			daoProfil.create(p);
		}


		public List<Profil> readAll() {
			
			return daoProfil.readAll();
		}
		
		public Profil newInstance() {
			
			return daoProfil.newInstance();
		}
		
		public Profil getProfilByLibelle(String libelle){
			return daoProfil.search("libelleProfil", libelle).get(0);
		}


}
