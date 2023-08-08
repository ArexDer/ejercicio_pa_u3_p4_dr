package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {
	
	@Id
	@GeneratedValue(generator = "seq_producto", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_producto",sequenceName = "seq_producto", allocationSize = 1 )
	@Column(name = "prod_id")
	private Integer id;
	
	@Column(name = "prod_codigo_de_barra")
	private String codigoDeBarra;
	
	@Column(name = "prod_nombre")
	private String nombre;
	
	@Column(name = "prod_categoria")
	private String categoria;
	
	@Column(name = "prod_precio")
	private BigDecimal precio;
	
	@Column(name = "prod_stock")
	private Integer stock;
	
	@OneToMany(mappedBy = "producto", fetch = FetchType.EAGER)
	private List<DetalleFactura> listafactura ;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoDeBarra() {
		return codigoDeBarra;
	}

	public void setCodigoDeBarra(String codigoDeBarra) {
		this.codigoDeBarra = codigoDeBarra;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public List<DetalleFactura> getListafactura() {
		return listafactura;
	}

	public void setListafactura(List<DetalleFactura> listafactura) {
		this.listafactura = listafactura;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", codigoDeBarra=" + codigoDeBarra + ", nombre=" + nombre + ", categoria="
				+ categoria + ", stock=" + stock + "]";
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	
	
	
	
	
	
	
	

}
