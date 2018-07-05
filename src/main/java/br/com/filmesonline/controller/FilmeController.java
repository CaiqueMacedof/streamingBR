package br.com.filmesonline.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.filmesonline.dao.FilmeDAO;
import br.com.filmesonline.dao.GeneroDAO;
import br.com.filmesonline.model.Classificacao;
import br.com.filmesonline.model.Filme;
import br.com.filmesonline.model.Genero;
import br.com.filmesonline.model.JsonResponse;
import br.com.filmesonline.model.TipoCaminho;
import br.com.filmesonline.model.Usuario;

@Controller
@RequestMapping("/filme")
public class FilmeController {

	@Autowired
	private FilmeDAO filmeDAO;

	@Autowired
	private GeneroDAO generoDAO;

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView form() {
		ModelAndView modelAndView = new ModelAndView("filme/form");
		modelAndView.addObject("generos", generoDAO.listarTodos());

		return modelAndView;
	}

	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public ModelAndView inserir(HttpServletRequest request) throws IOException {
		JsonResponse resposta = null;

		ModelAndView modelAndView = new ModelAndView("filme/form");
		modelAndView.addObject("generos", generoDAO.listarTodos());

		/* Identifica se o formulario é do tipo multipart/form-data */
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				/* Faz o parse do request */
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

				String nome_arquivo = "";
				/* Escreve a o arquivo na pasta img */
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						nome_arquivo = escreverArquivo(item);
					}
				}
				Filme filme = populandoFilme(multiparts, (Usuario) request.getSession().getAttribute("usuarioLogado"),
						TipoCaminho.IMG.getNome() + nome_arquivo);
				filmeDAO.inserir(filme);

				resposta = new JsonResponse(true, null, "Filme inserido com sucesso", "alert-success");
			} catch (Exception ex) {
				resposta = new JsonResponse(false, null, "Erro ao inserir o filme", "alert-danger");
			} finally {
				modelAndView.addObject("resposta", resposta);
				modelAndView.addObject("generos", generoDAO.listarTodos());
			}
		}

		return modelAndView;
	}

	private String escreverArquivo(FileItem item) throws Exception {
		String nome_arquivo = item.getName();
		item.write(new File(TipoCaminho.WORKSPACE.getNome() + nome_arquivo));
		return nome_arquivo;
	}

	// TODO: Verificar depois uma forma correta de se fazer isso.
	private Filme populandoFilme(List<FileItem> multiparts, Usuario u, String caminho) throws ParseException {
		Classificacao classi = new Classificacao();
		classi.setPontuacao(Integer.parseInt(multiparts.get(3).getString()));

		List<Classificacao> lista = new ArrayList<Classificacao>();
		lista.add(classi);

		Genero genero = new Genero();
		genero.setId(Integer.parseInt(multiparts.get(4).getString()));

		Usuario usuario = new Usuario();
		usuario.setId(u.getId());

		return new Filme(multiparts.get(0).getString(), multiparts.get(1).getString(),
				Integer.parseInt(multiparts.get(2).getString()), lista, genero, usuario, caminho);
	}

	@RequestMapping(value = "/filmes", method = RequestMethod.GET)
	public ModelAndView listarTodos() {
		List<Filme> filmes = filmeDAO.listarTodos();

		ModelAndView modelAndView = new ModelAndView("filme/filmes");
		modelAndView.addObject("filmes", filmes);

		return modelAndView;
	}

	@RequestMapping(value = "/genero/{id}", method = RequestMethod.GET)
	public ModelAndView listaFilmeGenero(Genero genero) {
		ModelAndView modelAndView = new ModelAndView("filme/filmes_genero_lancamento");
		try {
			modelAndView.addObject("filmes", generoDAO.listarFilmesPorGenero(genero));
			return modelAndView;
		} catch (Exception e) {
			return modelAndView;
		}
	}

	@RequestMapping(value = "/lancamento", method = RequestMethod.GET)
	public ModelAndView listaFilmeLancamento(Genero genero) {
		ModelAndView modelAndView = new ModelAndView("filme/filmes_genero_lancamento");
		try {
			Genero filmes = new Genero();
			List<Filme> lista = filmeDAO.listarFilmesLancamento();
			filmes.setFilme(lista);
			modelAndView.addObject("filmes", filmes);
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return modelAndView;
		}
	}
}
