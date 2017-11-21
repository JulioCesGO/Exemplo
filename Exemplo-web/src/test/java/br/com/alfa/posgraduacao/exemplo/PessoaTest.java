package br.com.alfa.posgraduacao.exemplo;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alfa.posgraduacao.exemplo.modelo.Pessoa;
import br.com.alfa.posgraduacao.exemplo.service.PessoaService;
import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestEntityManager
public class PessoaTest {

	@Resource
	PessoaService pessoaService;

	Pessoa criarPessoa() {
		Pessoa pessoa = new Pessoa();

		pessoa.setNome("Julio");
		pessoa.setIdade(20);

		return pessoa;
	}

	@Test
	public void Salvar_Valido() {
		Pessoa pessoa = criarPessoa();
		pessoaService.Salvar(pessoa);

		assertNotNull(pessoa.getCodigo());
	}

	@Test(expected=org.springframework.transaction.TransactionSystemException.class)
	public void Salvar_Invalido() throws Exception {

		Pessoa pessoa = new Pessoa();
		pessoa = pessoaService.Salvar(pessoa);
		
		assertNull(pessoa.getCodigo());
		
	}

	@Test
	public void Abrir_Valido() {

		Long codigo = null;
		Pessoa pessoa = criarPessoa();
		pessoa = pessoaService.Salvar(pessoa);
		codigo = pessoa.getCodigo();
		
		
		Pessoa novaPessoa = pessoaService.Abrir(codigo);
		assertEquals(pessoa, novaPessoa);
	}

	@Test
	public void Abrir_Invalido() {
		Long codigo = Long.MAX_VALUE;
		Pessoa pessoa = criarPessoa();
		pessoa = pessoaService.Salvar(pessoa);
			
		
		Pessoa novaPessoa = pessoaService.Abrir(codigo);
		assertNull(novaPessoa);
	}

	@Test
	public void Atualizar_Valido() {
		Pessoa pessoa = criarPessoa();
		pessoa = pessoaService.Salvar(pessoa);
		Long codigo = pessoa.getCodigo();
		
		Pessoa pessoa2 = pessoaService.Abrir(codigo);
		pessoa2.setNome("novonome");
		pessoaService.Salvar(pessoa2);
		
		assertArrayEquals(new Object[]{ pessoa.getCodigo(),"novonome"}, new Object[]{ pessoa2.getCodigo(), pessoa2.getNome()});
	}

	@Test(expected=org.springframework.transaction.TransactionSystemException.class)
	public void Atualizar_Invalido() throws Exception {
		Pessoa pessoa = criarPessoa();
		pessoa = pessoaService.Salvar(pessoa);
		Long codigo = pessoa.getCodigo();
		
		Pessoa pessoa2 = pessoaService.Abrir(codigo);
		pessoa2.setNome(null);
		pessoa2 = pessoaService.Salvar(pessoa2);
		
		
	}

	@Test
	public void ListarTodos() {
		List<Pessoa> pessoas = pessoaService.ListarTodos();
		assertTrue(!pessoas.isEmpty());
	}

}
