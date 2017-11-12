package br.com.alfa.posgraduacao.exemplo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alfa.posgraduacao.exemplo.modelo.Pessoa;
import br.com.alfa.posgraduacao.exemplo.service.PessoaService;
import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PessoaTest {

	@Autowired
	PessoaService pessoaService;
	
	
	@Test
	public void Salvar() {
		Pessoa pessoa = new Pessoa();
		
		pessoa.setNome("Julio");
		pessoa.setIdade(20);
		
		pessoaService.Salvar(pessoa);
		
		
	}
	
	
	@Test
	public void Verificar()
	{
		List<Pessoa> pessoas = pessoaService.ListarTodos();
		org.junit.Assert.assertTrue(!pessoas.isEmpty());
	}

	
	
}
