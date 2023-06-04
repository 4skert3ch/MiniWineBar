package main.java.br.com.wineSquad.wineBar.domain.Dados.criar;

import main.java.br.com.wineSquad.wineBar.domain.Entity.Compra;
import main.java.br.com.wineSquad.wineBar.domain.Entity.Produto;

public record DadosCriarItemCompra(DadosCriarBase baseDados, Integer quantidade, Produto produto, Compra compra) {
}