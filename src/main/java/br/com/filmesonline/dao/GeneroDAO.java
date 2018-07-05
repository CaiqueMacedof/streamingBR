package br.com.filmesonline.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.filmesonline.model.Genero;

@Repository
@Transactional
public class GeneroDAO {

	@PersistenceContext
	private EntityManager manager;

	public void inserir(Genero genero) {
		manager.persist(genero);
	}

	public List<Genero> listarTodos() {
		return manager.createQuery("select g from Genero g", Genero.class).getResultList();
	}

	public Genero listarFilmesPorGenero(Genero genero) {
		TypedQuery<Genero> query = manager.createQuery(
				"select distinct g from Genero g left join fetch g.filme where g = :pGenero", Genero.class);
		query.setParameter("pGenero", genero);

		return query.getSingleResult();
	}

}
