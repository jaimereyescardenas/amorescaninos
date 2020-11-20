package cl.recoders.amorescaninos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.recoders.amorescaninos.data.PerfilData;
import cl.recoders.amorescaninos.entity.Caracteristica;
import cl.recoders.amorescaninos.entity.Perfil;
import cl.recoders.amorescaninos.entity.Raza;
import cl.recoders.amorescaninos.service.CaracteristicaService;
import cl.recoders.amorescaninos.service.PerfilService;
import cl.recoders.amorescaninos.service.RazaService;

@Controller
public class PerfilController {
	
	@Autowired
	RazaService razaService;
	
	@Autowired
	CaracteristicaService caractService;
	
	@Autowired
	PerfilService perfilService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/match")
	public ModelAndView match() {
		ModelAndView mav = new ModelAndView("match");
		List<Raza> razas = razaService.findAll();
		List<Caracteristica> caracteristicas = caractService.findAll();
		List<Integer> edades = PerfilData.EDADES;
		List<String> generos = PerfilData.GENEROS;
		mav.addObject("razas", razas);
		mav.addObject("caracteristicas", caracteristicas);
		mav.addObject("edades", edades);
		mav.addObject("generos", generos);
		return mav;
	}
	
	@PostMapping("/match")
	public ModelAndView matchResults(
	  @RequestParam(name = "caracteristica-id", required = false) long caracteristicaId,
	  @RequestParam(name = "raza-id", required = false) long razaId,
	  @RequestParam(name = "edad", required = false) int edad,
	  @RequestParam(name = "genero", required = false) String genero) {
		
		ModelAndView mav = new ModelAndView("matchresults");
		
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
		
		// Aplicar filtros correspondientes y enviar el resultado a la vista
		List<Perfil> perfiles = perfilService.findByMultipleFields(caract, raza, edad, genList);
		mav.addObject("perfiles", perfiles);
		return mav;
		
	}
	
	@GetMapping("/viewall")
	public ModelAndView viewAll() {
		ModelAndView mav = new ModelAndView("matchresults");
		List<Perfil> perfiles = perfilService.findAll();
		mav.addObject("perfiles", perfiles);
		return mav;
	}
	
}
