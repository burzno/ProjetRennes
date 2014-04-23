package beans.utils;

import java.util.List;

import javax.faces.model.SelectItem;

public class Utils {

	
	public static SelectItem[] createFilterOptions(String[] data)  {  
        SelectItem[] options = new SelectItem[data.length + 1];  
  
        options[0] = new SelectItem("", "Select");  
        for(int i = 0; i < data.length; i++) {  
            options[i + 1] = new SelectItem(data[i], data[i]);  
        }  
  
        return options;  
    }
	
	public static SelectItem[] createFilterOptions(List<Enum> data)  {  
		SelectItem[] options = new SelectItem[data.size() + 1];  
		
		options[0] = new SelectItem("", "Select");  
		for(int i = 0; i < data.size(); i++) {  
			options[i + 1] = new SelectItem(data.get(i).toString(), data.get(i).toString());  
		}  
		
		return options;  
	}
	
}
