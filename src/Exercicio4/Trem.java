package Exercicio4;
public class Trem implements IMeioTransporte {

    private int velocidadeAtual = 0;
    private static final int VELOCIDADE_MAXIMA = 150;

    @Override
    public void acelerar() {
        if (velocidadeAtual >= VELOCIDADE_MAXIMA) {
            throw new IllegalStateException("O trem já está na velocidade máxima.");
        }
        velocidadeAtual += 25;
        System.out.println("Trem acelerando... Velocidade atual: " + velocidadeAtual + " km/h");
    }

    @Override
    public void frear() {
        if (velocidadeAtual <= 0) {
            throw new IllegalStateException("O trem já está parado.");
        }
        velocidadeAtual -= 20;
        if (velocidadeAtual < 0) {
            velocidadeAtual = 0;
        }
        System.out.println("Trem freando... Velocidade atual: " + velocidadeAtual + " km/h");
    }
}
