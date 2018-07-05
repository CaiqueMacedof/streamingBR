package br.com.filmesonline.teste;

import br.com.filmesonline.dao.UsuarioDAO;
import br.com.filmesonline.model.Usuario;

public class UsuarioDAOTest {
	public static void main(String[] args) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario u = new Usuario("Caique Fialho Macedo", "admin", "123");
		
		usuarioDAO.inserir(u);
	
	}
}
