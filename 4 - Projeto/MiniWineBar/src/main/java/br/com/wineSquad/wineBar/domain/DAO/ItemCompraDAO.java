package main.java.br.com.wineSquad.wineBar.domain.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import main.java.br.com.wineSquad.wineBar.domain.Entity.Compra;
import main.java.br.com.wineSquad.wineBar.domain.Entity.ItemCompra;
import main.java.br.com.wineSquad.wineBar.domain.Entity.Produto;

public class ItemCompraDAO extends BaseDAO{

	public ItemCompraDAO(Connection connection) {
		super(connection);
		super.setTabela("itemCompra");
	}

	public void adicionar (Double valor, Integer quantidade, Produto produto, Compra compra) {

		var sql = "INSERT INTO ? " +
					"VALUES (DEFAULT, ?, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			
			preparedStatement.setString(1, super.getTabela());
			preparedStatement.setInt(2, quantidade);
			preparedStatement.setDouble(3, valor);
			preparedStatement.setInt(4, produto.getId());
			preparedStatement.setInt(5, compra.getId());
			
			preparedStatement.execute();
			preparedStatement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void editar (Integer id, Double valor, Integer quantidade, Produto produto, Compra compra) {
		var sql = "UPDATE ? " +
				"SET quantidade = ?, valorTotal = ?, idProduto = ?, IdCompra = ? WHERE id = ?";
	
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			
			preparedStatement.setString(1, super.getTabela());
			preparedStatement.setInt(2, quantidade);
			preparedStatement.setDouble(3, valor);
			preparedStatement.setInt(4, produto.getId());
			preparedStatement.setInt(5, compra.getId());
			preparedStatement.setInt(6, id);
			
			preparedStatement.execute();
			preparedStatement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	
	}
	
	public ArrayList<ItemCompra> listar (){
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		ArrayList<ItemCompra> lista = new ArrayList<>();
		
		String sql = "SELECT * FROM ?";
		
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, super.getTabela());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt(1);
				Integer quantidade = resultSet.getInt(2);
				Double valor = resultSet.getDouble(3);
				Integer produto = resultSet.getInt(4);
				Integer compra = resultSet.getInt(5);
				var itemCompra = new ItemCompra(id, valor, quantidade, null, null);
				lista.add(itemCompra);
			}
			resultSet.close();
			preparedStatement.close();
			conn.close();
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}
	
	public ItemCompra capturarObjeto (Integer id) {
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		ItemCompra itemCompra = null;
		
		String sql = "SELECT * FROM ? WHERE ID = ?";
		
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, super.getTabela());
			preparedStatement.setInt(2, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer quantidade = resultSet.getInt(2);
				Double valor = resultSet.getDouble(3);
				Integer produto = resultSet.getInt(4);
				Integer compra = resultSet.getInt(5);
				itemCompra = new ItemCompra(id, valor, quantidade, null, null);
			}
			resultSet.close();
			preparedStatement.close();
			conn.close();
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return itemCompra;
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
