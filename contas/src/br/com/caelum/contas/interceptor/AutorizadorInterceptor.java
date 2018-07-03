package br.com.caelum.contas.interceptor;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller)
 {
		
		String uri = request.getRequestURI();
		if(uri.endsWith("loginForm") || uri.endsWith("efetuaLogin") || uri.contains("resources")) {
			return true;
		}
		
		if(request.getSession().getAttribute("usuarioLogado")!=null) {
			return true;
		} else {
			try {
				response.sendRedirect("loginForm");
			} catch (IOException e) {
				System.out.println("Deu Ruim Aqui " + e.getMessage());
				e.printStackTrace();
			}
			return false;
		}
		
	}
}
