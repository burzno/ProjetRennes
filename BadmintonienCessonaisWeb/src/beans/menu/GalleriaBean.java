package beans.menu;  

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class GalleriaBean {  

    private List<String> images;  

    private String effect = "fade";  

    @PostConstruct  
    public void init() {  
        images = new ArrayList<String>();  

        for(int i=1;i<=15;i++) {  
            images.add("galleria" + i + ".jpg");  
        }  
    }  

    public List<String> getImages() {  
        return images;  
    }  

    public String getEffect() {  
        return effect;  
    }  

    public void setEffect(String effect) {  
        this.effect = effect;  
    }  
}  
                      