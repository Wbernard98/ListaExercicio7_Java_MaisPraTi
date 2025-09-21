# Lista de Exercícios de POO em Java

Este repositório contém uma série de exercícios práticos em Java focados nos pilares e padrões de design da **Programação Orientada a Objetos (POO)**. Os exercícios foram desenvolvidos para demonstrar e reforçar conceitos como encapsulamento, herança, polimorfismo, abstração e genéricos.

## 🚀 Conceitos Abordados

Cada exercício foi projetado para focar em um ou mais princípios de POO:

- **Exercício 1: Encapsulamento (Classe `Produto`)**
  - Demonstra o uso de atributos privados, **getters** e **setters** com validações para garantir a integridade dos dados.

- **Exercício 2: Encapsulamento com Validação de Regra**
  - Estende o conceito de encapsulamento, adicionando uma regra de negócio (`aplicarDesconto`) com validação e tratamento de exceções.

- **Exercício 3: Herança (Hierarquia de Funcionários)**
  - Explora a criação de uma hierarquia de classes (`Funcionario`, `Gerente`, `Desenvolvedor`) e a aplicação de **polimorfismo** através da sobrescrita de métodos.

- **Exercício 4: Polimorfismo com Interface (`IMeioTransporte`)**
  - Demonstra o polimorfismo através de interfaces, permitindo que diferentes classes (`Carro`, `Bicicleta`, `Trem`) sigam um mesmo contrato.

- **Exercício 5: Abstração (Sistema de Pagamentos)**
  - Utiliza uma **classe abstrata** (`FormaPagamento`) para definir um modelo de comportamento, com subclasses concretas para implementar a lógica específica.

- **Exercício 6: Imutabilidade e Objetos de Valor (`Carrinho de Compras`)**
  - Foca na criação de **objetos imutáveis** (`Dinheiro`, `Carrinho`) onde as operações retornam novas instâncias, garantindo segurança e previsibilidade do estado.

- **Exercício 7: Generics (Repositório Genérico em Memória)**
  - Mostra o poder dos **generics** para criar um repositório reutilizável (`InMemoryRepository`) que pode gerenciar qualquer tipo de entidade.

- **Exercício 8: Padrão Strategy (Cálculo de Frete com Lambdas)**
  - Implementa o **padrão de design Strategy** usando **lambdas** para permitir a troca de algoritmos de forma dinâmica em tempo de execução.

## 💻 Como Executar

Para rodar os projetos, você precisará de um ambiente de desenvolvimento Java (JDK 8 ou superior) e uma IDE como o **IntelliJ IDEA**.

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/**seu-usuario**/**nome-do-repositorio**.git](https://github.com/**seu-usuario**/**nome-do-repositorio**.git)
    ```
2.  **Abra o projeto no IntelliJ:**
    - No IntelliJ, selecione "Open" e navegue até a pasta do repositório.
    - A IDE irá importar o projeto automaticamente.
3.  **Execute a classe `Main`:**
    - Cada exercício tem uma classe `Main` correspondente dentro de sua respectiva pasta.
    - Clique com o botão direito na classe `Main.java` desejada e selecione `Run 'Main.main()'` para ver o resultado no console.

## 📄 Licença

Este projeto está licenciado sob a Licença **MIT**.

---
*Este README foi gerado para o projeto de **seus-exercicios-poo-java**.*
