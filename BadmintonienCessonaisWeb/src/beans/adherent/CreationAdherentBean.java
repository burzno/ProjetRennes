package beans.adherent;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

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
@ViewScoped
public class CreationAdherentBean {

	@EJB
	private FacadeAdherent facadeAdherent;
	@EJB
	private FacadeProfil facadeProfil;
	@EJB
	private FacadeClub facadeClub;

	private Adherent adherent;

	private String destination="D:\\";

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

	public void upload(FileUploadEvent event) {  
		System.out.println("ici");
		FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");  
		FacesContext.getCurrentInstance().addMessage(null, msg);
		// Do what you want with the file        
		try {
			System.out.println("ici");
			copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
			System.out.println("la");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}  

	public void copyFile(String fileName, InputStream in) {
		try {


			// write the inputStream to a FileOutputStream
			OutputStream out = new FileOutputStream(new File(destination + fileName));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			in.close();
			out.flush();
			out.close();

			System.out.println("New file created!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

} 

