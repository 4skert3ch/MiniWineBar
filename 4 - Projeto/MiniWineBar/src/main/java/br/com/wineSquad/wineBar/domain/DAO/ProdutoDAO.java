package main.java.br.com.wineSquad.wineBar.domain.DAO;

import java.sql.Connection;

public class ProdutoDAO extends BaseDAO{

	public ProdutoDAO(Connection connection) {
		super(connection);
		super.setTabela("produto");
	}

}
