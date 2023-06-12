package br.com.wineSquad.wineBar.domain.Dados.editar;

import br.com.wineSquad.wineBar.domain.Dados.criar.DadosCriarBase;

public record DadosEditarProduto(DadosCriarBase baseDados, String descricao, String umMedida, String categoria, Double valorMedida) {
}