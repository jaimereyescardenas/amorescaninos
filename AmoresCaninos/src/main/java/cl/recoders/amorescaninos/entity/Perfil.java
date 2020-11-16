package cl.recoders.amorescaninos.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "perfil")
@SequenceGenerator(name = "perfil_id_seq", sequenceName = "perfil_id_seq")
@Getter @Setter
@NoArgsConstructor
public class Perfil {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perfil_id_seq")
	private Long id;
	
	@Column(name = "nombre", length = 30, nullable = false)
	private String nombre;

	@Column(name = "genero", length = 15, nullable = false)
	private String genero;
	
	@Column(name = "edad", nullable = false)
	private int edad;
	
	@Column(name = "frase", length = 100, nullable = false)
	private String frase;
	
	@Column(name = "url_imagen", length = 200, nullable = false)
	private String url_imagen;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "raza_id")
	private Raza raza;
	
	@ManyToMany(
	  fetch = FetchType.EAGER,
	  cascade = {
		CascadeType.DETACH,
		CascadeType.MERGE,
		CascadeType.PERSIST,
		CascadeType.REFRESH
	})
	@JoinTable(
	  name = "perfil_has_caracteristica",
	  joinColumns = @JoinColumn(name = "perfil_id"),
	  inverseJoinColumns = @JoinColumn(name = "caracteristica_id"))
	private Set<Caracteristica> caracteristicas;
	
}
