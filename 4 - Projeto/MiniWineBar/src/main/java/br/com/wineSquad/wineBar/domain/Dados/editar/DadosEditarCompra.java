package main.java.br.com.wineSquad.wineBar.domain.Dados.editar;

import main.java.br.com.wineSquad.wineBar.domain.Dados.criar.DadosCriarBase;

public record DadosEditarCompra(DadosEditarBase baseDados, String metodoPagamento, String statusCompra) {
}