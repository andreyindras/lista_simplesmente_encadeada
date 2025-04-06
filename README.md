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

### 📄 2. Leitura de dados com `LeitorArquivo`

Antes de inserir os pontos na lista, o programa realiza a leitura do arquivo `pontos_de_descartes.txt`. Cada linha do arquivo representa um ponto de descarte e contém seus dados separados por vírgula:

```java
String[] partes = linha.split(",");
```

A partir dessas partes (`id`, `endereco`, `material`), um novo objeto `PontoDescarte` é criado e enviado para inserção na lista encadeada.

Esse processo garante que os dados sejam tratados de forma estruturada e dinâmica, sem depender de coleções prontas.

---

### 🔧 3. Construção dinâmica da lista com `ListaSimplesmenteEncadeada`

Para armazenar os pontos de descarte, foi implementada manualmente uma **lista simplesmente encadeada** — uma estrutura onde **cada elemento aponta para o próximo**, formando uma sequência de nós.

---

#### 🧱 Estrutura da lista

A lista é composta por objetos da classe `PontoDescarte`, que contêm:

- Informações do ponto (ID, endereço, material)
- Um **ponteiro para o próximo ponto** da lista (`proximo`)

---

#### ➕ Como funciona a inserção?

A lógica de inserção segue dois cenários:

1. **Lista vazia** (`inicio == null`)
   - O novo ponto é inserido como o primeiro elemento da lista.
   - O ponteiro `inicio` passa a referenciar esse novo nó.

2. **Lista com elementos**
   - Percorremos a lista **do início até encontrar o último nó**, ou seja, aquele cujo campo `proximo` é `null`.
   - O novo ponto é então **ligado como o próximo nó** do último elemento da lista.

#### 🧠 Código da inserção:

```java
public void inserir(String id, String endereco, String material) {
    PontoDescarte novo = new PontoDescarte(id, endereco, material);

    if (inicio == null) {
        inicio = novo; // lista vazia → novo nó vira o primeiro
    } else {
        PontoDescarte temp = inicio;
        while (temp.proximo != null) {
            temp = temp.proximo; // percorre até o final
        }
        temp.proximo = novo; // insere no final
    }
}
```

---

#### 🔄 Exemplo visual (inserindo 3 pontos):

```text
[inicio] → [Ponto 1] → [Ponto 2] → [Ponto 3] → null
```

Cada novo ponto é adicionado ao final, **mantendo a ordem de chegada** e criando uma sequência conectada.

---

#### 📌 Vantagens dessa abordagem:

- **Não há limite fixo de tamanho**, como acontece em arrays tradicionais.
- A memória é alocada sob demanda, conforme novos elementos são inseridos.
- Ajuda a compreender conceitos fundamentais de estruturas de dados, como ponteiros e encadeamento.

---

### 🔍 4. Filtragem com base no material

Após o usuário escolher o tipo de material que deseja buscar (Plástico, Vidro ou Eletrônicos), o programa precisa **procurar dentro da lista apenas os pontos de descarte que aceitam esse material específico**.

#### 📌 Como isso funciona?

A lista foi construída como uma **lista simplesmente encadeada**, ou seja, cada elemento da lista (cada `PontoDescarte`) aponta para o próximo.

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

### 🧑‍💻 5. Interação com o usuário em `Main`

O fluxo principal do programa segue os seguintes passos:

- Leitura do arquivo com os pontos de descarte.
- Apresentação de um menu simples para o usuário.
- Conversão da opção numérica para o material correspondente.
- Filtragem e exibição dos pontos compatíveis com o material escolhido.

A lógica aqui se resume a **coletar uma entrada do usuário** e repassar essa informação como critério para buscar na lista.

---

## 🔄 Fluxo Lógico Resumido

```text
Arquivo .txt
   ↓
Leitura linha a linha
   ↓
Criação de objetos PontoDescarte
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

Essa abordagem ajuda a desenvolver uma base sólida em **estruturas de dados**, essencial para programadores que desejam compreender o funcionamento interno das coleções de forma mais profunda.
