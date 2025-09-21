package Exercicio3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Gerente extends Funcionario {

    private static final BigDecimal BONUS_PERCENTUAL = new BigDecimal("0.20"); // 20%

    public Gerente(String nome, BigDecimal salario) {
        super(nome, salario);
    }

    @Override
    public BigDecimal calcularBonus() {
        return this.salario.multiply(BONUS_PERCENTUAL).setScale(2, RoundingMode.HALF_UP);
    }
}
