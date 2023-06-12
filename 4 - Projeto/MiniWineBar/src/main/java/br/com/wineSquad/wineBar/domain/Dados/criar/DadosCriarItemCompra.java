package br.com.wineSquad.wineBar.domain.Dados.criar;

import br.com.wineSquad.wineBar.domain.Entity.Compra;
import br.com.wineSquad.wineBar.domain.Entity.Produto;

public record DadosCriarItemCompra(DadosCriarBase baseDados, Integer quantidade, Produto produto, Compra compra) {
}