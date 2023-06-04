package main.java.br.com.wineSquad.wineBar.domain.Dados.editar;

import main.java.br.com.wineSquad.wineBar.domain.Dados.criar.DadosCriarBase;

public record DadosEditarProduto(DadosCriarBase baseDados, String descricao, String umMedida, String categoria, Double valorMedida) {
}