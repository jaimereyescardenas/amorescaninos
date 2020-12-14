package cl.recoders.amorescaninos.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "caracteristica")
@SequenceGenerator(name = "caract_id_seq", sequenceName = "caract_id_seq")
@Getter @Setter
@NoArgsConstructor
@JsonIgnoreProperties(
		  ignoreUnknown = true, 
		  value = {
			"hibernateLazyInitializer",
			"handler",
			"perfiles"})
public class Caracteristica {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "caract_id_seq")
	private Long id;
	
	@Column(name = "nombre", length = 30, nullable = false)
	private String nombre;
	
	@ManyToMany(
	  mappedBy = "caracteristicas",
	  fetch = FetchType.EAGER,
	  cascade = CascadeType.ALL)
	private Set<Perfil> perfiles;
	
}
