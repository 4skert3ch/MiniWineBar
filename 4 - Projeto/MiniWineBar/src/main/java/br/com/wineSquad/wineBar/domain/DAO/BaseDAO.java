package main.java.br.com.wineSquad.wineBar.domain.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import main.java.br.com.wineSquad.wineBar.domain.Dados.criar.DadosCriarBase;
import main.java.br.com.wineSquad.wineBar.domain.Dados.editar.DadosEditarBase;
import main.java.br.com.wineSquad.wineBar.domain.Entity.Base;

public abstract class BaseDAO {
	private String tabela;
	protected Connection conn;

	
	public BaseDAO(Connection connection) {
		this.conn = connection;
	}
	
	public void adicionar (DadosCriarBase dadosBase) {

		var sql = "INSERT INTO ? " +
					"VALUES (?, ?)";
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			
			preparedStatement.setString(1, tabela);
			preparedStatement.setInt(2, dadosBase.id());
			preparedStatement.setDouble(3, dadosBase.valor());
			
			preparedStatement.execute();
			preparedStatement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void editar (DadosEditarBase dadosBase) {
		var sql = "UPDATE ? " +
				"SET ? ";
	
	try {
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		
		preparedStatement.setString(1, tabela);
		preparedStatement.setInt(2, dadosBase.id());
		preparedStatement.setDouble(3, dadosBase.valor());
		
		preparedStatement.execute();
		preparedStatement.close();
		conn.close();
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
	}
	
	public ArrayList<Base> listar (){
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		ArrayList<Base> lista = new ArrayList<>();
		
		String sql = "SELECT * FROM ?";
		
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, tabela);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt(1);
				Double valor = resultSet.getDouble(2);
				var base = new Base();
				lista.add(base);
			}
			resultSet.close();
			preparedStatement.close();
			conn.close();
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
		
	}
	
	public void editar (DadosEditarBase dadosbase) {
		
	}
	
	public ArrayList<Base> listar (){
		return new ArrayList<Base>();

	}
	
	public Base capturarObjeto (Integer id) {
		return new Base();
	}
	
	public boolean removerObjeto(Integer id) {
		return true;
	}
	
	protected void setTabela(String value) {
		this.tabela = value;
	}
	
	protected String getTabela() {
		return this.tabela;
	}

}
