package com.ainfante.evaltec.gestionarorden.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ainfante.evaltec.gestionarorden.app.models.Orden;
import com.ainfante.evaltec.gestionarorden.app.repositories.OrdenRepository;

@Service
public class OrdenServiceImpl implements OrdenService {
	
	@Autowired
	OrdenRepository ordenRepository;

	@Override
	public Optional<Orden> findById(String id) {
		return ordenRepository.findById(id);
	}

	@Override
	public Orden save(Orden orden) {
		return ordenRepository.save(orden);
	}

	@Override
	public void deleteById(String id) {
		ordenRepository.deleteById(id);
	}

}
