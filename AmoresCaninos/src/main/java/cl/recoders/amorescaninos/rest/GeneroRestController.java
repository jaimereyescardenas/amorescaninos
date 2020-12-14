package cl.recoders.amorescaninos.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.recoders.amorescaninos.data.PerfilData;

@RestController
@RequestMapping("/rest/genero")
public class GeneroRestController {
	
	@GetMapping(path = "/list")
	@CrossOrigin("*")
	public RestResponseWrapper<String> generoList() {
		RestResponseWrapper<String> r = new RestResponseWrapper<>(PerfilData.GENEROS);
		return r;
	}
	
}
