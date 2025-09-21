package Exercicio3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Cenário 1: Criação e uso de instâncias válidas
        System.out.println("--- Cenário 1: Demonstração de Cálculo de Bônus ---");

        List<Funcionario> funcionarios = new ArrayList<>();

        // Criação de objetos
        Funcionario gerente1 = new Gerente("João", new BigDecimal("8000.00"));
        Funcionario desenvolvedor1 = new Desenvolvedor("Maria", new BigDecimal("5500.00"));
        Funcionario gerente2 = new Gerente("Carlos", new BigDecimal("12000.00"));

        // Adicionando na lista polimórfica
        funcionarios.add(gerente1);
        funcionarios.add(desenvolvedor1);
        funcionarios.add(gerente2);

        // Iterando sobre a lista e exibindo o bônus de cada um
        for (Funcionario f : funcionarios) {
            System.out.println("Funcionário: " + f.getNome());
            System.out.println("Salário: R$" + f.getSalario());
            System.out.println("Bônus: R$" + f.calcularBonus()); // O método correto é chamado automaticamente
            System.out.println("----------------------------------------------");
        }

        // Cenário 2: Tentativa de criar um funcionário com salário inválido
        System.out.println("--- Cenário 2: Tentativa com salário inválido ---");
        try {
            Funcionario gerenteInvalido = new Gerente("Pedro", new BigDecimal("-500.00"));
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao criar funcionário: " + e.getMessage());
        }
    }
}