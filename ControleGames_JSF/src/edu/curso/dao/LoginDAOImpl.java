package edu.curso.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.curso.entidade.Login;;

public class LoginDAOImpl implements LoginDAO {

	private Connection con;

	public LoginDAOImpl() { 
		con = DBUtil.getInstance().getConn();
	}
	
	
	@Override
	public void gravar(Login l) throws SQLException {
		String sql = "INSERT INTO login (nome, senha) VALUES (?, ?) ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, l.getNome());
		ps.setString(2, l.getSenha());
		ps.execute();
		ps.close();
				
		
	}

	@Override
	public boolean logar(String nome, String senha) throws SQLException {
		String sql = "SELECT nome FROM login WHERE nome like ? AND senha LIKE ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1	,nome);
		ps.setString(2, senha);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	

	@Override
	public List<Login> pesquisar(String nome) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void atualizar(Login l) throws SQLException {
		
			String sql = "UPDATE login SET nome = ?, senha = ? WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, l.getNome());
			ps.setString(2, l.getSenha());
			ps.setInt(3, l.getId());
			ps.execute();
			ps.close();
		}


	@Override
	public List<Login> pesquisarTodos() throws SQLException {
			List<Login> lista = new ArrayList();
			String sql = "SELECT * From login";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Login l = new Login();
				l.setId(rs.getInt("id"));
				l.setNome(rs.getString("nome"));
				l.setSenha(rs.getString("senha"));
				lista.add(l);
			}
			rs.close();
			ps.close();
			
			return lista;
	}


	@Override
	public void remover(Login l) throws SQLException {
		String sql = "DELETE FROM login WHERE nome = ?";
		PreparedStatement psmt = con.prepareStatement(sql);
		psmt.setString(1, l.getNome());
		psmt.executeUpdate();
		
	}		
	
}
