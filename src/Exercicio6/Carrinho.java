package Exercicio6;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Carrinho {
    private final List<ItemCarrinho> itens;
    private final BigDecimal percentualCupom;
    private final Moeda moeda;

    public Carrinho(Moeda moeda) {
        this(new ArrayList<>(), BigDecimal.ZERO, moeda);
    }

    private Carrinho(List<ItemCarrinho> itens, BigDecimal percentualCupom, Moeda moeda) {
        this.itens = Collections.unmodifiableList(new ArrayList<>(itens));
        this.percentualCupom = percentualCupom;
        this.moeda = moeda;
    }

    public Carrinho adicionarItem(ItemCarrinho item) {
        List<ItemCarrinho> novaLista = new ArrayList<>(this.itens);
        novaLista.add(item);
        return new Carrinho(novaLista, this.percentualCupom, this.moeda);
    }

    public Carrinho removerItem(Produto produto) {
        List<ItemCarrinho> novaLista = new ArrayList<>();
        for (ItemCarrinho item : this.itens) {
            if (!item.getProduto().equals(produto)) {
                novaLista.add(item);
            }
        }
        return new Carrinho(novaLista, this.percentualCupom, this.moeda);
    }

    public Carrinho aplicarCupom(BigDecimal porcentagem) {
        if (porcentagem == null || porcentagem.compareTo(BigDecimal.ZERO) < 0 || porcentagem.compareTo(new BigDecimal("30")) > 0) {
            throw new IllegalArgumentException("A porcentagem de cupom deve estar entre 0% e 30%.");
        }
        return new Carrinho(this.itens, porcentagem.divide(new BigDecimal("100")), this.moeda);
    }

    public Dinheiro calcularTotalBruto() {
        Dinheiro total = new Dinheiro(BigDecimal.ZERO, this.moeda);
        for (ItemCarrinho item : this.itens) {
            total = total.somar(item.getSubtotal());
        }
        return total;
    }

    public Dinheiro calcularTotalComDesconto() {
        Dinheiro totalBruto = calcularTotalBruto();
        BigDecimal valorDesconto = totalBruto.getValor().multiply(percentualCupom);
        BigDecimal totalComDesconto = totalBruto.getValor().subtract(valorDesconto);

        return new Dinheiro(totalComDesconto, this.moeda);
    }

    public void imprimirCarrinho() {
        System.out.println("--- Carrinho de Compras ---");
        itens.forEach(System.out::println);
        System.out.println("---------------------------");
        System.out.println("Total Bruto: " + calcularTotalBruto());
        System.out.println("Cupom de Desconto: " + (percentualCupom.multiply(new BigDecimal("100"))) + "%");
        System.out.println("Total Final: " + calcularTotalComDesconto());
        System.out.println("---------------------------");
    }
}
