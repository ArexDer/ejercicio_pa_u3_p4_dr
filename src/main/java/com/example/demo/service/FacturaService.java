package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Factura;
import com.example.demo.repository.modelo.Producto;

public interface FacturaService {
	
	public List<Factura> obtenerFactura();
	
	public void obtenerReporteIndividual(List<Producto> productos);
	

}
