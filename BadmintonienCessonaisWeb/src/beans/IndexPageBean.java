package beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@ManagedBean
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
public class IndexPageBean{
	
	//après construction, init ma méthode
	@PostConstruct
	public void init(){
		
	}
	
	//avant que le garbageCollector ne passe
	@PreDestroy
	public void shutdown(){
		
	}
	
	

	
	
}
