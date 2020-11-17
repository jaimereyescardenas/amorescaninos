package cl.recoders.amorescaninos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import cl.recoders.amorescaninos.entity.Caracteristica;
import cl.recoders.amorescaninos.entity.Perfil;
import cl.recoders.amorescaninos.entity.Raza;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long>{
	
	List<Perfil> findByCaracteristicasIn(List<Caracteristica> caract);
	List<Perfil> findByRaza(Raza raza);
	List<Perfil> findByEdad(int edad);
	List<Perfil> findByGenero(String genero);
	List<Perfil> findByCaracteristicasInAndRazaAndGeneroContaining(
	  @Nullable List<Caracteristica> caract,
	  @Nullable Raza raza,
	  @Nullable String genero
	);
	List<Perfil> findByCaracteristicasInAndRazaAndEdadAndGeneroContaining(
	  @Nullable List<Caracteristica> caract,
	  @Nullable Raza raza,
	  int edad,
	  @Nullable String genero
	);
	
}
