package br.com.estoque.entity;

public class Produto {
	
	private Integer id;
	private String nome;
	private Double preco;
	private String fornecedor;
	public Produto(Integer id, String nome, Double preco, String fornecedor) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.fornecedor = fornecedor;
	}
	public Produto() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	

}
