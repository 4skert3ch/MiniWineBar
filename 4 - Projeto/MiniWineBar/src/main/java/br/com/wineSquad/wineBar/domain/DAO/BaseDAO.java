package main.java.br.com.wineSquad.wineBar.domain.DAO;

import java.sql.Connection;
import java.util.ArrayList;

import main.java.br.com.wineSquad.wineBar.domain.Dados.criar.DadosCriarBase;
import main.java.br.com.wineSquad.wineBar.domain.Dados.editar.DadosEditarBase;
import main.java.br.com.wineSquad.wineBar.domain.Entity.Base;

public abstract class BaseDAO {
	private Connection conn;
	
	public BaseDAO(Connection connection) {
		this.conn = connection;
	}
	
	public void adicionar (DadosCriarBase dadosBase) {
		
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
}
