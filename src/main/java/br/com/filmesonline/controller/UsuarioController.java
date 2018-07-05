package br.com.filmesonline.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.filmesonline.dao.UsuarioDAO;
import br.com.filmesonline.model.RespostaParaView;
import br.com.filmesonline.model.Usuario;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@RequestMapping(value="/usuario/administrador", method=RequestMethod.GET)
	public String telaUsuario() {
		return "usuario/login";
	}
	
	@RequestMapping(value="/usuario/entrar", method=RequestMethod.POST)
	public ModelAndView entrar(HttpSession session, Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView();
		
		try {
			Usuario existeUsuario = usuarioDAO.existeUsuario(usuario);
			
			modelAndView.setViewName("redirect:/");
			session.setAttribute("usuarioLogado", existeUsuario);
			
			return modelAndView;
		} catch (Exception e) {
			modelAndView.setViewName("usuario/login");
			modelAndView.addObject("mensagemLogin", new RespostaParaView(false, null, "Usuario não cadastrado"));

			return modelAndView;
		}
		
	}
	
	@RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
