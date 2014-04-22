package webservice.metier;

import java.io.IOException;
import java.util.Properties;

import exception.ClassementException;

/**
 * Manipulation du fichier 
 * @author bruno.chabot
 *
 */
public class GestionClassement {

	
	
	private Properties getProperties(){
		Properties prop = new Properties();
		try {
			prop.load(this.getClass().getResourceAsStream("classements.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public ClassementFFBA getClassementByLicenceFFBa(String licenceFFBa) throws ClassementException{
		Properties prop = getProperties();
		if(prop.containsKey(licenceFFBa)){
			String[] data = prop.getProperty(licenceFFBa).split(",");
			return splitData(licenceFFBa, data);
		}else
			throw new ClassementException("Aucun classement ne correspond à cette licence");
	}
	
	private ClassementFFBA splitData(String licenceFFBa, String[] data){
		ClassementFFBA classement = new ClassementFFBA();
		classement.setLicenceFFBA(licenceFFBa);
		classement.setMatchSimple(data[0]);
		classement.setMatchDouble(data[1]);
		classement.setMatchDoubleMixte(data[2]);
		return classement;
	}
	
}
