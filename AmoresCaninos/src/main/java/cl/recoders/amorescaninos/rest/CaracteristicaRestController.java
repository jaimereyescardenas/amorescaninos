package cl.recoders.amorescaninos.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.recoders.amorescaninos.entity.Caracteristica;
import cl.recoders.amorescaninos.service.CaracteristicaService;

@RestController
@RequestMapping("/rest/carac")
public class CaracteristicaRestController {

	@Autowired
	CaracteristicaService caractService;
	
	@GetMapping(path = "/list")
	@CrossOrigin("*")
	public RestResponseWrapper<Caracteristica> caractList() {
		RestResponseWrapper<Caracteristica> r = new RestResponseWrapper<>(caractService.findAll());
		return r;
	}
	
}
