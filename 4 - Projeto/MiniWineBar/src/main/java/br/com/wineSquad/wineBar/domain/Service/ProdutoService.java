package br.com.wineSquad.wineBar.domain.Service;

import br.com.wineSquad.wineBar.domain.DAO.CompraDAO;
import br.com.wineSquad.wineBar.domain.DAO.ItemCompraDAO;
import br.com.wineSquad.wineBar.domain.DAO.ProdutoDAO;
import br.com.wineSquad.wineBar.domain.Entity.ItemCompra;
import br.com.wineSquad.wineBar.domain.Entity.Produto;

import java.util.ArrayList;

public class ProdutoService extends BaseService{

	public static void adicionar(Produto produto){
		new ProdutoDAO(connection.recuperarConexao()).adicionar(produto.getValor(), produto.getNome(), produto.getDescricao(),
				produto.getUnMedida(), produto.getCategoria(), produto.getValorMedida());
	}

	public static void editar(Produto produto){
		new ProdutoDAO(connection.recuperarConexao()).editar(produto.getId(), produto.getValor(), produto.getNome(),
				produto.getDescricao(),	produto.getUnMedida(), produto.getCategoria(), produto.getValorMedida());
	}

	public static ArrayList<Produto> listarProdutos (){
		return new ProdutoDAO(connection.recuperarConexao()).listar();
	}

	public static ArrayList<Produto> listarProdutosPorCategoria (String categoria){
		return new ProdutoDAO(connection.recuperarConexao()).listarPorCategoria(categoria);
	}

	public static ArrayList<String> listarCategorias (){
		return new ProdutoDAO(connection.recuperarConexao()).listarCategoria();
	}

	public static ArrayList<Produto> listarSugestoes (){
		return new ProdutoDAO(connection.recuperarConexao()).listarSugestoes();
	}

	public static Produto capturarProdutoPorID(Integer produtoID){
		var produto = new ProdutoDAO(connection.recuperarConexao()).capturarObjeto(produtoID);
		if (produto != null) return produto;

		throw new RuntimeException("capturarProdutoPorID");
	}

	public static boolean excluir(Integer produtoID) {
		var produto = capturarProdutoPorID(produtoID);
		ArrayList<ItemCompra> comprasComProduto = new ItemCompraDAO(connection.recuperarConexao()).listarComprasPorPordutos(produtoID);

		if (produto != null && comprasComProduto == null) return new CompraDAO(connection.recuperarConexao()).removerObjeto(produtoID);

		throw new RuntimeException("excluirProduto");
	}
}
