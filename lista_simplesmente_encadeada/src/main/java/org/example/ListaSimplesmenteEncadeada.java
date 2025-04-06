package org.example;

public class ListaSimplesmenteEncadeada {
    private PontoDescarte inicio;

    public void inserir(String id, String endereco, String material) {
        PontoDescarte novo = new PontoDescarte(id, endereco, material);

        if (inicio == null) {
            inicio = novo;
        } else {
            PontoDescarte temp = inicio;
            while (temp.proximo != null) {
                temp = temp.proximo;
            }
            temp.proximo = novo;
        }
    }

    public void exibirLista(String materialBusca) {
        PontoDescarte temp = inicio;

        while (temp != null) {
            if (temp.material.equals(materialBusca)) {
                System.out.println("ID: " + temp.id);
                System.out.println("Endereço: " + temp.endereco);
                System.out.println("Material: " + temp.material);
                System.out.println();
            }
            temp = temp.proximo;
        }
    }
}
