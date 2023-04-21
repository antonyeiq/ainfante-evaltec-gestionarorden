package com.ainfante.evaltec.gestionarorden.app.services;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ainfante.evaltec.gestionarorden.app.models.ItemOrden;
import com.ainfante.evaltec.gestionarorden.app.models.Orden;
import com.ainfante.evaltec.gestionarorden.app.repositories.OrdenRepository;


@SpringBootTest
class OrdenServiceImplTest {
	
	@MockBean
	OrdenRepository ordenRepository;

	@Autowired
	OrdenService ordenService;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testFindById() {	
		when(ordenService.findById(anyString())).thenReturn(Optional.of(new Orden()));
	}

	@Test
	void testSave() {
		Orden orden = new Orden();
		orden.setCliente("Antony Infante");
		orden.setEstado("Pagado");
		orden.setFechaPedido(new Date());
		orden.setFormaPago("Contado");
		orden.setItemsOrden(new ArrayList<ItemOrden>());
		
		when(ordenService.save(orden)).thenReturn(orden);
		verify(ordenRepository, never()).deleteById(anyString());
	}	

}
