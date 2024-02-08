package edu.curso.dao;

import java.sql.SQLException;
import java.util.List;

import edu.curso.entidade.Jogos;
import edu.curso.entidade.Login;

public interface LoginDAO {

	public void gravar(Login l) throws SQLException;
	public boolean logar (String nome, String senha) throws SQLException;	
	public void atualizar (Login l) throws SQLException;
	public List<Login> pesquisar(String nome);	
	public List<Login> pesquisarTodos() throws SQLException; 			
	public void remover (Login l) throws SQLException;
}
