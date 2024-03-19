package com.example.proveedor_reactivo.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.proveedor_reactivo.model.Elemento;

import reactor.core.publisher.Flux;


@Service
public class ElementoServiceImpl implements ElementoService {
	
	String url1= "http://localhost:8041";
	String url2= "http://localhost:8042";

	@Override
	public Flux<Elemento> elementoPrecioMax(double precioMax) {
		Flux<Elemento> flux1 = catalogo(url1, "tienda 1");
		Flux<Elemento> flux2 = catalogo(url1, "tienda 2");
		return Flux.merge(flux1,flux2)//Flux<Elemento>
				.filter(e->e.getPrecioUnitario() <= precioMax);
		
	}
	
	private Flux<Elemento> catalogo(String url, String tienda){
		WebClient webClient = WebClient.create(url);
		webClient
		.get()
		.uri("/productos")
		.accept(MediaType.APPLICATION_JSON)
		.retrieve()
		.bodyToFlux(Elemento.class)
		.map(e->{
			e.setTienda(tienda);
			return e;
		});
	}
	
}
