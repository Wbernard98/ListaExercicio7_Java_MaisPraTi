package Exercicio5;

import java.math.BigDecimal;

public class Pix extends FormaPagamento {

    private String chavePix;

    public Pix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public void validarPagamento() {
        if (chavePix == null || chavePix.trim().isEmpty()) {
            throw new PagamentoInvalidoException("A chave Pix não pode ser nula ou vazia.");
        }
        System.out.println("Chave Pix validada com sucesso.");
    }

    @Override
    public void processarPagamento(BigDecimal valor) {
        validarPagamento();
        System.out.println("Pagamento com Pix processado. Valor: R$" + valor);
        exibirRecibo(valor);
    }
}
