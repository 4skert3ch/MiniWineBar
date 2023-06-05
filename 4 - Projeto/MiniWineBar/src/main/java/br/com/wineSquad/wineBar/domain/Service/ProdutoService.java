package main.java.br.com.wineSquad.wineBar.domain.Service;

import java.sql.Connection;


	private Connection conn;
	
	public ProdutoService(Connection connection) {
		this.conn = connection;
	}

}
