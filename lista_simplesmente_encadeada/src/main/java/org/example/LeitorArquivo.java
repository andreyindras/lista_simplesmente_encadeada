package org.example;

import java.io.BufferedReader;
import java.io.FileReader;


public class LeitorArquivo {

    ListaSimplesmenteEncadeada lista = new ListaSimplesmenteEncadeada();
    String path = "pontos_de_descartes.txt";

    public void lerArquivo() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length >= 3) {
                    String id = partes[0].trim();
                    String endereco = partes[1].trim();
                    String material = partes[2].trim();

                    lista.inserir(id, endereco, material);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
