package br.com.wineSquad.wineBar.domain.Entity;

public class Compra extends Base{
	
    private String metodoPagamento;
    private String statusCompra;
    
    public Compra (Integer id, Double valor, String metodoPagamento, String statusCompra) {
		super.setId(id);
		super.setValor(valor);
		this.metodoPagamento = metodoPagamento;
		this.statusCompra = statusCompra;
	}

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public String getStatusCompra() {
        return statusCompra;
    }

    public void setStatusCompra(String statusCompra) {
        this.statusCompra = statusCompra;
    }
    
    @Override
    public String toString() {
    	return super.toString() + "";
    }

}
