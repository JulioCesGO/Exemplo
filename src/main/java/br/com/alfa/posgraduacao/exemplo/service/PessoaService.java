package br.com.alfa.posgraduacao.exemplo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alfa.posgraduacao.exemplo.modelo.Pessoa;
import br.com.alfa.posgraduacao.exemplo.repositorio.PessoaRepositorio;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepositorio pessoaRepositorio;
	
	@Transactional
	public void Salvar(Pessoa pessoa)
	{
		pessoaRepositorio.save(pessoa);
	}
	
	public List<Pessoa> ListarTodos()
	{
		return pessoaRepositorio.findAll();
	}
	
	
	public List<Pessoa> ListarTodosPadrao()
	{
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add( new Pessoa(new Long(1),"julio",20,null));
		pessoas.add( new Pessoa(new Long(1),"julio",20,null));
		pessoas.add( new Pessoa(new Long(1),"julio",20,null));
		pessoas.add( new Pessoa(new Long(1),"julio",20,null));
		pessoas.add( new Pessoa(new Long(1),"julio",20,null));
		
		return pessoas;
		
	}
	
	public Pessoa Abrir(Long id)
	{
		return pessoaRepositorio.findOne(id);
	}
}
