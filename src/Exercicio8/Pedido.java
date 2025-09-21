package Exercicio8;

import java.math.BigDecimal;

public class Pedido {

    private String cepOrigem;
    private String cepDestino;
    private BigDecimal peso;
    private CalculoFreteStrategy freteStrategy;

    public Pedido(String cepOrigem, String cepDestino, BigDecimal peso, CalculoFreteStrategy freteStrategy) {
        ValidadorCep.validar(cepOrigem);
        ValidadorCep.validar(cepDestino);

        if (peso.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O peso não pode ser negativo.");
        }

        this.cepOrigem = cepOrigem;
        this.cepDestino = cepDestino;
        this.peso = peso;
        this.freteStrategy = freteStrategy;
    }

    // Método para injetar/trocar a estratégia em tempo de execução
    public void setFreteStrategy(CalculoFreteStrategy freteStrategy) {
        this.freteStrategy = freteStrategy;
    }

    public BigDecimal getValorFrete() {
        return freteStrategy.calcular(cepOrigem, cepDestino, peso);
    }
}