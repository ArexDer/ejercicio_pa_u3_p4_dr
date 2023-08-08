package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class ProductoRepositoryImpl implements ProductoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void ingresar(Producto producto) {
		this.entityManager.persist(producto);

	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	// public int actualizar(Integer stock, String codigo)
	public int actualizar(String codBarras, Integer cantStock) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager
				.createQuery("UPDATE Producto p SET p.stock = :datoStock WHERE p.codigoDeBarra = :datoCodigoBarra");
		myQuery.setParameter("datoStock", cantStock);
		myQuery.setParameter("datoCodigoBarra", codBarras);
		return myQuery.executeUpdate();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto buscarProducto(String codBarra) {
		// SENTENCIA JPQL
		TypedQuery<Producto> query = this.entityManager
				.createQuery("SELECT p FROM Producto p WHERE p.codigoDeBarra =:datoCodigoB", Producto.class);
		query.setParameter("datoCodigoB", codBarra);
		return query.getSingleResult();
	}

	@Override
	public List<Producto> listarProductos() {

		// CODIGO DE BARRAS Y CANTIDAD
		TypedQuery<Producto> query = this.entityManager
				.createQuery("SELECT p FROM Producto p ", Producto.class);
		//query.setParameter("datoCodigoB", codBarra);
		return query.getResultList();
	}

}
