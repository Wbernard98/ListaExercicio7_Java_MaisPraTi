package Exercicio5;

import java.math.BigDecimal;

public class CartaoCredito extends FormaPagamento {

    private String numeroCartao;
    private String titular;

    public CartaoCredito(String numeroCartao, String titular) {
        this.numeroCartao = numeroCartao;
        this.titular = titular;
    }

    @Override
    public void validarPagamento() {
        if (numeroCartao == null || numeroCartao.length() != 16) {
            throw new PagamentoInvalidoException("Número do cartão de crédito inválido. Deve ter 16 dígitos.");
        }
        System.out.println("Cartão de crédito validado com sucesso.");
    }

    @Override
    public void processarPagamento(BigDecimal valor) {
        validarPagamento(); // Chama a validação antes de processar
        System.out.println("Pagamento com cartão de crédito processado. Valor: R$" + valor);
        exibirRecibo(valor);
    }
}
