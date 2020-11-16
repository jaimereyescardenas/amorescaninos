package cl.recoders.amorescaninos.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "raza")
@SequenceGenerator(name = "raza_id_seq", sequenceName = "raza_id_seq")
@Getter @Setter
@NoArgsConstructor
public class Raza {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "raza_id_seq")
	private Long id;
	
	@Column(name = "nombre", length = 30, nullable = false)
	private String nombre;
	
	@OneToMany(mappedBy = "raza", fetch = FetchType.EAGER)
	private Set<Perfil> perfiles;
	
}
