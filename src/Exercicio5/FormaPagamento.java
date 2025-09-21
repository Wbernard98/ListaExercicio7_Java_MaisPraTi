package Exercicio5;

import java.math.BigDecimal;

public abstract class FormaPagamento {

    public abstract void validarPagamento();
    public abstract void processarPagamento(BigDecimal valor);

    // Método não abstrato que pode ser usado pelas subclasses//

    public void exibirRecibo(BigDecimal valor) {
        System.out.println("Recibo de Pagamento:");
        System.out.println("  Valor: R$" + valor);
        System.out.println("  Forma de Pagamento: " + this.getClass().getSimpleName());
    }
}