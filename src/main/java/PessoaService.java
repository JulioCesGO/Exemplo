import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alfa.posgraduacao.exemplo.modelo.Pessoa;
import br.com.alfa.posgraduacao.exemplo.repositorio.PessoaRepositorio;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepositorio pessoaRepositorio;
	
	public void Salvar(Pessoa pessoa)
	{
		pessoaRepositorio.save(pessoa);
	}
	
	public List<Pessoa> getAll()
	{
		return pessoaRepositorio.findAll();
	}
}
