package main.java.br.com.wineSquad.wineBar.domain.Service;

import main.java.br.com.wineSquad.wineBar.domain.DAO.CompraDAO;
import main.java.br.com.wineSquad.wineBar.domain.DAO.ItemCompraDAO;
import main.java.br.com.wineSquad.wineBar.domain.DAO.ProdutoDAO;
import main.java.br.com.wineSquad.wineBar.domain.Entity.Compra;
import main.java.br.com.wineSquad.wineBar.domain.Entity.ItemCompra;
import main.java.br.com.wineSquad.wineBar.domain.Entity.Produto;

import java.sql.Connection;
import java.util.ArrayList;


public class ProdutoService extends BaseService{

    public ProdutoService() {
		super();
	}

	public void adicionar(Produto produto){
		new ProdutoDAO(connection.recuperarConexao()).adicionar(produto.getValor(), produto.getNome(), produto.getDescricao(),
				produto.getUnMedida(), produto.getCategoria(), produto.getValorMedida());
	}

	public void editar(Produto produto){
		new ProdutoDAO(connection.recuperarConexao()).editar(produto.getId(), produto.getValor(), produto.getNome(),
				produto.getDescricao(),	produto.getUnMedida(), produto.getCategoria(), produto.getValorMedida());
	}

	public ArrayList<Produto> listarProdutos (){
		return new ProdutoDAO(connection.recuperarConexao()).listar();
	}

	public ArrayList<Produto> listarProdutosPorCategoria (String categoria){
		return new ProdutoDAO(connection.recuperarConexao()).listarPorCategoria(categoria);
	}

	public ArrayList<String> listarCategorias (){
		return new ProdutoDAO(connection.recuperarConexao()).listarCategoria();
	}

	private Produto capturarProdutoPorID(Integer produtoID){
		var produto = new ProdutoDAO(connection.recuperarConexao()).capturarObjeto(produtoID);
		if (produto != null) return produto;

		throw new RuntimeException("capturarProdutoPorID");
	}

	public boolean excluir(Integer produtoID) {
		var produto = capturarProdutoPorID(produtoID);
		ArrayList<ItemCompra> comprasComProduto = new ItemCompraDAO(connection.recuperarConexao()).listarComprasPorPordutos(produtoID);

		if (produto != null && comprasComProduto == null) return new CompraDAO(connection.recuperarConexao()).removerObjeto(produtoID);

		throw new RuntimeException("excluirProduto");
	}
}
