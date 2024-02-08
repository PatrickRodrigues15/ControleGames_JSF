package edu.curso.mb;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.curso.dao.ConsoleDAO;
import edu.curso.dao.ConsoleDAOImpl;
import edu.curso.dao.JogosDAO;
import edu.curso.dao.JogosDAOImpl;
import edu.curso.entidade.Console;
import edu.curso.entidade.Jogos;

@ManagedBean
@SessionScoped
public class JogosMB {

	private Jogos jogosAtual;
	private String mensagem;
	private JogosDAO jDao;
	private List<Jogos> jogos;
	private List<Jogos> lista = new ArrayList<Jogos>();

	public JogosMB() {
		jogosAtual = new Jogos();
		jDao = new JogosDAOImpl();

	}

	public String adicionar() {
		jDao.adicionar(jogosAtual);
		setmensagem("Gravado com sucesso");
		jogosAtual = new Jogos();
		return "";
	}

	public String pesquisar() {
		lista = jDao.pesquisarPorNome(jogosAtual.getNome());
		if (lista != null && lista.size() > 0) {
			jogosAtual = lista.get(0);
		}
		return "";
	}

	public void alterar() {
		try {
			jDao.alterar(jogosAtual);
			setmensagem("Alterado com sucesso");
			jogosAtual = new Jogos();
			// pesquisar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String deletar() {

		try {
			jDao.deletar(jogosAtual);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jogosAtual = new Jogos();
		setmensagem("Removido Com Sucesso!");
		return "";

	}

	public Jogos getjogos() {
		return jogosAtual;
	}

	public void setjogos(Jogos jogos) {
		this.jogosAtual = jogos;
	}

	public List<Jogos> getLista() {
		return lista;
	}

	public void setLista(List<Jogos> lista) {
		this.lista = lista;
	}

	public Jogos getJogosAtual() {
		return jogosAtual;
	}

	public void setJogosAtual(Jogos jogosAtual) {
		this.jogosAtual = jogosAtual;
	}

	public String getmensagem() {
		return mensagem;
	}

	public void setmensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public JogosDAO getjDao() {
		return jDao;
	}

	public void setjDao(JogosDAO jDao) {
		this.jDao = jDao;
	}

	public List<Jogos> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogos> jogos) {
		this.jogos = jogos;
	}
}