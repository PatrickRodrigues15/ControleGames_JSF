package edu.curso.entidade;

import java.io.Serializable;

public class Jogos implements Serializable {

	private static final long serialVersionUID = 3407171701666462137L;
	
	private long id;
	private String nome;
	private String genero;
	private String desenvolvedora;
	private String publicadora;
	private int anoComprado;
	private int anoJogo;
	private double preco;
	private int quantidade;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getDesenvolvedora() {
		return desenvolvedora;
	}
	public void setDesenvolvedora(String desenvolvedora) {
		this.desenvolvedora = desenvolvedora;
	}
	public String getPublicadora() {
		return publicadora;
	}
	public void setPublicadora(String publicadora) {
		this.publicadora = publicadora;
	}
	public int getAnoComprado() {
		return anoComprado;
	}
	public void setAnoComprado(int anoComprado) {
		this.anoComprado = anoComprado;
	}
	public int getAnoJogo() {
		return anoJogo;
	}
	public void setAnoJogo(int anoJogo) {
		this.anoJogo = anoJogo;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
