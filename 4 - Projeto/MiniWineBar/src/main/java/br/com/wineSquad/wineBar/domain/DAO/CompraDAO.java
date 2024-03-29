package br.com.wineSquad.wineBar.domain.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.wineSquad.wineBar.domain.Entity.Compra;

public class CompraDAO extends BaseDAO {

	public CompraDAO(Connection connection) {
		super(connection);
		super.setTabela("compra");
	}

	public void adicionar (Double valor, String statusCompra, String metodoPagamento) {
		var sql = "INSERT INTO " + super.getTabela() +
					" VALUES (DEFAULT, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setDouble(1, valor);
			preparedStatement.setString(2, statusCompra);
			preparedStatement.setString(3, metodoPagamento);
			
			preparedStatement.execute();
			preparedStatement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void editar (Integer id, Double valor, String statusCompra, String metodoPagamento) {
		var sql = "UPDATE " + super.getTabela() +
				" SET valorFinal = ?, statusCompra = ?, metodoPagamento = ? WHERE id = ?";

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setDouble(1, valor);
			preparedStatement.setString(2, statusCompra);
			preparedStatement.setString(3, metodoPagamento);
			preparedStatement.setInt(4, id);
			
			preparedStatement.execute();
			preparedStatement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	
	}
	
	public ArrayList<Compra> listarComprasPorSatus (String statusCompra){
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		ArrayList<Compra> lista = new ArrayList<>();
		
		String sql = "SELECT * FROM " + super.getTabela() + " WHERE STATUSCOMPRA = ?";
		
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, statusCompra);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt(1);
				Double valor = resultSet.getDouble(2);
				String metodoPagamento = resultSet.getString(4);
				var compra = new Compra(id, valor, statusCompra, metodoPagamento);
				lista.add(compra);
			}
			resultSet.close();
			preparedStatement.close();
			conn.close();
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}

	public ArrayList<Compra> listarTodasCompras (){
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		ArrayList<Compra> lista = new ArrayList<>();

		String sql = "SELECT * FROM " + super.getTabela();

		try {
			preparedStatement = conn.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt(1);
				Double valor = resultSet.getDouble(2);
				String statusCompra = resultSet.getString(3);
				String metodoPagamento = resultSet.getString(4);
				var compra = new Compra(id, valor, statusCompra, metodoPagamento);
				lista.add(compra);
			}
			resultSet.close();
			preparedStatement.close();
			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}
	
	public Compra capturarObjeto (Integer id) {
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		Compra compra = null;
		
		String sql = "SELECT * FROM " + super.getTabela() + " WHERE ID = ?";
		
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Double valor = resultSet.getDouble(2);
				String statusCompra = resultSet.getString(3);
				String metodoPagamento = resultSet.getString(4);
				compra = new Compra(id, valor, statusCompra, metodoPagamento);
			}
			resultSet.close();
			preparedStatement.close();
			conn.close();
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return compra;
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
