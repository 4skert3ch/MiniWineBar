package main.java.br.com.wineSquad.wineBar.domain.Service;

import main.java.br.com.wineSquad.wineBar.domain.DAO.CompraDAO;
import main.java.br.com.wineSquad.wineBar.domain.DAO.ItemCompraDAO;
import main.java.br.com.wineSquad.wineBar.domain.DAO.ProdutoDAO;
import main.java.br.com.wineSquad.wineBar.domain.Entity.ItemCompra;
import main.java.br.com.wineSquad.wineBar.domain.Entity.Produto;

import java.util.ArrayList;

public class ItemCompraService extends BaseService{

    public ItemCompraService() {
        super();
    }

    public void adicionar(ItemCompra itemCompra){
        new ItemCompraDAO(connection.recuperarConexao()).adicionar(itemCompra.getValor(), itemCompra.getQuantidade(),
                itemCompra.getProduto(), itemCompra.getCompra());
    }

    public void editar(ItemCompra itemCompra){
        new ItemCompraDAO(connection.recuperarConexao()).editar(itemCompra.getId(), itemCompra.getValor(),
                itemCompra.getQuantidade(), itemCompra.getProduto(), itemCompra.getCompra());
    }

    public ArrayList<ItemCompra> listaTodosItensCompra (){
        return new ItemCompraDAO(connection.recuperarConexao()).listar();
    }

    public ArrayList<ItemCompra> listaItensDaCompra (Integer compraID){
        return new ItemCompraDAO(connection.recuperarConexao()).listarItensDaCompra(compraID);
    }

    public ArrayList<ItemCompra> listarComprasPorProduto (Integer produtoID){
        return new ItemCompraDAO(connection.recuperarConexao()).listarComprasPorPordutos(produtoID);
    }

    private ItemCompra capturarItemCompraPorID(Integer itemCompraID){
        var itemCompra = new ItemCompraDAO(connection.recuperarConexao()).capturarObjeto(itemCompraID);
        if (itemCompra != null) return itemCompra;

        throw new RuntimeException("capturarItemCompraIDPorID");
    }

    public boolean excluir(Integer itemCompraID) {
        var itemCompra = capturarItemCompraPorID(itemCompraID);

        if (itemCompra != null) return new ItemCompraDAO(connection.recuperarConexao()).removerObjeto(itemCompraID);

        throw new RuntimeException("excluirItemCompraID");
    }
}
