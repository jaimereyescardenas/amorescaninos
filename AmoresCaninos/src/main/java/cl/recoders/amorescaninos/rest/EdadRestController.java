package cl.recoders.amorescaninos.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.recoders.amorescaninos.data.PerfilData;

@RestController
@RequestMapping("/rest/edad")
public class EdadRestController {
	
	@GetMapping(path = "/list")
	@CrossOrigin("*")
	public RestResponseWrapper<Integer> edadList() {
		RestResponseWrapper<Integer> r = new RestResponseWrapper<>(PerfilData.EDADES);
		return r;
	}
	
}