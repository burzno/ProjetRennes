package webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import exception.ClassementException;
import webservice.metier.ClassementFFBA;
import webservice.metier.GestionClassement;

@WebService
public class ClassementInterop {
	
	/**
	 * Méthode permettant de récupérer le classementFFBA d'un licencié
	 * @param licenceFFBa
	 * @return
	 */
	@XmlElement(name="classementFFBA")
	@WebMethod
	public ClassementFFBA getClassementFfba(String licenceFFBa){
		GestionClassement gestion = new GestionClassement();
		ClassementFFBA classement = null;
		try {
			classement = gestion.getClassementByLicenceFFBa(licenceFFBa);
		} catch (ClassementException e) {
			//Pas de classement trouvé
			classement = new ClassementFFBA();
			classement.setLicenceFFBA(licenceFFBa);
		}
		return classement;
	}

}
