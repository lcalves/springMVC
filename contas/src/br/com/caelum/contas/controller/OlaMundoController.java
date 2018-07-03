package br.com.caelum.contas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoController {

	@RequestMapping("/olaMundoSpring")
	public String olaMundo(){
		
		System.out.println("Usando Spring MVC pela primeira vez!!!!");
		
		return "mundo";
		
		
	}
}
