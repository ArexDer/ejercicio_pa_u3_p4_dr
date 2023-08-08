package com.example.demo.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="detalle_factura")
public class DetalleFactura {
	
	@Id
	@GeneratedValue(generator = "seq_detalle_factura", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_detalle_factura",sequenceName = "seq_detalle_factura", allocationSize = 1 )
	@Column(name = "detf_id")
	private Integer id;
	
	@Column(name = "detf_cantidad")
	private Integer cantidad;
	
	@Column(name = "detf_precio_unitario")
	private Double precioUnitario;
	
	@Column(name = "detf_subtotal")
	private BigDecimal subtotal;
	
	@ManyToOne
	@JoinColumn(name = "detf_id_factura")
	private Factura factura;
	
	@ManyToOne
	@JoinColumn(name = "detf_id_producto")
	private Producto producto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "DetalleFactura [id=" + id + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario
				+ ", subtotal=" + subtotal + "]";
	}
	
	

}
