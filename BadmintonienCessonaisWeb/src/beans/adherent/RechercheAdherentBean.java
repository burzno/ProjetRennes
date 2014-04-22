package beans.adherent;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import lombok.Data;
import sessions.facades.utilisateur.FacadeAdherent;
import sessions.facades.utilisateur.FacadeClub;
import utils.jsf.JsfUtils;
import entities.utilisateur.Adherent;

@ManagedBean
@Data
public class RechercheAdherentBean {
	
	@EJB
	private FacadeAdherent facadeAdherent;
	@EJB
	private FacadeClub facadeClub;
	
	private List<Adherent> filteredAdherents;  
	
	private SelectItem[] sexeOptions; 
	
	private SelectItem[] clubOptions; 
	
	private Adherent selectedAdherent;  
	
	@PostConstruct
	public void init(){
		sexeOptions = createFilterOptions(facadeAdherent.getListeSexeStringTab());
		clubOptions = createFilterOptions(facadeClub.listeClubsStringTab());
		
	}
	
	public List<Adherent> getListAdherents(){
		return facadeAdherent.readAll();
	}
	
	public List<Adherent> getListeAdherentsActifs(){
		return facadeAdherent.getListeAdherentsActifs();
	}
	
	
	private SelectItem[] createFilterOptions(String[] data)  {  
        SelectItem[] options = new SelectItem[data.length + 1];  
  
        options[0] = new SelectItem("", "Select");  
        for(int i = 0; i < data.length; i++) {  
            options[i + 1] = new SelectItem(data[i], data[i]);  
        }  
  
        return options;  
    }
	
	public void desactiverAdherent(){
		Adherent a = getSelectedAdherent(); 
		a.setActif(false);
		facadeAdherent.update(a);
		JsfUtils.sendMessage("Adhérent : "+a.getNom()+" désactivé");
		
	}
	
	public void selectionnerAdherent(){
		JsfUtils.putInFlashScope("ADHERENT_MODIF",getSelectedAdherent());
		
	}

}
