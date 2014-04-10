package beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;


@ManagedBean
public class IndexPageBean{
	
	

	//après construction, init ma méthode
	@PostConstruct
	public void init(){
		
	}
	
	//avant que le garbageCollector de passe
	@PreDestroy
	public void shutdown(){
		
	}
	

	
	
}
