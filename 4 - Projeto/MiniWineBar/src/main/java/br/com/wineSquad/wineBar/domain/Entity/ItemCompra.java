package main.java.br.com.wineSquad.wineBar.domain.Entity;

public class ItemCompra extends Base{
	
	private Integer quantidade;
    private Produto produto;
    private Compra compra;
	
	public ItemCompra (Integer id, Double valor, Integer quantidade, Produto produto, Compra compra) {
		super.setId(id);
		super.setValor(valor);
		this.quantidade = quantidade;
		this.produto = produto;
		this.compra = compra;
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
