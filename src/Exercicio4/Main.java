package Exercicio4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- Cenário 1: Demonstração de Polimorfismo ---");

        List<IMeioTransporte> veiculos = new ArrayList<>();
        veiculos.add(new Carro());
        veiculos.add(new Bicicleta());
        veiculos.add(new Trem());

        // Acelerando todos os veículos
        System.out.println("\n--- Acelerando todos os veículos ---");
        for (IMeioTransporte veiculo : veiculos) {
            veiculo.acelerar();
            veiculo.acelerar();
        }

        // Freando todos os veículos
        System.out.println("\n--- Freando todos os veículos ---");
        for (IMeioTransporte veiculo : veiculos) {
            veiculo.frear();
        }

        // Cenário 2: Tratando operações inválidas
        System.out.println("\n--- Cenário 2: Tentando operação inválida ---");

        Carro carroDeTeste = new Carro();
        System.out.println("Acelerando carro até o limite...");
        // Acelera 20 vezes para atingir o limite de 200 km/h
        for (int i = 0; i < 20; i++) {
            carroDeTeste.acelerar();
        }

        try {
            System.out.println("\nTentando acelerar o carro acima da velocidade máxima...");
            carroDeTeste.acelerar();
        } catch (IllegalStateException e) {
            System.err.println("Erro: " + e.getMessage());
        }

        try {
            System.out.println("\nTentando frear um carro que já está parado...");
            carroDeTeste.frear(); // Carro está a 200 km/h
            for (int i = 0; i < 15; i++) {
                carroDeTeste.frear();
            }
            carroDeTeste.frear();
        } catch (IllegalStateException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
