package br.com.alfa.posgraduacao.exemplo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

	@RequestMapping(value="/")
	public String index(Model model)
	{
		return "index";
	}
	
	@RequestMapping(value="/home")
	public String home(Model model)
	{
		return "index";
	}
}
