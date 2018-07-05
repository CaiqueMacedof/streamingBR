package br.com.filmesonline.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.filmesonline.model.Classificacao;

@Repository
@Transactional
public class ClassificacaoDAO {

	@PersistenceContext
	private EntityManager manager;

	public void inserir(Classificacao classificacao) {
		manager.persist(classificacao);
	}

}
