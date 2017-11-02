package br.com.alfa.posgraduacao.exemplo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.br.CNPJ;

@Entity
public class Pessoa  {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codigo;
	private String nome;
	private Integer idade;
	@CNPJ
	private String cnpj;
	
	
	
	
	public Pessoa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pessoa(Long codigo, String nome, Integer idade, String cnpj) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.idade = idade;
		this.cnpj = cnpj;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
}
