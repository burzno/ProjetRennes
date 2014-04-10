package entities;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;


@SuppressWarnings("serial")
@Entity
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@EqualsAndHashCode(of={"id"})
public class Format implements Serializable {
	
	@Id
	@Column(columnDefinition="VARCHAR(36)")
	String id = UUID.randomUUID().toString();
	String libelle;
	String libelleCourt;

}
