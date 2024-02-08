package edu.curso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.curso.entidade.Jogos;

public class JogosDAOImpl implements JogosDAO {

private Connection con;
	
	public JogosDAOImpl() { 
		con = DBUtil.getInstance().getConn();
	}

	public void adicionar(Jogos j) {
		String sql ="INSERT INTO jogos (id, nome, genero, desenvolvedora, "
				+ "publicadora, anoComprado, anoJogo, preco, quantidade) " + 
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setLong(1, j.getId());
			psmt.setString(2, j.getNome());
			psmt.setString(3, j.getGenero());
			psmt.setString(4, j.getDesenvolvedora());
			psmt.setString(5, j.getPublicadora());
			psmt.setInt(6, j.getAnoComprado());
			psmt.setInt(7, j.getAnoJogo());
			psmt.setDouble(8, j.getPreco());
			psmt.setInt(9, j.getQuantidade());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		

	public void alterar(Jogos j) throws SQLException {
			String sql = "UPDATE jogos SET nome = ?, genero = ?, desenvolvedora = ?, "
				+ "publicadora = ?, anoComprado = ?, anoJogo = ?, preco = ?, quantidade = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, j.getNome());
			pst.setString(2, j.getGenero());
			pst.setString(3, j.getDesenvolvedora());
			pst.setString(4, j.getPublicadora());
			pst.setInt(5, j.getAnoComprado());
			pst.setInt(6, j.getAnoJogo());
			pst.setDouble(7, j.getPreco());
			pst.setInt(8, j.getQuantidade());
			pst.execute();
	}

	public List<Jogos> pesquisarPorNome(String nome) {
			List<Jogos> times = new ArrayList<Jogos>();
			String sql ="SELECT id, nome, genero, desenvolvedora, "
				+ "publicadora, anoComprado, anoJogo, preco, quantidade FROM jogos " + 
					"WHERE nome like ?";
			try {
				PreparedStatement psmt = con.prepareStatement(sql);
				psmt.setString(1, "%" + nome + "%");
				ResultSet rs = psmt.executeQuery();
				while(rs.next()) {
					Jogos j = new Jogos();
					j.setId( rs.getLong("id") );
					j.setNome( rs.getString("nome") );
					j.setGenero( rs.getString("genero") );
					j.setDesenvolvedora( rs.getString("desenvolvedora") );
					j.setPublicadora(rs.getString("publicadora"));
					j.setAnoComprado(rs.getInt("anoComprado"));
					j.setAnoJogo(rs.getInt("anoJogo"));
					j.setPreco(rs.getDouble("preco"));
					j.setQuantidade(rs.getInt("quantidade"));
					
	
					times.add( j );
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return times;
		}

	public void deletar(Jogos j) throws SQLException {
		String sql = "DELETE FROM jogos WHERE nome = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, j.getNome());
		pst.executeUpdate();
	}
		
}
