package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Producto;

public interface ProductoRepository {
	
	public void ingresar(Producto producto);
	
	public int actualizar(String codBarras, Integer cantStock);
	
	public Producto buscarProducto(String codBarra);
	
	public List<Producto> listarProductos();

}
