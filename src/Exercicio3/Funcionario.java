package Exercicio3;

import java.math.BigDecimal;

public abstract class Funcionario {

    protected String nome;
    protected BigDecimal salario;

    public Funcionario(String nome, BigDecimal salario) {
        if (salario.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O salário não pode ser negativo.");
        }
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    // Método abstrato que será implementado pelas subclasses
    public abstract BigDecimal calcularBonus();

    @Override
    public String toString() {
        return "Nome: " + nome + ", Salário: R$" + salario;
    }
}