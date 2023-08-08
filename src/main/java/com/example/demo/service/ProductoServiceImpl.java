package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ProductoRepository;
import com.example.demo.repository.modelo.Producto;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void ingresar(Producto producto) {
		
		Integer cantStock = producto.getStock();
		
		if (this.productoRepository.actualizar((producto.getCodigoDeBarra()),cantStock)==0) {
			this.productoRepository.ingresar(producto);
		} else {
			Producto productoEncontrado = this.productoRepository.buscarProducto(producto.getCodigoDeBarra());
			 productoEncontrado.getStock();
			 
			Integer stockActualizado =  producto.getStock()+productoEncontrado.getStock();
			
			this.productoRepository.actualizar( productoEncontrado.getCodigoDeBarra(),stockActualizado);
		}
	}
		

	@Override
	public Producto buscarPorNombre(String nombre) {
		
		return null;
	}


	@Override
	public List<Producto> listarProductos() {
		// TODO Auto-generated method stub
		return this.productoRepository.listarProductos();
	}

}
