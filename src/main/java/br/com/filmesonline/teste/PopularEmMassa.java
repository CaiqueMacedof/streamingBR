package br.com.filmesonline.teste;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.com.filmesonline.model.Classificacao;
import br.com.filmesonline.model.Filme;
import br.com.filmesonline.model.Genero;
import br.com.filmesonline.model.TipoClassificacao;

public class PopularEmMassa {

	static public Filme popularFilme() throws ParseException {
		Filme filme = new Filme();

		filme.setNome("Vingadores 3 - guerra infinita");
		filme.setDescricao("último filme da estréia.");
		filme.setAno(2018);

		Classificacao classificacao = new Classificacao();

		classificacao.setPontuacao(10);
		classificacao.setTipoClassificacao(TipoClassificacao.FILME);
		
		List<Classificacao> listClassificacao = new ArrayList<Classificacao>();
		listClassificacao.add(classificacao);

		filme.setClassificacao(listClassificacao);
		
		Genero genero = new Genero();
		genero.setId(1);

		filme.setGenero(genero);

		return filme;
	}
}
