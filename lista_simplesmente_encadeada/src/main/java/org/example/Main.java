package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LeitorArquivo leitor = new LeitorArquivo();
        leitor.lerArquivo();

        System.out.println("Selecione o tipo de material para buscar");
        System.out.println("(1) - Plástico");
        System.out.println("(2) - Vidro");
        System.out.println("(3) - Eletrônicos");
        System.out.print("Opção: ");
        int op = sc.nextInt();
        sc.nextLine();

        String materialBusca = "";
        switch (op) {
            case 1:
                materialBusca = "Plástico";
                break;
            case 2:
                materialBusca = "Vidro";
                break;
            case 3:
                materialBusca = "Eletrônicos";
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }

        leitor.lista.exibirLista(materialBusca);
    }
}