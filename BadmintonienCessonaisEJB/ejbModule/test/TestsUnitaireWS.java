package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;

import org.junit.Test;

import sessions.facades.utilisateur.FacadeAdherent;
import webservice.ClassementFFBA;
import webservice.ClassementInterop;
import webservice.ClassementInteropService;
import entities.utilisateur.Adherent;
import entities.utilisateur.Classement;

public class TestsUnitaireWS {
	
	@EJB
	FacadeAdherent facadeAdherent;

	@Test
	public void testClassementFFBA(){
		ClassementInterop ws = new ClassementInteropService().getClassementInteropPort();
		ClassementFFBA classement = ws.getClassementFfba("14587965");
		assertNotNull(classement);
		assertEquals("A2", classement.getSimple());
		assertEquals("D4", classement.getDouble());
		assertEquals("C3", classement.getDoubleMixte());
	}
	
	
	//TODO voir comment faire fonctionner les testUnitaires avec les facades!!!!!!!!!!!!!!
	@Test
	public void testClassementFFBAViaAdherent(){
		FacadeAdherent facadeAdherent = new FacadeAdherent();
		Adherent ad = facadeAdherent.newInstance();
		ad.setLicenceFfba("14587965");
		
		List<Classement> classement = facadeAdherent.getClassementFFBAWebService(ad);
		assertNotNull(classement);
		assertEquals(false, classement.isEmpty());
		for (Classement classe : classement) {
			String expected = "";
			switch (classe.getFormat().getLibelleFormatCourt()) {
				case "SPL":
					expected = "A2";
					break;
				case "DBL":
					expected = "D4";
					break;
				case "DBM":
					expected = "C3";
					break;
				default:
					break;
			}
			assertEquals(expected, classe.getLibelleClassement());
				
		}
	}
}
