package br.com.alfa.posgraduacao.exemplo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

	@RequestMapping(value="",method=RequestMethod.GET)
	public String index(Model model)
	{
		return "pessoas/pessoas";
	}
}
