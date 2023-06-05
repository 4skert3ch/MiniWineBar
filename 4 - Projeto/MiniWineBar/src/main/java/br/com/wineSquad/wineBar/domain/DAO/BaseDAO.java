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
	
	
	protected void setTabela(String value) {
		this.tabela = value;
	}
	
	protected String getTabela() {
		return this.tabela;
	}

}
