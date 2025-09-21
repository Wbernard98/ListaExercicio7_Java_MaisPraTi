package Exercicio1_2;

public class Produto {

    private String nome;
    private double preco;
    private int quantidadeEmEstoque;

    public Produto(String nome, double preco, int quantidadeEmEstoque) {
        setNome(nome);
        setPreco(preco);
        setQuantidadeEmEstoque(quantidadeEmEstoque);
    }

    // Getters

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    // Setters com validações

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do produto não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("O preço do produto não pode ser negativo.");
        }
        this.preco = preco;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        if (quantidadeEmEstoque < 0) {
            throw new IllegalArgumentException("A quantidade em estoque não pode ser negativa.");
        }
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    // Novo método:aplicarDesconto
    // Ex 2 incluindo desconto
    public void aplicarDesconto(double porcentagem) {
        if (porcentagem < 0 || porcentagem > 50) {
            throw new IllegalArgumentException("A porcentagem de desconto deve estar entre 0 e 50 (inclusive).");
        }
        this.preco = this.preco * (1 - porcentagem / 100);
    }

    @Override
    public String toString() {
        return "Exercicio1_2.Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + String.format("%.2f", preco) +
                ", quantidadeEmEstoque=" + quantidadeEmEstoque +
                '}';
    }

    public static class Main {
       public static void main(String[] args) {
           // Cenário 1: Aplicação de um desconto válido (20%)
           System.out.println("--- Cenário 1: Aplicação de desconto válido ---");
           try {
               Produto smartphone = new Produto("Smartphone Galaxy", 1500.00, 50);
               System.out.println("Preço original: R$" + smartphone.getPreco());

               double descontoValido = 20;
               smartphone.aplicarDesconto(descontoValido);

               System.out.println("Aplicando " + descontoValido + "% de desconto...");
               System.out.println("Novo preço: R$" + String.format("%.2f", smartphone.getPreco()));
               System.out.println("----------------------------------------------\n");

           } catch (IllegalArgumentException e) {
               System.err.println("Erro: " + e.getMessage());
           }

           // Cenário 2: Tentativa de aplicar um desconto inválido (60%)
           System.out.println("--- Cenário 2: Tentativa de desconto inválido ---");
           try {
               Produto notebook = new Produto("Notebook Gamer", 4000.00, 15);
               System.out.println("Preço original: R$" + notebook.getPreco());

               double descontoInvalido = 60;
               System.out.println("Tentando aplicar " + descontoInvalido + "% de desconto...");
               notebook.aplicarDesconto(descontoInvalido);

           } catch (IllegalArgumentException e) {
               System.err.println("Erro ao aplicar desconto: " + e.getMessage());
               System.out.println("O preço do notebook não foi alterado.");
               System.out.println("----------------------------------------------\n");
           }

           // Cenário 3: Tentativa de aplicar um desconto negativo
           System.out.println("--- Cenário 3: Tentativa de desconto negativo ---");
           try {
               Produto foneDeOuvido = new Produto("Fone de Ouvido Bluetooth", 120.00, 30);
               System.out.println("Preço original: R$" + foneDeOuvido.getPreco());

               double descontoNegativo = -5;
               System.out.println("Tentando aplicar " + descontoNegativo + "% de desconto...");
               foneDeOuvido.aplicarDesconto(descontoNegativo);
           } catch (IllegalArgumentException e) {
               System.err.println("Erro ao aplicar desconto: " + e.getMessage());
               System.out.println("O preço do fone de ouvido não foi alterado.");
               System.out.println("----------------------------------------------\n");
           }
       }
   }
}