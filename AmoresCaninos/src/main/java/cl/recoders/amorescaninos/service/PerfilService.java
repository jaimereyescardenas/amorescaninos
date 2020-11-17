package cl.recoders.amorescaninos.service;

import java.util.List;

import cl.recoders.amorescaninos.entity.Caracteristica;
import cl.recoders.amorescaninos.entity.Perfil;
import cl.recoders.amorescaninos.entity.Raza;

public interface PerfilService {
	
	public Perfil create(Perfil perfil);
	public Perfil edit(Perfil perfil);
	public Perfil findById(long id);
	public List<Perfil> findAll();
	public List<Perfil> findByCaracteristicas(List<Caracteristica> caracteristica);
	public List<Perfil> findByRaza(Raza raza);
	public List<Perfil> findByEdad(int edad);
	public List<Perfil> findByGenero(String genero);
	public List<Perfil> findByMultipleFields(List<Caracteristica> caract, Raza raza, int edad, String genero);

}
