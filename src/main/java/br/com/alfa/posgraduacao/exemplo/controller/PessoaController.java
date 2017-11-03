package br.com.alfa.posgraduacao.exemplo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.alfa.posgraduacao.exemplo.modelo.Pessoa;
import br.com.alfa.posgraduacao.exemplo.service.PessoaService;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String index(Model model)
	{
		List<Pessoa> pessoas = pessoaService.ListarTodosPadrao();
		
		model.addAttribute("pessoas", pessoas);
		return "pessoa/pessoas";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String abrir(@PathVariable Long id,Model model)
	{
		//Pessoa pessoa = pessoaService.Abrir(id);
		
		List<Pessoa> pessoas = pessoaService.ListarTodosPadrao();
		
		Pessoa pessoa = pessoas.get(0);
		model.addAttribute("pessoa", pessoa);
		model.addAttribute("method", "PUT");
		return "pessoa/pessoa";
	}
	
	@RequestMapping(value="/novo",method=RequestMethod.GET)
	public String novo(Model model)
	{
		Pessoa pessoa = new Pessoa();
		model.addAttribute("pessoa", pessoa);
		return "pessoa/pessoa";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public String atualizar(@PathVariable Long id,Model model)
	{
		Pessoa pessoa = new Pessoa();
		model.addAttribute("pessoa", pessoa);
		
		return "redirect:/pessoa/"+id;
	}
	
	@RequestMapping(value="/novo",method=RequestMethod.POST)
	public String salvar(Model model)
	{
		Pessoa pessoa = new Pessoa();
		model.addAttribute("pessoa", pessoa);
		model.addAttribute("method", "POST");
		return "redirect:/pessoa";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String remover(@PathVariable Long id,Model model)
	{
		Pessoa pessoa = new Pessoa();
		model.addAttribute("pessoa", pessoa);
		return "redirect:/pessoa";
	}
}
