package edu.curso.dao;

import java.sql.SQLException;
import java.util.List;

import edu.curso.entidade.Jogos;

public interface JogosDAO {

	
	public void adicionar(Jogos j);
	public void alterar (Jogos j) throws SQLException ;
	public List<Jogos> pesquisarPorNome(String nome);
	public void deletar (Jogos j) throws SQLException;
}
