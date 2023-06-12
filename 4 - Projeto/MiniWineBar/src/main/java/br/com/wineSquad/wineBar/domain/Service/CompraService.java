package br.com.wineSquad.wineBar.domain.Service;

import br.com.wineSquad.wineBar.domain.DAO.CompraDAO;
import br.com.wineSquad.wineBar.domain.DAO.ItemCompraDAO;
import br.com.wineSquad.wineBar.domain.Entity.Compra;
import br.com.wineSquad.wineBar.domain.Entity.ItemCompra;

import java.sql.Connection;
import java.util.ArrayList;

public class CompraService extends BaseService{

    public static void adicionar(){
        Connection conn = connection.recuperarConexao();
        new CompraDAO(conn).adicionar(0.0, "Indefinido", "Aberta");
    }

    public static void editar(Integer compraID, Double valorFinal, String metodoPagamento, String statusCompra){
        new CompraDAO(connection.recuperarConexao()).editar(compraID, valorFinal, metodoPagamento, statusCompra);
    }

    public static ArrayList<Compra> listarComprasAbertas (){
        return new CompraDAO(connection.recuperarConexao()).listarComprasPorSatus("ABERTA");
    }

    public static ArrayList<Compra> listarComprasFinalizadas (){
        return new CompraDAO(connection.recuperarConexao()).listarComprasPorSatus("FINALIZADA");
    }

    private static Compra capturarCompraPorID(Integer compraID){
        var compra = new CompraDAO(connection.recuperarConexao()).capturarObjeto(compraID);
        if (compra != null) return compra;

        throw new RuntimeException("capturarCompraPorID");
    }

    public static boolean excluir(Integer compraID) {
        var compra = capturarCompraPorID(compraID);
        ArrayList<ItemCompra> produtosCompra = new ItemCompraDAO(connection.recuperarConexao()).listarItensDaCompra(compraID);

        if (compra != null && produtosCompra == null) return new CompraDAO(connection.recuperarConexao()).removerObjeto(compraID);

        throw new RuntimeException("excluirCompra");
    }
}
