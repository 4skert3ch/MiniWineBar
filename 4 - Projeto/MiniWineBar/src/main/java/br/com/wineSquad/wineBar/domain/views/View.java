package main.java.br.com.wineSquad.wineBar.domain.views;

import java.util.Scanner;

public class View {
	public void menuInicial(Scanner scan) {
		int op = -1;
		do {
			System.out.print(
					"--------------------\n" +
					"1 - Catálogo\n" +
					"2 - Histórico\n" +
					"3 - Carrinho\n" +
					"4 - Sair\n" +
					"--------------------\n" +
					"Sua Opção: ");
			op = scan.nextInt();
			
			switch(op) {
			 case 1: this.catalogo(scan); break;
			 case 2: this.historico(scan); break;
			 case 3: this.carrinho(scan); break;
			 case 4: this.sair(); break;
			 default: System.out.println("Opção Inválida, tente novamente!");
				 
			}
			
		} while (op < 1 || op > 4);
	}
	
	public void catalogo(Scanner scan) {
		int op = -1;
		do {
			System.out.print(
					"--------------------\n" +
					"1 - Sugestões\n" +
					"2 - Pesquisa por Texto\n" +
					"3 - Pesquisa por Categoria\n" +
					"4 - Carrinho\n" +
					"5 - Voltar\n" +
					"--------------------\n" +
					"Sua Opção: ");
			op = scan.nextInt();
			
			switch(op) {
			 case 1: this.sugestoes(scan); break;
			 case 2: this.pesquisaTexto(scan); break;
			 case 3: this.pesquisaCategoria(scan); break;
			 case 4: this.carrinho(scan); break;
			 case 5: this.menuInicial(scan); break;
			 default: System.out.println("Opção Inválida, tente novamente!");
				 
			}
			
		} while (op < 1 || op > 5);
	}
	
	public void sugestoes(Scanner scan) {
		int op = -1;
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
			
			switch(op) {
			 case 1: 
			 case 2: 
			 case 3: 
			 case 4: 
			 case 5: this.selecionarItem(scan, op); break;
			 case 6: this.catalogo(scan); break;
			 default: System.out.println("Opção Inválida, tente novamente!");
				 
			}
			
		} while (op < 1 || op > 5);
	}

	public void selecionarItem(Scanner scan, Integer ID) {
		int op = -1;
		do {
			System.out.print(
				"--------------------\n" +
				"Produto tal, valor tal, digite a quantidade que gostarias de comprar (Digite 0 para voltar)\n"
			);
			op = scan.nextInt();
			if (op > 0){
				// Colocar item
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

	}

	public void pesquisaCategoria(Scanner scan) {
		int op = -1;
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

			switch(op) {
				case 1:
				case 2:
				case 3:
				case 4:
				case 5: this.selecionarItem(scan, op); break;
				case 6: this.catalogo(scan); break;
				default: System.out.println("Opção Inválida, tente novamente!");

			}

		} while (op < 1 || op > 5);
	}

	public void historico(Scanner scan) {

	}

	public void detalharCompra(Scanner scan) {

	}

	public void refazerCompra(Scanner scan) {

	}

	public void carrinho(Scanner scan) {

	}

	public void editarItem(Scanner scan, Integer ID) {

	}

	public void selecionarItemHistorico(Scanner scan) {

	}

	public void finalizarCompra(Scanner scan) {
		System.out.println("Finalizando processo de compra...");
	}

	public void sair() {
		System.out.println("Obrigado e volte sempre!");
	}

}
