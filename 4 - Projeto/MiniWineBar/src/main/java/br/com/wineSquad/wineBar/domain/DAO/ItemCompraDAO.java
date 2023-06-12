package br.com.wineSquad.wineBar.domain.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.wineSquad.wineBar.domain.Entity.Compra;
import br.com.wineSquad.wineBar.domain.Entity.ItemCompra;
import br.com.wineSquad.wineBar.domain.Entity.Produto;

public class ItemCompraDAO extends BaseDAO{

	public ItemCompraDAO(Connection connection) {
		super(connection);
		super.setTabela("itemCompra");

	}

	public void adicionar (Double valor, Integer quantidade, Produto produto, Compra compra) {

		var sql = "INSERT INTO " + super.getTabela() +
					" VALUES (DEFAULT, ?, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setInt(1, quantidade);
			preparedStatement.setDouble(2, valor);
			preparedStatement.setInt(3, produto.getId());
			preparedStatement.setInt(4, compra.getId());
			
			preparedStatement.execute();
			preparedStatement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void editar (Integer id, Double valor, Integer quantidade, Produto produto, Compra compra) {
		var sql = "UPDATE " + super.getTabela() +
				" SET quantidade = ?, valorTotal = ?, idProduto = ?, IdCompra = ? WHERE id = ?";
	
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setInt(1, quantidade);
			preparedStatement.setDouble(2, valor);
			preparedStatement.setInt(3, produto.getId());
			preparedStatement.setInt(4, compra.getId());
			preparedStatement.setInt(5, id);
			
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
		
		String sql = "SELECT * FROM " + super.getTabela();
		
		try {
			preparedStatement = conn.prepareStatement(sql);
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

	public ArrayList<ItemCompra> listarItensDaCompra (Integer compraID){
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		ArrayList<ItemCompra> lista = new ArrayList<>();

		String sql = "SELECT * FROM " + super.getTabela() + " WHERE IDCOMPRA = ?";

		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, compraID);
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

	public ArrayList<ItemCompra> listarComprasPorPordutos (Integer produtoID){
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		ArrayList<ItemCompra> lista = new ArrayList<>();

		String sql = "SELECT * FROM " + super.getTabela() + " WHERE IDPRODUTO = ?";

		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, produtoID);
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
		
		String sql = "SELECT * FROM " + super.getTabela() + " WHERE ID = ?";
		
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
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
		
		String sql = "DELETE FROM " + super.getTabela() + " WHERE ID = ?";
		
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			preparedStatement.execute();
			preparedStatement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return true;
	}
}
