package main.java.br.com.wineSquad.wineBar.domain.Entity;

import main.java.br.com.wineSquad.wineBar.domain.Dados.criar.DadosCriarProduto;

public class Produto extends Base{
	
	private String nome;
    private String descricao;
    private String unMedida;
    private double valorMedida;
    private String categoria;
	
    public Produto(DadosCriarProduto dadosProduto) {
		
		super.setId(dadosProduto.baseDados().id());
		super.setValor(dadosProduto.baseDados().valor());
		this.nome = dadosProduto.nome();
		this.descricao = dadosProduto.descricao();
		this.unMedida = dadosProduto.unMedida();
		this.valorMedida = dadosProduto.valorMedida();
		this.categoria = dadosProduto.categoria();
	}
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnMedida() {
        return unMedida;
    }

    public void setUnMedida(String unMedida) {
        this.unMedida = unMedida;
    }

    public double getValorMedida() {
        return valorMedida;
    }

    public void setValorMedida(double valorMedida) {
        this.valorMedida = valorMedida;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    @Override
    public String toString() {
    	return super.toString() + "";
    }
}
