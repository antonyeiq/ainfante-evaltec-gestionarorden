package com.ainfante.evaltec.gestionarorden.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ainfante.evaltec.gestionarorden.app.models.Orden;

public interface OrdenRepository extends MongoRepository<Orden, String>{

}
