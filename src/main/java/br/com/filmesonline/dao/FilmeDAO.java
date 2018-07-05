package br.com.filmesonline.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.filmesonline.model.Filme;

@Repository
@Transactional
public class FilmeDAO {

	@PersistenceContext
	private EntityManager manager;

	public void inserir(Filme filme) {
		manager.persist(filme);
	}

	public List<Filme> listarTodos() {
		return manager.createQuery("select f from Filme f", Filme.class).getResultList();
	}

	public List<Filme> listarFilmesLancamento() {
		TypedQuery<Filme> query = manager
				.createQuery("select f from Filme f where ano = :pAno", Filme.class);
		query.setParameter("pAno", Calendar.getInstance().get(Calendar.YEAR));

		return query.getResultList();
	}
}
