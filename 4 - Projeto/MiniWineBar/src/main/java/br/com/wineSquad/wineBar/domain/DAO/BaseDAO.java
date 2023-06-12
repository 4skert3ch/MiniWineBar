package br.com.wineSquad.wineBar.domain.DAO;

import java.sql.Connection;

public abstract class BaseDAO {
	private String tabela;
	protected Connection conn;

	
	public BaseDAO(Connection connection) {
		this.conn = connection;
	}
	
	
	protected void setTabela(String value) {
		this.tabela = value;
	}
	
	protected String getTabela() {
		return this.tabela;
	}

}
