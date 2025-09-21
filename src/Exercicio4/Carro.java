package Exercicio4;

public class Carro implements IMeioTransporte {

    private int velocidadeAtual = 0;
    private static final int VELOCIDADE_MAXIMA = 200;

    @Override
    public void acelerar() {
        if (velocidadeAtual >= VELOCIDADE_MAXIMA) {
            throw new IllegalStateException("O carro já está na velocidade máxima.");
        }
        velocidadeAtual += 10;
        System.out.println("Carro acelerando... Velocidade atual: " + velocidadeAtual + " km/h");
    }

    @Override
    public void frear() {
        if (velocidadeAtual <= 0) {
            throw new IllegalStateException("O carro já está parado.");
        }
        velocidadeAtual -= 15;
        if (velocidadeAtual < 0) {
            velocidadeAtual = 0;
        }
        System.out.println("Carro freando... Velocidade atual: " + velocidadeAtual + " km/h");
    }
}