package beans.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
	
	public static String hash(String plaintext) {
        MessageDigest md = null;
 
        try {
            md = MessageDigest.getInstance("SHA-1"); // SHA-1 generator instance
        } catch(NoSuchAlgorithmException e) {
            return "";
        }
 
        try {
            //8859_1 ou UTF-8
            md.update(plaintext.getBytes("UTF-8")); // Message summary generation
        } catch(UnsupportedEncodingException e) {
            return "";
        }
 
        byte raw[] = md.digest(); // Message summary reception
 
        try{
            String hash = new String(org.apache.commons.codec.binary.Base64.encodeBase64(raw),"UTF-8");
            //String hash = new String(raw);
            return hash;
        }
        catch (UnsupportedEncodingException use){
            return "";
        }
    }
	
}
