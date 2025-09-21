package Exercicio4;

public class Bicicleta implements IMeioTransporte {

    private int velocidadeAtual = 0;
    private static final int VELOCIDADE_MAXIMA = 30;

    @Override
    public void acelerar() {
        if (velocidadeAtual >= VELOCIDADE_MAXIMA) {
            throw new IllegalStateException("A bicicleta já está na velocidade máxima.");
        }
        velocidadeAtual += 3;
        System.out.println("Bicicleta acelerando... Velocidade atual: " + velocidadeAtual + " km/h");
    }

    @Override
    public void frear() {
        if (velocidadeAtual <= 0) {
            throw new IllegalStateException("A bicicleta já está parada.");
        }
        velocidadeAtual -= 5;
        if (velocidadeAtual < 0) {
            velocidadeAtual = 0;
        }
        System.out.println("Bicicleta freando... Velocidade atual: " + velocidadeAtual + " km/h");
    }
}