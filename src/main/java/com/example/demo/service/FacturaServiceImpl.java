package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ProductoRepository;
import com.example.demo.repository.modelo.Factura;
import com.example.demo.repository.modelo.Producto;

@Service
public class FacturaServiceImpl implements FacturaService {
	
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public List<Factura> obtenerFactura() {
		
		return null;
	}

	@Override
	public void obtenerReporteIndividual(List<Producto> productos) {
		
		Factura factura = new Factura();
		factura.setFecha(LocalDate.now());
		factura.setCedulaCliente("13579");
		
		
		
		BigDecimal total ;
		
		
		for(int i =0;i<=productos.size();i++) {
			System.out.println(i+" "+ productos.toString());
		}
		
		//SUMA DE CADA PRODUCTO EN UN SOLO VALOR
		factura.setTotalFactura(null);
		
	}

}
