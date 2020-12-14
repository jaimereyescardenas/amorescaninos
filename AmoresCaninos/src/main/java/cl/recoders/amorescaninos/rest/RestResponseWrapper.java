package cl.recoders.amorescaninos.rest;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestResponseWrapper<T> {
	
	public List<T> list;
	
}
