package br.com.filmesonline.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.filmesonline.model.Usuario;

@Repository
@Transactional
public class UsuarioDAO {

	@PersistenceContext
	private EntityManager manager;

	public void inserir(Usuario usuario) {
		manager.persist(usuario);
	}

	public Usuario buscarUsuario(Usuario usuario) {
		return manager.find(Usuario.class, usuario.getId());
	}

	public Usuario existeUsuario(Usuario usuario) {
		TypedQuery<Usuario> query = manager
				.createQuery("select u from Usuario u where usuario = :pUsuario and senha = :pSenha", Usuario.class);
		query.setParameter("pUsuario", usuario.getUsuario());
		query.setParameter("pSenha", usuario.getSenha());

		return query.getSingleResult();
	}
}
