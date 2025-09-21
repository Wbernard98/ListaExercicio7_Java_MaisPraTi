package Exercicio1_2;

public class Main {
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