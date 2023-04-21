package com.ainfante.evaltec.gestionarorden.app.services;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import com.ainfante.evaltec.gestionarorden.app.models.Orden;
import com.ainfante.evaltec.gestionarorden.app.repositories.OrdenRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@SpringBootTest
class OrdenServiceImplTest {
	
	@Mock
	OrdenRepository ordenRepository;

	@InjectMocks
	OrdenServiceImpl ordenService;
	
	@BeforeEach
	void setUp()  {
	}

	@Test
	void testFindById() {	
		when(ordenRepository.findById(anyString())).thenReturn(Optional.of(new Orden()));
		ordenService.findById(anyString());
	}

	@Test
	void testSave() {
		Orden orden = new Orden();
		orden.setCliente("Antony Infante");
		orden.setEstado("Pagado");
		orden.setFechaPedido(new Date());
		orden.setFormaPago("Contado");
		orden.setItemsOrden(new ArrayList<>());
		
		when(ordenRepository.save(orden)).thenReturn(orden);
		ordenService.save(orden);
		verify(ordenRepository, never()).deleteById(anyString());
	}

	@Test
	void deleteById() {
		//doNothing().when(ordenRepository).deleteById(anyString());
		ordenService.deleteById(anyString());
	}
}
