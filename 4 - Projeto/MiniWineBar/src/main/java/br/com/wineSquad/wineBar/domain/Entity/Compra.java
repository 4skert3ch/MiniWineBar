package main.java.br.com.wineSquad.wineBar.domain.Entity;

import main.java.br.com.wineSquad.wineBar.domain.Dados.criar.DadosCriarCompra;

public class Compra extends Base{
	
    private String metodoPagamento;
    private String statusCompra;
    
    public Compra (DadosCriarCompra dadosCompra) {
		super.setId(dadosCompra.baseDados().id());
		super.setValor(dadosCompra.baseDados().valor());
		this.metodoPagamento = dadosCompra.metodoPagamento();
		this.statusCompra = dadosCompra.statusCompra();
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
