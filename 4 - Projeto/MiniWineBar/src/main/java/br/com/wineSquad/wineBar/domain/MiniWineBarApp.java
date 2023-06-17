package br.com.wineSquad.wineBar.domain;

import br.com.wineSquad.wineBar.domain.views.View;

import java.util.Scanner;

public class MiniWineBarApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        var view = new View();
        view.menuInicial(scan);
        scan.close();
    }
}