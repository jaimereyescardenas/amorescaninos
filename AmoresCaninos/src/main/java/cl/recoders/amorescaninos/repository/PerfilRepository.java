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
	
	List<Perfil> findByCaracteristica(Caracteristica caract);
	List<Perfil> findByRaza(Raza raza);
	List<Perfil> findByEdad(int edad);
	List<Perfil> findByGenero(String genero);
//	List<Perfil> findByCaracteristicaAndRaza(Caracteristica caract, Raza raza);
//	List<Perfil> findByCaracteriticaAndEdad(Caracteristica caract, int edad);
//	List<Perfil> findByCaracteristicaAndGenero(Caracteristica caract, String genero);
//	List<Perfil> findByRazaAndEdad(Raza raza, int edad);
//	List<Perfil> findByRazaAndGenero(Raza raza, String genero);
//	List<Perfil> findByEdadAndGenero(int edad, String genero);
//	List<Perfil> findByCaracteristicaAndRazaAndEdad(Caracteristica caract, Raza raza, int edad);
	List<Perfil> findByCaracteristicaAndRazaAndGenero(
	  @Nullable Caracteristica caract,
	  @Nullable Raza raza,
	  @Nullable String genero
	);
//	List<Perfil> findByCaracteristicaAndEdadAndGenero(Caracteristica caract, int edad, String genero);
//	List<Perfil> findByRazaAndEdadAndGenero(Raza raza, int edad, String genero);
	List<Perfil> findByCaracteristicaAndRazaAndEdadAndGenero(
	  @Nullable Caracteristica caract,
	  @Nullable Raza raza,
	  int edad,
	  @Nullable String genero
	);
	
}
