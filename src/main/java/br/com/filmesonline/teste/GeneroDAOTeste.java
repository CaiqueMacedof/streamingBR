package br.com.filmesonline.teste;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.filmesonline.dao.GeneroDAO;
import br.com.filmesonline.model.Genero;

public class GeneroDAOTeste {
	
	@Autowired
	private GeneroDAO dao; 
	
	@Test
	public void inserirGenero() {
		Genero genero = new Genero();
		genero.setNome("Ficção Científica");
	
		dao.inserir(genero);
		Assert.assertTrue(genero.getId() != null);
	}
	
	@Test
	public void listarTodo() {
		List<Genero> lista = dao.listarTodos();
		
		Assert.assertNotNull(lista);
	}
}
