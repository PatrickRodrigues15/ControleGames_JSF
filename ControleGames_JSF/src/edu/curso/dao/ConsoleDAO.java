package edu.curso.dao;


import java.sql.SQLException;
import java.util.List;

import edu.curso.entidade.Console;
import edu.curso.entidade.Login;

public interface ConsoleDAO {

	public void adicionar(Console c);
//	public void adicionarConsole(long idConsole, long idUsuario);
	public void alterar (Console c) throws SQLException ;
	public List<Console> pesquisarPorNome(String nome);
	public void deletar (Console c) throws SQLException;
}
