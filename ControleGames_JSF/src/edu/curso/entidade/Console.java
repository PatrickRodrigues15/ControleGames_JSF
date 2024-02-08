package edu.curso.entidade;

import java.io.Serializable;
import java.util.Date;

public class Console implements Serializable {
	private static final long serialVersionUID = 1323434843482229584L;
	
	private long id;
	private String nome;
	private double preco;
	private Date dtLancamento;
	private String produtora;
	private String versao;
	
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
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Date getDtLancamento() {
		return dtLancamento;
	}
	public void setDtLancamento(Date dtLancamento) {
		this.dtLancamento = dtLancamento;
	}
	public String getProdutora() {
		return produtora;
	}
	public void setProdutora(String produtora) {
		this.produtora = produtora;
	}
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}