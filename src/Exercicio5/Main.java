package Exercicio5;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- Cenário 1: Processando Pagamentos Válidos ---");

        List<FormaPagamento> pagamentos = new ArrayList<>();
        pagamentos.add(new CartaoCredito("1234567890123456", "Fulano de Tal"));
        pagamentos.add(new Boleto("000000000000000000000000000000000000000000000"));
        pagamentos.add(new Pix("chavesimples@email.com"));

        BigDecimal valorCompra = new BigDecimal("150.75");

        for (FormaPagamento forma : pagamentos) {
            try {
                System.out.println("\nProcessando pagamento com " + forma.getClass().getSimpleName() + "...");
                forma.processarPagamento(valorCompra);
            } catch (PagamentoInvalidoException e) {
                System.err.println("Erro de validação: " + e.getMessage());
            }
        }

        System.out.println("\n--- Cenário 2: Processando Pagamentos Inválidos ---");

        List<FormaPagamento> pagamentosInvalidos = new ArrayList<>();
        pagamentosInvalidos.add(new CartaoCredito("123", "Ciclano")); // Número de cartão inválido
        pagamentosInvalidos.add(new Boleto("abcde")); // Código de barras inválido
        pagamentosInvalidos.add(new Pix(null)); // Chave Pix nula

        for (FormaPagamento forma : pagamentosInvalidos) {
            try {
                System.out.println("\nTentando processar pagamento com " + forma.getClass().getSimpleName() + " inválido...");
                forma.processarPagamento(valorCompra);
            } catch (PagamentoInvalidoException e) {
                System.err.println("Erro de validação: " + e.getMessage());
            }
        }
    }
}