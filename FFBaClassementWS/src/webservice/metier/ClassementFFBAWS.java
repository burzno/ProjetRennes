package webservice.metier;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@XmlAccessorType(XmlAccessType.FIELD)
public class ClassementFFBAWS {

	
	@XmlAttribute(name="licence")
	String licenceFFBA;
	@XmlElement(name="simple")
	String matchSimple;
	@XmlElement(name="double")
	String matchDouble;
	@XmlElement(name="doubleMixte")
	String matchDoubleMixte;
}
