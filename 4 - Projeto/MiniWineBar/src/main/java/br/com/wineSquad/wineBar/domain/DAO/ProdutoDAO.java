package br.com.wineSquad.wineBar.domain.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.wineSquad.wineBar.domain.Entity.Produto;

public class ProdutoDAO extends BaseDAO{

	public ProdutoDAO(Connection connection) {
		super(connection);
		super.setTabela("produto");
	}

	public void adicionar (Double valor, String nome, String descricao, String unMedida, String categoria, Double valorMedida) {
		
		var sql = "INSERT INTO ? " +
					"VALUES (DEFAULT, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			
			preparedStatement.setString(1, super.getTabela());
			preparedStatement.setString(2, nome);
			preparedStatement.setString(3, descricao);
			preparedStatement.setDouble(4, valor);
			preparedStatement.setString(5, unMedida);
			preparedStatement.setDouble(6, valorMedida);
			preparedStatement.setString(7, categoria);
			
			preparedStatement.execute();
			preparedStatement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void editar (Integer id, Double valor, String nome, String descricao, String unMedida, String categoria, Double valorMedida) {
		var sql = "UPDATE ? " +
				"SET nome = ?, descricao = ?, precounitario = ?, unmedida = ?, valor = ? WHERE id = ?";
	
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			
			preparedStatement.setString(1, super.getTabela());
			preparedStatement.setString(2, nome);
			preparedStatement.setString(3, descricao);
			preparedStatement.setDouble(4, valor);
			preparedStatement.setString(5, unMedida);
			preparedStatement.setDouble(6, valorMedida);
			preparedStatement.setString(7, categoria);
			
			preparedStatement.execute();
			preparedStatement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	
	}
	
	public ArrayList<Produto> listar (){
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		ArrayList<Produto> lista = new ArrayList<>();
		
		String sql = "SELECT * FROM ?";
		
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, super.getTabela());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt(1);
				String nome = resultSet.getString(2);
				String descricao = resultSet.getString(3);
				Double valor = resultSet.getDouble(4);
				String unMedida = resultSet.getString(5);
				Double valorMedida = resultSet.getDouble(6);
				String categoria = resultSet.getString(7);
				var produto = new Produto(id, valor, nome, descricao, unMedida, categoria, valorMedida);
				lista.add(produto);
			}
			resultSet.close();
			preparedStatement.close();
			conn.close();
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}

	public ArrayList<Produto> listarPorCategoria (String categoria){
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		ArrayList<Produto> lista = new ArrayList<>();

		String sql = "SELECT * FROM ? WHERE CATEGORIA = ?";

		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, super.getTabela());
			preparedStatement.setString(2, categoria);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt(1);
				String nome = resultSet.getString(2);
				String descricao = resultSet.getString(3);
				Double valor = resultSet.getDouble(4);
				String unMedida = resultSet.getString(5);
				Double valorMedida = resultSet.getDouble(6);
				var produto = new Produto(id, valor, nome, descricao, unMedida, categoria, valorMedida);
				lista.add(produto);
			}
			resultSet.close();
			preparedStatement.close();
			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}

	public ArrayList<String> listarCategoria (){
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		ArrayList<String> lista = new ArrayList<>();

		String sql = "SELECT DISTINCT CATEGORIA FROM ?";
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, super.getTabela());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				lista.add(resultSet.getString(1));
			}
			resultSet.close();
			preparedStatement.close();
			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}

	public ArrayList<Produto> listarSugestoes (){
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		ArrayList<Produto> lista = new ArrayList<>();

		String sql = "SELECT P.* FROM PRODUTO P JOIN ITEMCOMPRA IC ON P.ID = IC.IDPRODUTO group by IC.IDPRODUTO " +
					 "ORDER BY COUNT(IC.IDPRODUTO) DESC LIMIT 5;";

		try {
			preparedStatement = conn.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt(1);
				String nome = resultSet.getString(2);
				String descricao = resultSet.getString(3);
				Double valor = resultSet.getDouble(4);
				String unMedida = resultSet.getString(5);
				Double valorMedida = resultSet.getDouble(6);
				String categoria = resultSet.getString(7);
				var produto = new Produto(id, valor, nome, descricao, unMedida, categoria, valorMedida);
				lista.add(produto);
			}
			resultSet.close();
			preparedStatement.close();
			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}

	public Produto capturarObjeto (Integer id) {
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		Produto produto = null;
		
		String sql = "SELECT * FROM ? WHERE ID = ?";
		
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, super.getTabela());
			preparedStatement.setInt(2, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String nome = resultSet.getString(2);
				String descricao = resultSet.getString(3);
				Double valor = resultSet.getDouble(4);
				String unMedida = resultSet.getString(5);
				Double valorMedida = resultSet.getDouble(6);
				String categoria = resultSet.getString(7);
				produto = new Produto(id, valor, nome, descricao, unMedida, categoria, valorMedida);
			}
			resultSet.close();
			preparedStatement.close();
			conn.close();
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return produto;
	}
	
	public boolean removerObjeto(Integer id) {
		PreparedStatement preparedStatement;
		
		String sql = "DELETE FROM ? WHERE ID = ?";
		
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, super.getTabela());
			preparedStatement.setInt(2, id);
			
			preparedStatement.execute();
			preparedStatement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return true;
	}
}
