# ♻️ Sistema de Consulta de Pontos de Descarte

Este projeto em Java foi desenvolvido com o objetivo de simular um sistema de **busca de locais de descarte de materiais recicláveis**, utilizando como estrutura de dados uma **lista simplesmente encadeada**.

A lógica principal consiste em **ler dados de um arquivo**, armazená-los dinamicamente em uma lista, e permitir que o usuário busque os pontos de descarte de acordo com o **tipo de material desejado**.

---

## 🧠 Lógica do Funcionamento

### 1. **Modelagem dos dados com `PontoDescarte`**

Cada ponto de descarte é representado por um **objeto da classe `PontoDescarte`**, que contém três informações principais:

- `id`: Identificador único do ponto.
- `endereco`: Endereço onde se encontra o ponto de descarte.
- `material`: Tipo de material aceito (Plástico, Vidro ou Eletrônicos).
- `proximo`: Referência para o **próximo ponto** da lista (nó seguinte).

Essa estrutura forma a **base da lista encadeada**.

---

### 2. **Construção dinâmica da lista com `ListaSimplesmenteEncadeada`**

Ao invés de usar uma estrutura de dados pronta como um `ArrayList`, foi implementada manualmente uma **lista encadeada**, onde cada elemento aponta para o próximo.

A lógica de inserção é a seguinte:

- Se a lista estiver **vazia**, o novo ponto vira o início (`inicio`).
- Caso contrário, percorremos a lista até o final e **inserimos o novo ponto ao final**.

Isso permite adicionar elementos de forma sequencial sem limite de tamanho definido previamente.

---

### 3. **Leitura de dados com `LeitorArquivo`**

A leitura do arquivo `pontos_de_descartes.txt` é feita linha por linha. Cada linha é dividida em três partes:

```java
String[] partes = linha.split(",");
```

A partir dessas partes, criamos um novo `PontoDescarte` e **o inserimos na lista**.

Aqui, a lógica importante é que os dados não são armazenados em listas prontas, mas sim na **estrutura encadeada criada anteriormente**.

---

### 🔍 4. Filtragem com base no material

Após o usuário escolher o tipo de material que deseja buscar (Plástico, Vidro ou Eletrônicos), o programa precisa **procurar dentro da lista apenas os pontos de descarte que aceitam esse material específico**.

#### 📌 Como isso funciona?

A lista de pontos de descarte foi construída como uma **lista simplesmente encadeada**, ou seja, cada elemento da lista (cada `PontoDescarte`) aponta para o próximo, formando uma cadeia de elementos.

Para fazer a filtragem, usamos um **laço `while`** que percorre a lista do início até o fim, verificando o valor do campo `material` de cada nó.

#### 💡 Lógica aplicada:

```java
PontoDescarte temp = inicio;

while (temp != null) {
    if (temp.material.equals(materialBusca)) {
        // exibe as informações do ponto
    }
    temp = temp.proximo;
}
```

#### 🔄 O que acontece aqui, passo a passo:

1. A variável `temp` começa apontando para o primeiro elemento da lista (`inicio`).
2. O laço `while` continua enquanto `temp` não for `null` (ou seja, enquanto não chegarmos ao fim da lista).
3. Em cada iteração:
   - Verificamos se o `material` do ponto atual é **igual ao material escolhido pelo usuário**.
   - Se for igual, **exibimos as informações** daquele ponto (ID, Endereço e Material).
   - Se for diferente, apenas seguimos para o próximo nó (`temp = temp.proximo`).
4. O processo continua até percorrer todos os pontos cadastrados na lista.

---

### 5. **Interação com o usuário em `Main`**

O fluxo principal é guiado por:

- Leitura do arquivo com os pontos de descarte.
- Apresentação de um menu simples para o usuário.
- Conversão da opção numérica para o material correspondente.
- Exibição dos pontos filtrados.

A lógica aqui se resume a **coletar uma entrada do usuário** e repassar essa informação como critério para filtrar a lista.

---

## 🔄 Fluxo Lógico Resumido

```text
Arquivo .txt
   ↓
Leitura linha a linha
   ↓
Inserção em uma lista encadeada
   ↓
Usuário escolhe tipo de material
   ↓
Percorre a lista e exibe apenas os pontos que aceitam o material escolhido
```

---

## 🎯 Por que usar lista encadeada?

A opção por uma **lista simplesmente encadeada** foi feita com fins didáticos, para reforçar os conceitos de:

- Alocação dinâmica de memória
- Encadeamento de elementos
- Percurso sequencial
- Estrutura de nós interligados
