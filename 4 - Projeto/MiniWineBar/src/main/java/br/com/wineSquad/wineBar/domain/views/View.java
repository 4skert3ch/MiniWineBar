package br.com.wineSquad.wineBar.domain.views;

import br.com.wineSquad.wineBar.domain.Entity.Compra;
import br.com.wineSquad.wineBar.domain.Entity.ItemCompra;
import br.com.wineSquad.wineBar.domain.Entity.Produto;
import br.com.wineSquad.wineBar.domain.Service.CompraService;
import br.com.wineSquad.wineBar.domain.Service.ItemCompraService;
import br.com.wineSquad.wineBar.domain.Service.ProdutoService;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
	private Compra compra;

	public View () {
		if (CompraService.listarComprasAbertas().size() == 0) CompraService.adicionar();
		this.compra = CompraService.listarComprasAbertas().get(0);
	}

	public void menuInicial(Scanner scan) {
		int op;
		do {
			System.out.print("""
					--------------------
					1 - Catálogo
					2 - Histórico
					3 - Carrinho
					4 - Sair
					--------------------
					Sua Opção:\s""");
			op = scan.nextInt();

			switch (op) {
				case 1 -> this.catalogo(scan);
				case 2 -> this.historico(scan);
				case 3 -> this.carrinho(scan);
				case 4 -> this.sair();
				default -> System.out.println("Opção Inválida, tente novamente!");
			}
		} while (op < 1 || op > 4);
	}

	public void catalogo(Scanner scan) {
		int op;
		do {
			System.out.print("""
				--------------------
				1 - Sugestões
				2 - Pesquisa por Texto
				3 - Pesquisa por Categoria
				4 - Carrinho
				5 - Voltar
				--------------------
				Sua Opção: \s""");
			op = scan.nextInt();

			switch (op) {
				case 1 -> this.sugestoes(scan);
				case 2 -> this.pesquisaTexto(scan);
				case 3 -> this.pesquisaCategoria(scan);
				case 4 -> this.carrinho(scan);
				case 5 -> this.menuInicial(scan);
				default -> System.out.println("Opção Inválida, tente novamente!");
			}
		} while (op < 1 || op > 5);
	}

	public void sugestoes(Scanner scan) {
		ArrayList<Produto> sugetoes = ProdutoService.listarSugestoes();
		int op;
		do {
			System.out.println("--------------------");
			for (int i = 1; i <= sugetoes.size(); i++) {
				System.out.println(i + " - Produto: " + sugetoes.get(i - 1).toString());
			}
			System.out.println(sugetoes.size() + 1 + " - Voltar");
			System.out.println("--------------------");
			System.out.print("Sua Opção:");
			op = scan.nextInt();
			if (op > 0 && op <= sugetoes.size()){
				this.selecionarItem(scan, sugetoes.get(op - 1));
			} else if (op == sugetoes.size() + 1) {
				this.catalogo(scan);
			} else{
				System.out.println("Opção Inválida, tente novamente!");
			}
		} while (op < 1 || op > sugetoes.size() + 1);
	}

	public void selecionarItem(Scanner scan, Produto produto) {

		int op;
		do {
			System.out.println("--------------------");
			System.out.println(produto.getDescricao());
			System.out.println(produto.getValorMedida() + " " + produto.getUnMedida());
			System.out.println("Valor por unidade: " + produto.getValor());
			System.out.println("Qual a quantidade que gostarias de comprar? (Digite 0 para voltar)");
			System.out.print("Sua escolha:");
			op = scan.nextInt();
			if (op > 0){
				double valorTotal = op * produto.getValor();
				System.out.println(op + " x " + produto.getValor() + " -→ " + valorTotal);
				ItemCompraService.adicionar(new ItemCompra(0, valorTotal, op, produto, compra));
				this.catalogo(scan);
			} else {
				if (op == 0){
					this.catalogo(scan);
				} else {
					System.out.println("Opção Inválida, tente novamente!");
				}
			}

		} while (op < 0);

	}

	public void pesquisaTexto(Scanner scan) {
		int op;
		System.out.println("Colocar texto");
		do {
			System.out.print(
					"--------------------\n" +
							"0 - Refazer pesquisa\n" +
							"1 - Produto 1\n" +
							"2 - Produto 2\n" +
							"3 - Produto 3\n" +
							"4 - Produto 4\n" +
							"5 - Produto 5\n" +
							"6 - Voltar\n" +
							"--------------------\n" +
							"Sua Opção: ");
			op = scan.nextInt();

			switch (op) {
				//case 1, 2, 3, 4, 5 -> this.selecionarItem(scan, op);
				case 6 -> this.catalogo(scan);
				default -> System.out.println("Opção Inválida, tente novamente!");
			}

		} while (op < 1 || op > 5);
	}

	public void pesquisaCategoria(Scanner scan) {
		int op;
		do {
			System.out.print(
					"--------------------\n" +
							"1 - Categoria 1\n" +
							"2 - Categoria 2\n" +
							"3 - Categoria 3\n" +
							"4 - Categoria 4\n" +
							"5 - Categoria 5\n" +
							"6 - Voltar\n" +
							"--------------------\n" +
							"Sua Opção: ");
			op = scan.nextInt();

			switch (op) {
				case 1, 2, 3, 4, 5 -> this.selecionarItemCategoria(scan, "categoria");
				case 6 -> this.catalogo(scan);
				default -> System.out.println("Opção Inválida, tente novamente!");
			}

		} while (op < 1 || op > 5);
	}

	public void selecionarItemCategoria(Scanner scan, String categoria) {
		int op;
		// Pesquisar produtos pela categoria
		do {
			System.out.print(
					"--------------------\n" +
							"1 - Produto 1\n" +
							"2 - Produto 2\n" +
							"3 - Produto 3\n" +
							"4 - Produto 4\n" +
							"5 - Produto 5\n" +
							"6 - Voltar\n" +
							"--------------------\n" +
							"Sua Opção: ");
			op = scan.nextInt();

			switch (op) {
				//case 1, 2, 3, 4, 5 -> this.selecionarItem(scan, op);
				case 6 -> this.pesquisaCategoria(scan);
				default -> System.out.println("Opção Inválida, tente novamente!");
			}

		} while (op < 1 || op > 5);
	}

	public void historico(Scanner scan) {
		// Mostrar compras
		int op;
		do {
			System.out.print(
					"--------------------\n" +
							"1 - Histórico 1\n" +
							"2 - Histórico 2\n" +
							"3 - Histórico 3\n" +
							"4 - Histórico 4\n" +
							"5 - Histórico 5\n" +
							"6 - Voltar\n" +
							"--------------------\n" +
							"Selecione uma compra para ser detalhada (digite 0 para voltar)\n" +
							"Sua Opção: ");
			op = scan.nextInt();

			switch (op) {
				case 1, 2, 3, 4, 5 -> this.detalharCompraHistorico(scan, op);
				case 6 -> this.catalogo(scan);
				default -> System.out.println("Opção Inválida, tente novamente!");
			}

		} while (op < 1 || op > 5);
	}

	public ArrayList<ItemCompra> detalharCompra(Scanner scan, Integer compraID) {
		System.out.println();
		System.out.println("--- Listinha de Compras Adorável ---");
		ArrayList<ItemCompra> itens = ItemCompraService.listaItensDaCompra(this.compra.getId());
		Produto produto = null;

		for (int i = 1; i < itens.size() + 1;i++) {
			produto = itens.get(i -1).getProduto();
			System.out.println(i + " - Produto: " + itens.get(i - 1).toString());
		}
		if (itens.size() != 0) System.out.println("Valor total da sua compra: " + itens.get(0).getCompra().getValor());
		return itens;
}

	public void detalharCompraHistorico(Scanner scan, Integer compraID) {
		this.detalharCompra(scan, compraID);
		int op;
		do {
			System.out.print(
					"--------------------\n" +
							"1 - Refazer compra\n" +
							"2 - Voltar\n" +
							"--------------------\n" +
							"Sua Opção: ");
			op = scan.nextInt();

			switch (op) {
				case 1 -> this.refazerCompra(scan, op);
				case 2 -> this.historico(scan);
				default -> System.out.println("Opção Inválida, tente novamente!");
			}

		} while (op < 1 || op > 2);
	}

	public void refazerCompra(Scanner scan, Integer compraID) {
		// Refazer compra
		this.carrinho(scan);
	}

	public void carrinho(Scanner scan) {
		// Mostrar compra atual
		ArrayList<ItemCompra> lista = this.detalharCompra(scan, 1);
		int op;
		do {
			System.out.print(
					"--------------------\n" +
							"1 - Limpar lista\n" +
							"2 - Editar Item\n" +
							"3 - Finalizar Compra\n" +
							"4 - Voltar ao Menu Principal\n" +
							"--------------------\n" +
							"Sua Opção: ");
			op = scan.nextInt();

			switch (op) {

				case 1 -> this.limparLista(scan, compra.getId());
				case 2 -> this.editarItem(scan, lista);
				case 3 -> this.finalizarCompra(scan);
				case 4 -> this.menuInicial(scan);
				default -> System.out.println("Opção Inválida, tente novamente!");
			}
		} while (op < 1 || op > 4);
	}

	public void limparLista(Scanner scan, Integer ID) {
		// ArrayList<ItemCompra> lista = ItemCompraS
		// Limpar a lista
		System.out.println("Limpando a lista...");
		this.carrinho(scan);
	}

	public void editarItem(Scanner scan, ArrayList<ItemCompra> lista) {
		int op;
		do {
			System.out.print("--------------------\n");
			for (int i = 1; i <= lista.size(); i++) {
				System.out.println(lista.get(i - 1).toString());
			}
			System.out.println("Selecione um item para ver detalhadamente ou editá-lo.");
			op = scan.nextInt();
			if (op > 0 && op <= lista.size()){
				this.selecionarItemCarrinho(scan, lista.get(op - 1));
			} else if (op == lista.size() + 1) {
				this.carrinho(scan);
			} else{
				System.out.println("Opção Inválida, tente novamente!");
			}
		} while (op < 1 || op > lista.size() + 1);
	}



	public void selecionarItemCarrinho(Scanner scan, ItemCompra itemLista) {
		System.out.println(itemLista.getProduto().getDescricao());
		System.out.println(itemLista.getProduto().getValorMedida() + " " + itemLista.getProduto().getUnMedida());
		System.out.println("Valor por unidade: " + itemLista.getProduto().getValor());
		System.out.println("Quantidade comprada: " + itemLista.getQuantidade());
		System.out.println("Valor total: " + (itemLista.getProduto().getValor() * itemLista.getQuantidade()));

		int op;
		do {
			System.out.print("--------------------\n" +
							"1 - Editar quantidade\n" +
							"2 - Remover produto\n" +
							"3 - Voltar\n" +
							"--------------------\n" +
							"Sua Opção: ");
			op = scan.nextInt();

			switch (op) {
				case 1 -> this.alterarQuantidadeItem(scan, itemLista);
				case 2 -> ItemCompraService.excluir(itemLista.getId());
				case 3 -> this.carrinho(scan);
				default -> System.out.println("Opção Inválida, tente novamente!");
			}
		} while (op < 1 || op > 3);

		System.out.println("Voltando ao carrinho...");
		this.carrinho(scan);
	}

	public void alterarQuantidadeItem (Scanner scan, ItemCompra itemLista) {
		int op;
		do {
			System.out.print("--------------------\n");
			System.out.print("Para qunato gostarias de mudar? (0 para voltar): ");
			op = scan.nextInt();
			if (op > 0){
				itemLista.setQuantidade(op);
				ItemCompraService.editar(itemLista);
			} else if (op == 0) {
				this.carrinho(scan);
			} else{
				System.out.println("Opção Inválida, tente novamente!");
			}
		} while (op < 0);
	}

	public void finalizarCompra(Scanner scan) {
		System.out.println("Finalizando processo de compra...");
		int op;
		do {
			System.out.print(
					"--------------------\n" +
							"1 - Continuar compras\n" +
							"2 - Sair\n" +
							"--------------------\n" +
							"Sua Opção: ");
			op = scan.nextInt();

			switch (op) {
				case 1 -> this.menuInicial(scan);
				case 2 -> this.sair();
				default -> System.out.println("Opção Inválida, tente novamente!");
			}
		} while (op < 1 || op > 2);
	}

	public void sair() {
		System.out.println("Obrigado e volte sempre!");
	}

}
