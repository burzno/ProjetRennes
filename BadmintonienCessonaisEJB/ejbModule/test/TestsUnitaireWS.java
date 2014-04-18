package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.ejb.EJB;

import org.junit.Test;

import sessions.facades.utilisateur.FacadeAdherent;
import webservice.ClassementFFBAWS;
import webservice.ClassementInterop;
import webservice.ClassementInteropService;
import entities.reference.Format;
import entities.utilisateur.Adherent;
import entities.utilisateur.ClassementFFBA;

public class TestsUnitaireWS {
	
	@EJB
	FacadeAdherent facadeAdherent;

	@Test
	public void testClassementFFBA(){
		ClassementInterop ws = new ClassementInteropService().getClassementInteropPort();
		ClassementFFBAWS classement = ws.getClassementFfba("14587965");
		assertNotNull(classement);
		assertEquals("A2", classement.getSimple());
		assertEquals("D4", classement.getDouble());
		assertEquals("C3", classement.getDoubleMixte());
	}
	
	
	//TODO voir comment faire fonctionner les testUnitaires avec les facades!!!!!!!!!!!!!!
	
	public void testClassementFFBAViaAdherent(){
		FacadeAdherent facadeAdherent = new FacadeAdherent();
		Adherent ad = facadeAdherent.newInstance();
		ad.setLicenceFfba("14587965");
		
		ClassementFFBA classement = facadeAdherent.getClassementFFBAWebService(ad);
		assertNotNull(classement);
		assertEquals("A2", classement.getClassement().get(Format.SPL));
		assertEquals("D4", classement.getClassement().get(Format.DBL));
		assertEquals("C3", classement.getClassement().get(Format.DBM));
	}
}
