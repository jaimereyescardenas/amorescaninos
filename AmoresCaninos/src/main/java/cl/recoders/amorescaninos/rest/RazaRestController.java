package cl.recoders.amorescaninos.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.recoders.amorescaninos.entity.Raza;
import cl.recoders.amorescaninos.service.RazaService;

@RestController
@RequestMapping("/rest/raza")
public class RazaRestController {

	@Autowired
	RazaService razaService;
	
	@GetMapping(path = "/list")
	@CrossOrigin("*")
	public RestResponseWrapper<Raza> razaList() {
		RestResponseWrapper<Raza> r = new RestResponseWrapper<>(razaService.findAll());
		return r;
	}
	
}
