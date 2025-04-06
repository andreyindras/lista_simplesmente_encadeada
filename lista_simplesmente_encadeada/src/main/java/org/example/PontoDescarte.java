package org.example;

public class PontoDescarte {
    public String id;
    public String endereco;
    public String material;
    PontoDescarte proximo;

    public PontoDescarte(String id, String endereco, String material) {
        this.id = id;
        this.endereco = endereco;
        this.material = material;
        this.proximo = null;
    }
}