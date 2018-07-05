package br.com.filmesonline.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AutorizadorInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse resp, Object handler, Exception exp)
			throws Exception {
		HttpSession session = req.getSession();
		String uri = req.getRequestURI();
		
		if (uri.endsWith("filme/form") && session.getAttribute("usuarioLogado") == null) {
			session.invalidate();
			resp.sendRedirect("/filmesonline/");
			System.out.println("quebrando a sessão");
		}
			
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object handler, ModelAndView modelAndView)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {

		String uri = req.getRequestURI();
		if (uri.endsWith("filme/form") && req.getSession().getAttribute("usuarioLogado") == null) {
			resp.sendRedirect("/filmesonline/");
			return false;
		}
		
		return true;
	}

}
