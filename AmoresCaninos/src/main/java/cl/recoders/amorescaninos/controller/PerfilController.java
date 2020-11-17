package cl.recoders.amorescaninos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
		mav.addObject("razas", razas);
		mav.addObject("caracteristicas", caracteristicas);
		return mav;
	}
	
	@PostMapping("/match")
	public ModelAndView matchResults(
	  @RequestParam(name = "caracteristica-id") long caracteristicaId,
	  @RequestParam(name = "raza-id") long razaId,
	  @RequestParam(name = "edad") int edad,
	  @RequestParam(name = "genero") String genero) {
		
		ModelAndView mav = new ModelAndView("matchresults");
		List<Long> caractList = new ArrayList<>();
		caractList.add(caracteristicaId);
		List<Caracteristica> caract = caractService.findAllById(caractList);
		Raza raza = razaService.findById(razaId);
		List<Perfil> perfiles = perfilService.findByMultipleFields(caract, raza, edad, genero);
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
