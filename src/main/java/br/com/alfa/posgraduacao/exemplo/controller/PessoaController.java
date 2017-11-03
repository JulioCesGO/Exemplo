package br.com.alfa.posgraduacao.exemplo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		List<Pessoa> pessoas = pessoaService.ListarTodos();
		
		model.addAttribute("pessoas", pessoas);
		return "pessoa/pessoas";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String abrir(@PathVariable Long id,Model model)
	{
		Pessoa pessoa = pessoaService.Abrir(id);
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
	public String atualizar(@PathVariable Long id, @ModelAttribute Pessoa pessoa, Model model, BindingResult result)
	{
		if (result.hasErrors())
		{
			model.addAttribute("pessoa", pessoa);
			model.addAttribute("method", "PUT");
		}
		pessoaService.Salvar(pessoa);		
		return "redirect:/pessoa/"+id;
	}
	
	@RequestMapping(value="/novo",method=RequestMethod.POST)
	public String salvar(@ModelAttribute Pessoa pessoa, Model model, BindingResult result)
	{
		if (result.hasErrors())
		{
			model.addAttribute("pessoa", pessoa);
			model.addAttribute("method", "POST");
		}
		pessoaService.Salvar(pessoa);		
		return "redirect:/pessoa";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String remover(@PathVariable Long id,Model model)
	{
		Pessoa pessoa = new Pessoa();
		pessoa.setCodigo(id);
		pessoaService.Remover(pessoa);
		return "redirect:/pessoa";
	}
}
