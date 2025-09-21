package Exercicio8;

import java.math.BigDecimal;

@FunctionalInterface
public interface CalculoFreteStrategy {
    BigDecimal calcular(String cepOrigem, String cepDestino, BigDecimal peso);
}
