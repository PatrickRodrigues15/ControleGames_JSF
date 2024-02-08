package edu.curso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.curso.entidade.Console;

public class ConsoleDAOImpl implements ConsoleDAO {

	private Connection con;

	public ConsoleDAOImpl() {
		con = DBUtil.getInstance().getConn();
	}

	@Override
	public void adicionar(Console c) {

		String sql = "INSERT INTO consoles (id, nome, preco, dtLancamento,produtora, versao) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setLong(1, c.getId());
			psmt.setString(2, c.getNome());
			psmt.setDouble(3, c.getPreco());
			psmt.setDate(4, new java.sql.Date(c.getDtLancamento().getTime()));
			psmt.setString(5, c.getProdutora());
			psmt.setString(6, c.getVersao());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void alterar(Console c) throws SQLException {
		String sql = "UPDATE consoles SET nome = ?, preco = ?,  dtLancamento = ?, produtora = ?, versao = ?";
		PreparedStatement psmt = con.prepareStatement(sql);
//		psmt.setLong(1, c.getId());
		psmt.setString(1, c.getNome());
		psmt.setDouble(2, c.getPreco());
		psmt.setDate(3, new java.sql.Date(c.getDtLancamento().getTime()));
		psmt.setString(4, c.getProdutora());
		psmt.setString(5, c.getVersao());
		psmt.execute();
		psmt.close();
	}

	@Override
	public List<Console> pesquisarPorNome(String nome) {
		List<Console> consoles = new ArrayList<Console>();
		String sql = "SELECT id, nome, preco, dtLancamento,produtora, versao FROM consoles " + "WHERE nome like ?";
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, "%" + nome + "%");
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				Console c = new Console();
				c.setId(rs.getLong("id"));
				c.setNome(rs.getString("nome"));
				c.setPreco(rs.getDouble("preco"));
				c.setDtLancamento(rs.getDate("dtLancamento"));
				c.setProdutora(rs.getString("produtora"));
				c.setVersao(rs.getString("versao"));
				consoles.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return consoles;
	}

	@Override
	public void deletar(Console c) throws SQLException {
		String sql = "DELETE FROM consoles WHERE id = ?";
		PreparedStatement psmt = con.prepareStatement(sql);
		psmt.setLong(1, c.getId());
		psmt.executeUpdate();
	}

}
