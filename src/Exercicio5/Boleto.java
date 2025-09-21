package Exercicio5;

import java.math.BigDecimal;

public class Boleto extends FormaPagamento {

    private String codigoBarras;

    public Boleto(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    public void validarPagamento() {
        if (codigoBarras == null || codigoBarras.length() != 47) {
            throw new PagamentoInvalidoException("Código de barras do boleto inválido. Deve ter 47 dígitos.");
        }
        System.out.println("Boleto validado com sucesso.");
    }

    @Override
    public void processarPagamento(BigDecimal valor) {
        validarPagamento();
        System.out.println("Pagamento com boleto gerado. Valor: R$" + valor);
        exibirRecibo(valor);
    }
}
