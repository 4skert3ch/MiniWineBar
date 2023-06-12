package br.com.wineSquad.wineBar.domain.Entity;

public class Produto extends Base{
	
	private String nome;
    private String descricao;
    private String unMedida;
    private double valorMedida;
    private String categoria;
	
    public Produto(Integer id, Double valor, String nome, String descricao,
    		String unMedida, String categoria, Double valorMedida) {
		
		super.setId(id);
		super.setValor(valor);
		this.nome = nome;
		this.descricao = descricao;
		this.unMedida = unMedida;
		this.valorMedida = valorMedida;
		this.categoria = categoria;
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
    	return super.toString() + " , Nome: " + this.nome + " , " + this.valorMedida + this.unMedida;
    }
}
