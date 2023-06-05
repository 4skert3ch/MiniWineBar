package main.java.br.com.wineSquad.wineBar.domain.Entity;

import main.java.br.com.wineSquad.wineBar.domain.Dados.criar.DadosCriarItemCompra;

public class ItemCompra extends Base{
	
	private Integer quantidade;
    private Produto produto;
    private Compra compra;
	
	public ItemCompra (DadosCriarItemCompra dadosItemCompra) {
		super.setId(dadosItemCompra.baseDados().id());
		super.setValor(dadosItemCompra.baseDados().valor());
		this.quantidade = dadosItemCompra.quantidade();
		this.produto = dadosItemCompra.produto();
		this.compra = dadosItemCompra.compra();
	}

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    @Override
    public String toString() {
    	return super.toString() + "";
    }

}
