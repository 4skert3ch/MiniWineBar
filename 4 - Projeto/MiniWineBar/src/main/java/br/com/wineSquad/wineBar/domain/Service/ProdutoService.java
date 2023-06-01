package main.java.br.com.wineSquad.wineBar.domain.Service;

import java.sql.Connection;

public class ProdutoService {
	private Connection conn;
	
	public BaseDAO(Connection connection) {
		this.conn = connection;
	}
}
