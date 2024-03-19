package com.example.proveedor_reactivo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.proveedor_reactivo.model.Elemento;
import com.example.proveedor_reactivo.service.ElementoService;

import reactor.core.publisher.Flux;

@RestController
public class ElementoController {

	@Autowired
	ElementoService elementoService;
	
	@GetMapping(value="elementos/precio")
	public ResponseEntity<Flux<Elemento>> elementoPrecio(@PathVariable("precio") double precioMax){
		return new ResponseEntity<>(elementoService.elementoPrecioMax(precioMax),HttpStatus.OK);
	}
	
}
