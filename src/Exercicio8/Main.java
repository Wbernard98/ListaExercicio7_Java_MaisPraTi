package Exercicio8;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {

        // Estratégia 1: Frete PAC
        CalculoFreteStrategy pac = (cepOrigem, cepDestino, peso) -> {
            ValidadorCep.validar(cepOrigem); // Revalidando por segurança
            ValidadorCep.validar(cepDestino);
            return peso.multiply(new BigDecimal("0.50")).add(new BigDecimal("15.00"));
        };

        // Estratégia 2: Frete Sedex
        CalculoFreteStrategy sedex = (cepOrigem, cepDestino, peso) -> {
            ValidadorCep.validar(cepOrigem);
            ValidadorCep.validar(cepDestino);
            return peso.multiply(new BigDecimal("1.20")).add(new BigDecimal("25.00"));
        };

        // Estratégia 3: Retirada na Loja
        CalculoFreteStrategy retiradaNaLoja = (cepOrigem, cepDestino, peso) -> {
            if (!cepDestino.startsWith("950")) { // Exemplo de regra específica
                throw new IllegalArgumentException("Retirada na loja disponível apenas para CEPs 950xxxx.");
            }
            return BigDecimal.ZERO;
        };

        // Estratégia 4: Promoção com Lambda (Frete Grátis acima de X)
        BigDecimal valorMinimoParaFreteGratis = new BigDecimal("200.00");
        CalculoFreteStrategy fretePromocional = (cepOrigem, cepDestino, peso) -> {
            BigDecimal precoProduto = new BigDecimal("210.00"); // Simulação do preço do produto
            if (precoProduto.compareTo(valorMinimoParaFreteGratis) > 0) {
                System.out.println("Promoção ativada! Frete grátis.");
                return BigDecimal.ZERO;
            } else {
                return pac.calcular(cepOrigem, cepDestino, peso); // Usa a estratégia padrão como fallback
            }
        };

        // Exemplo de uso e troca de estratégia em tempo de execução
        System.out.println("--- Pedido com Frete PAC ---");
        Pedido pedido1 = new Pedido("12345678", "87654321", new BigDecimal("5.0"), pac);
        System.out.println("Valor do frete (PAC): R$" + pedido1.getValorFrete().setScale(2, RoundingMode.HALF_UP));

        System.out.println("\n--- Troca para Frete SEDEX ---");
        pedido1.setFreteStrategy(sedex); // Troca de estratégia
        System.out.println("Valor do frete (SEDEX): R$" + pedido1.getValorFrete().setScale(2, RoundingMode.HALF_UP));

        System.out.println("\n--- Pedido com Frete Promocional ---");
        Pedido pedido2 = new Pedido("12345678", "87654321", new BigDecimal("5.0"), fretePromocional);
        System.out.println("Valor do frete (Promocional): R$" + pedido2.getValorFrete().setScale(2, RoundingMode.HALF_UP));

        System.out.println("\n--- Cenário de Erro: CEP Inválido ---");
        try {
            new Pedido("123", "87654321", new BigDecimal("2.0"), pac);
        } catch (CepInvalidoException e) {
            System.err.println("Erro: " + e.getMessage());
        }

        System.out.println("\n--- Cenário de Erro: Retirada na loja com CEP inválido ---");
        try {
            Pedido pedido3 = new Pedido("12345678", "11111111", new BigDecimal("1.0"), retiradaNaLoja);
            System.out.println("Frete: R$" + pedido3.getValorFrete().setScale(2, RoundingMode.HALF_UP));
        } catch (IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}