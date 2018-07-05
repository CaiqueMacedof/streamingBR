package br.com.filmesonline.teste;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;

import br.com.filmesonline.dao.FilmeDAO;
import br.com.filmesonline.model.Filme;

public class FilmeDAOTeste {
	
	private FilmeDAO dao = new FilmeDAO();
	
	@Test
	public void inserirFilme() throws ParseException {
		Filme filme = PopularEmMassa.popularFilme();
		dao.inserir(filme);
		
		Assert.assertTrue(filme.getId() != null);
	}
}
