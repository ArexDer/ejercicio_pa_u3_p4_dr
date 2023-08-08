package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Producto;

public interface ProductoService {
	
	public void ingresar(Producto producto);
	
	public Producto buscarPorNombre(String nombre);
	
	public List<Producto> listarProductos();

}
