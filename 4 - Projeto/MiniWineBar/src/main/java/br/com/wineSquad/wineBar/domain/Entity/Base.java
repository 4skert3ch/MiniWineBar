package main.java.br.com.wineSquad.wineBar.domain.Entity;


public abstract class Base{
    private int id;
    private double valor;
    
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString() {
    	return "";
    }

}
