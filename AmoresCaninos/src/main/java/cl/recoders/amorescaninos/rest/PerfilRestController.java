package cl.recoders.amorescaninos.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.recoders.amorescaninos.data.PerfilData;
import cl.recoders.amorescaninos.entity.Caracteristica;
import cl.recoders.amorescaninos.entity.Perfil;
import cl.recoders.amorescaninos.entity.Raza;
import cl.recoders.amorescaninos.service.CaracteristicaService;
import cl.recoders.amorescaninos.service.PerfilService;
import cl.recoders.amorescaninos.service.RazaService;

@RestController
@RequestMapping("/rest/perfil")
public class PerfilRestController {

	@Autowired
	RazaService razaService;
	
	@Autowired
	CaracteristicaService caractService;
	
	@Autowired
	PerfilService perfilService;
	
	@GetMapping(path = "/list")
	@CrossOrigin("*")
	public RestResponseWrapper<Perfil> perfilList() {
		RestResponseWrapper<Perfil> r = new RestResponseWrapper<>(perfilService.findAll());
		return r;
	}
	
	@PostMapping(path = "/search")
	@CrossOrigin("*")
	public RestResponseWrapper<Perfil> searchPerfil(
	  @RequestBody Map<String, String> params) {
		
		long caracteristicaId = Long.parseLong(params.get("caracteristica"));
		long razaId = Long.parseLong(params.get("raza"));
		int edad = Integer.parseInt(params. get("edad"));
		String genero = params.get("genero"); 
		
		System.out.println(caracteristicaId);
		System.out.println(razaId);
		System.out.println(edad);
		System.out.println(genero);
		
		// Preparar lista de ids de caracteristicas
		List<Long> caractList = List.of(caracteristicaId);
		
		// Preparar listas de raza y genero
		List<Raza> raza = new ArrayList<>();
		raza.add(razaService.findById(razaId));
		List<String> genList = new ArrayList<>();
		genList.add(genero);
		
		// Comprobar cada campo para ver si se debe filtrar
		raza = (razaId == 0) ? razaService.findAll() : raza;
		List<Caracteristica> caract = (caracteristicaId == 0) ? caractService.findAll() : caractService.findAllById(caractList);
		genList = genero.equals("Todos") ? PerfilData.GENEROS : genList;
		
		// Aplicar filtros correspondientes y enviar el resultado
		List<Perfil> perfiles = perfilService.findByMultipleFields(caract, raza, edad, genList);
		
		RestResponseWrapper<Perfil> r = new RestResponseWrapper<>(perfiles);
		return r;
	}
	
}