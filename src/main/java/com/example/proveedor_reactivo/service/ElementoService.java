package com.example.proveedor_reactivo.service;


import com.example.proveedor_reactivo.model.Elemento;

import reactor.core.publisher.Flux;

public interface ElementoService {

	Flux<Elemento> elementoPrecioMax(double precioMax);
	
}
