package main.java.br.com.wineSquad.wineBar.domain.Service;

import main.java.br.com.wineSquad.wineBar.domain.DAO.CompraDAO;
import main.java.br.com.wineSquad.wineBar.domain.DAO.ItemCompraDAO;
import main.java.br.com.wineSquad.wineBar.domain.DAO.ProdutoDAO;
import main.java.br.com.wineSquad.wineBar.domain.Entity.Compra;
import main.java.br.com.wineSquad.wineBar.domain.Entity.ItemCompra;
import main.java.br.com.wineSquad.wineBar.domain.Entity.Produto;
import main.java.br.com.wineSquad.wineBar.domain.connection.ConnectionFactory;

import java.sql.Connection;
import java.util.ArrayList;

public class CompraService extends BaseService{

    public CompraService() {
        super();
    }

    public void adicionar(){
        Connection conn = connection.recuperarConexao();
        new CompraDAO(conn).adicionar(0.0, "Indefinido", "Aberta");
    }

    public void editar(Integer compraID, Double valorFinal, String metodoPagamento, String statusCompra){
        new CompraDAO(connection.recuperarConexao()).editar(compraID, valorFinal, metodoPagamento, statusCompra);
    }

    public ArrayList<Compra> listarComprasAbertas (){
        return new CompraDAO(connection.recuperarConexao()).listarComprasPorSatus("ABERTA");
    }

    public ArrayList<Compra> listarComprasFinalizadas (){
        return new CompraDAO(connection.recuperarConexao()).listarComprasPorSatus("FINALIZADA");
    }

    private Compra capturarCompraPorID(Integer compraID){
        var compra = new CompraDAO(connection.recuperarConexao()).capturarObjeto(compraID);
        if (compra != null) return compra;

        throw new RuntimeException("capturarCompraPorID");
    }

    public boolean excluir(Integer compraID) {
        var compra = capturarCompraPorID(compraID);
        ArrayList<ItemCompra> produtosCompra = new ItemCompraDAO(connection.recuperarConexao()).listarItensDaCompra(compraID);

        if (compra != null && produtosCompra == null) return new CompraDAO(connection.recuperarConexao()).removerObjeto(compraID);

        throw new RuntimeException("excluirCompra");
    }
}
