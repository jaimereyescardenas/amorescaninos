package cl.recoders.amorescaninos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.recoders.amorescaninos.entity.Caracteristica;
import cl.recoders.amorescaninos.entity.Perfil;
import cl.recoders.amorescaninos.entity.Raza;
import cl.recoders.amorescaninos.repository.PerfilRepository;

@Service
public class PerfilServiceImpl implements PerfilService {

	@Autowired
	PerfilRepository perfilRepo;
	
	@Override
	public Perfil create(Perfil perfil) {
		return perfilRepo.save(perfil);
	}

	@Override
	public Perfil edit(Perfil perfil) {
		return perfilRepo.save(perfil);
	}

	@Override
	public Perfil findById(long id) {
		return perfilRepo.findById(id).orElse(null);
	}

	@Override
	public List<Perfil> findAll() {
		return perfilRepo.findAll();
	}

	@Override
	public List<Perfil> findByCaracteristica(Caracteristica caract) {
		return perfilRepo.findByCaracteristica(caract);
	}

	@Override
	public List<Perfil> findByRaza(Raza raza) {
		return perfilRepo.findByRaza(raza);
	}

	@Override
	public List<Perfil> findByEdad(int edad) {
		return perfilRepo.findByEdad(edad);
	}

	@Override
	public List<Perfil> findByGenero(String genero) {
		return perfilRepo.findByGenero(genero);
	}

	@Override
	public List<Perfil> findByMultipleFields(Caracteristica caract, Raza raza,
										int edad, String genero) {
		
		if (edad <= 0) {
			return perfilRepo.findByCaracteristicaAndRazaAndGeneroContaining(
			  caract, raza, genero);
		}
		
		return perfilRepo.findByCaracteristicaAndRazaAndEdadAndGeneroContaining(
			  caract, raza, edad, genero);
	}

}
