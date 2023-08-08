package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Producto;
import com.example.demo.service.FacturaService;
import com.example.demo.service.ProductoService;

@SpringBootApplication
public class EjercicioPaU3P4DrApplication implements CommandLineRunner {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private FacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(EjercicioPaU3P4DrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		//1.-INGRESAR PRODUCTOS
		Producto producto = new Producto();
		Producto producto2 = new Producto();
		producto.setNombre("Mandarina");
		producto.setCategoria("Frutos");
		producto.setCodigoDeBarra("333");
		producto.setPrecio(new BigDecimal(0.15));
		producto.setStock(15);

		this.productoService.ingresar(producto);
		
		producto2.setNombre("Wisky");
		producto2.setCategoria("Licores");
		producto2.setCodigoDeBarra("k80");
		producto2.setPrecio(new BigDecimal(8.45));
		producto2.setStock(21);

		this.productoService.ingresar(producto2);
		
		
		//EN CASO DE EXISTIR ACTUALIZA
		producto2.setNombre("Doritos");
		producto2.setCategoria("Snacks");
		producto2.setCodigoDeBarra("101P");
		producto2.setPrecio(new BigDecimal(0.45));
		producto2.setStock(45);

		this.productoService.ingresar(producto2);
		
		
		List<Producto> listP = new ArrayList<>();
		listP.add(producto);
		listP.add(producto2);
		
		
		//2.-REALIZAR UNA FACTURA
		System.out.println("LISTAR PRODUCTOS EN LA BASE DE DATOS");
		this.productoService.listarProductos().forEach(System.out::println);
		
		
		this.facturaService.obtenerReporteIndividual(listP);
		

	}

}
