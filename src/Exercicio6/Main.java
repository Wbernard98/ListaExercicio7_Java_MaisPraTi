package Exercicio6;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Criando produtos e carrinho ---");
        Dinheiro precoTV = new Dinheiro(new BigDecimal("2500.00"), Moeda.BRL);
        Dinheiro precoFone = new Dinheiro(new BigDecimal("150.00"), Moeda.BRL);

        Produto tv = new Produto("Smart TV 50\"", precoTV);
        Produto fone = new Produto("Fone Bluetooth", precoFone);

        Carrinho carrinho = new Carrinho(Moeda.BRL);
        carrinho.imprimirCarrinho();

        System.out.println("\n--- Adicionando itens ---");
        // Adiciona um item e retorna um NOVO carrinho
        Carrinho carrinhoComItens = carrinho
                .adicionarItem(new ItemCarrinho(tv, 1))
                .adicionarItem(new ItemCarrinho(fone, 2));

        carrinhoComItens.imprimirCarrinho();

        System.out.println("\n--- Aplicando cupom de 15% ---");
        // Aplica o cupom e retorna um NOVO carrinho
        Carrinho carrinhoComDesconto = carrinhoComItens.aplicarCupom(new BigDecimal("15"));
        carrinhoComDesconto.imprimirCarrinho();

        System.out.println("\n--- Removendo a TV do carrinho ---");
        // Remove um item e retorna um NOVO carrinho
        Carrinho carrinhoFinal = carrinhoComDesconto.removerItem(tv);
        carrinhoFinal.imprimirCarrinho();

        System.out.println("\n--- Validando entradas inválidas ---");
        try {
            // Tenta adicionar item com quantidade zero
            carrinhoComItens.adicionarItem(new ItemCarrinho(tv, 0));
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao adicionar item: " + e.getMessage());
        }

        try {
            // Tenta aplicar um cupom inválido
            carrinhoComDesconto.aplicarCupom(new BigDecimal("40"));
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao aplicar cupom: " + e.getMessage());
        }
    }
}
