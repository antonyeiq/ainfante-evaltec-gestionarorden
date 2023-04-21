package com.ainfante.evaltec.gestionarorden.app.services;

import java.util.Optional;

import com.ainfante.evaltec.gestionarorden.app.models.Orden;

public interface OrdenService {

	public Optional<Orden> findById(String id);
	public Orden save(Orden orden);
	public void deleteById(String id);
}
