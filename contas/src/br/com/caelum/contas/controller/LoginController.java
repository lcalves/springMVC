package br.com.caelum.contas.controller;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.contas.dao.UsuarioDAO;
import br.com.caelum.contas.modelo.Usuario;

@Controller
public class LoginController implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UsuarioDAO dao;
	
	 @Autowired
	public LoginController(UsuarioDAO dao) {
		
		 this.dao = dao;
	}
	
	@RequestMapping("/loginForm")
	public String loginForm(){
		return "usuario/login";
	}
					  
	@RequestMapping("/efetuaLogin")
	public String efetuarLogin(Usuario usuario, HttpSession session){
		
		if( dao.existeUsuario(usuario)){
			System.out.println("Logadooooooooo");
			session.setAttribute("usuarioLogado", usuario);
			System.out.println("Passou da validação");
			return "loginForm";
		}
		System.out.println("aqui");
		return "redirect:loginForm";
	}
	
}
