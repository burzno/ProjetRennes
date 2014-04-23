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


		/**
		 * Création de la dao profil
		 * @param p
		 */
		public void create(Profil p) {
			daoProfil.create(p);
		}

		/**
		 * lecture de tous les profils contenus dans l'EJB
		 * @return
		 */
		public List<Profil> readAll() {
			
			return daoProfil.readAll();
		}
		
		/**
		 * Nouvelle instance de profil
		 * @return
		 */
		public Profil newInstance() {
			
			return daoProfil.newInstance();
		}
		
		/**
		 * recherche des profils par libellé
		 * @param libelle
		 * @return
		 */
		public Profil getProfilByLibelle(String libelle){
			return daoProfil.search("libelleProfil", libelle).get(0);
		}


}
