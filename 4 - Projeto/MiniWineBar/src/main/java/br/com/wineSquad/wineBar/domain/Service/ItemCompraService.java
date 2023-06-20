package br.com.wineSquad.wineBar.domain.Service;

import br.com.wineSquad.wineBar.domain.DAO.CompraDAO;
import br.com.wineSquad.wineBar.domain.DAO.ItemCompraDAO;
import br.com.wineSquad.wineBar.domain.Entity.ItemCompra;

import java.util.ArrayList;

public class ItemCompraService extends BaseService{

    public static void adicionar(ItemCompra itemCompra){
        new ItemCompraDAO(connection.recuperarConexao()).adicionar(itemCompra.getValor(), itemCompra.getQuantidade(),
                itemCompra.getProduto(), itemCompra.getCompra());
        var compra = itemCompra.getCompra();
        compra.setValor(compra.getValor() + itemCompra.getValor());
        new CompraDAO(connection.recuperarConexao()).editar(compra.getId(), compra.getValor(),
                compra.getMetodoPagamento(), compra.getStatusCompra());
    }

    public static void editar(ItemCompra itemCompra){
        ItemCompra itemAntigo = ItemCompraService.capturarItemCompraPorID(itemCompra.getId());
        new ItemCompraDAO(connection.recuperarConexao()).editar(itemCompra.getId(), itemCompra.getValor(),
                itemCompra.getQuantidade(), itemCompra.getProduto(), itemCompra.getCompra());
        var compra = itemCompra.getCompra();
        compra.setValor(compra.getValor() + itemCompra.getValor() - itemAntigo.getValor());
        new CompraDAO(connection.recuperarConexao()).editar(compra.getId(), compra.getValor(), compra.getMetodoPagamento(), compra.getStatusCompra());
    }

    public static ArrayList<ItemCompra> listaTodosItensCompra (){
        return new ItemCompraDAO(connection.recuperarConexao()).listar();
    }

    public static ArrayList<ItemCompra> listaItensDaCompra (Integer compraID){
        return new ItemCompraDAO(connection.recuperarConexao()).listarItensDaCompra(compraID);
    }

    public static ArrayList<ItemCompra> listarComprasPorProduto (Integer produtoID){
        return new ItemCompraDAO(connection.recuperarConexao()).listarComprasPorPordutos(produtoID);
    }

    private static ItemCompra capturarItemCompraPorID(Integer itemCompraID){
        var itemCompra = new ItemCompraDAO(connection.recuperarConexao()).capturarObjeto(itemCompraID);
        if (itemCompra != null) return itemCompra;

        throw new RuntimeException("capturarItemCompraIDPorID");
    }

    public static boolean excluir(Integer itemCompraID) {
        var itemCompra = capturarItemCompraPorID(itemCompraID);

        if (itemCompra != null) {
            var compra = itemCompra.getCompra();
            compra.setValor(compra.getValor() - itemCompra.getValor());
            new CompraDAO(connection.recuperarConexao()).editar(compra.getId(),compra.getValor(),compra.getMetodoPagamento(), compra.getStatusCompra());
            return new ItemCompraDAO(connection.recuperarConexao()).removerObjeto(itemCompraID);
        }

        throw new RuntimeException("excluirItemCompraID");
    }
}
