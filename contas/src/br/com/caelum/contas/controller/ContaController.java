package br.com.caelum.contas.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

@Controller
public class ContaController {

	@RequestMapping("/adicionaConta")
	public String adiciona(@Valid Conta conta, BindingResult result){
		
		if(result.hasFieldErrors("descricao")){
			return "conta/formulario";
		}
		
		ContaDAO dao = new ContaDAO();
		System.out.println("Adicionando conta " + conta.getDescricao());
		dao.adiciona(conta);
		
		return "conta/conta-adicionada";
	}
	
	
	@RequestMapping("/listaContas")
	public ModelAndView listar(){
		
		ContaDAO dao = new ContaDAO();
		
		List<Conta> contas = dao.lista();
		
		ModelAndView mv = new ModelAndView("conta/listar");
		
		mv.addObject("contas", contas);
		return mv;
		
	}
	
	@RequestMapping("/removeConta")
	public String remover(Conta conta){
		
		ContaDAO dao = new ContaDAO();
		
		dao.remove(conta);
		
		return "redirect:listaContas";
		
	}
	
	
	@RequestMapping("/pagarConta")
	public void paga(Long id, HttpServletResponse response){
		ContaDAO dao = new ContaDAO();
		dao.paga(id);
		
		response.setStatus(200);
	}
	
	@RequestMapping("/form")
	public String formulario(){
		
		return "conta/formulario";
	}
}
