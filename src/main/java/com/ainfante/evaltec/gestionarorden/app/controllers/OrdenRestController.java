package com.ainfante.evaltec.gestionarorden.app.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ainfante.evaltec.gestionarorden.app.models.Orden;
import com.ainfante.evaltec.gestionarorden.app.services.OrdenService;

@RestController
@RequestMapping("/api/orden")
public class OrdenRestController {

	@Autowired
	OrdenService ordenService;
		
	@PostMapping
	public ResponseEntity<Orden> guardarOrden(@RequestBody Orden orden) {
		try {
			Orden newOrden = ordenService.save(orden);
			return new ResponseEntity<>(newOrden, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value = "/{id}")
	public Orden actualizarOrden(@PathVariable("id") String id, @RequestBody Orden ordenBody) {
		Optional<Orden> optOrden = ordenService.findById(id);
		if (optOrden.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("No se encuentra orden con id %s para actualizar", id));
		}

		Orden orden = optOrden.get();
		orden.setEstado(ordenBody.getEstado());
		orden.setFechaPedido(ordenBody.getFechaPedido());
		orden.setFormaPago(ordenBody.getFormaPago());
		orden.setMonto(ordenBody.getMonto());
		return ordenService.save(orden);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<HttpStatus> eliminarOrden(@PathVariable("id") String id) {
		try {
			//ordenService.deleteById(id);
			Optional<Orden> optOrden = ordenService.findById(id);
			if (optOrden.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("No se encuentra orden con id %s para dar e baja", id));
			}

			Orden orden = optOrden.get();
			orden.setEstado("Anulado");
			ordenService.save(orden);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
