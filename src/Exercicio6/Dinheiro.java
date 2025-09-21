package Exercicio6;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public final class Dinheiro {

    private final BigDecimal valor;
    private final Moeda moeda;

    public Dinheiro(BigDecimal valor, Moeda moeda) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O valor do dinheiro não pode ser nulo ou negativo.");
        }
        this.valor = valor.setScale(2, RoundingMode.HALF_UP);
        this.moeda = Objects.requireNonNull(moeda);
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Moeda getMoeda() {
        return moeda;
    }

    public Dinheiro somar(Dinheiro outro) {
        if (this.moeda != outro.moeda) {
            throw new IllegalArgumentException("Não é possível somar moedas diferentes.");
        }
        return new Dinheiro(this.valor.add(outro.valor), this.moeda);
    }

    public Dinheiro subtrair(Dinheiro outro) {
        if (this.moeda != outro.moeda) {
            throw new IllegalArgumentException("Não é possível subtrair moedas diferentes.");
        }
        BigDecimal resultado = this.valor.subtract(outro.valor);
        if (resultado.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("A subtração resultou em um valor negativo.");
        }
        return new Dinheiro(resultado, this.moeda);
    }

    public Dinheiro multiplicar(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade não pode ser negativa.");
        }
        return new Dinheiro(this.valor.multiply(new BigDecimal(quantidade)), this.moeda);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dinheiro dinheiro = (Dinheiro) o;
        return valor.equals(dinheiro.valor) && moeda == dinheiro.moeda;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, moeda);
    }

    @Override
    public String toString() {
        return "R$" + valor;
    }
}