package br.com.alfa.posgraduacao.exemplo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.alfa.posgraduacao.exemplo.modelo.*;

@Repository
public interface PessoaRepositorio extends JpaRepository<Pessoa,Long>{

}
