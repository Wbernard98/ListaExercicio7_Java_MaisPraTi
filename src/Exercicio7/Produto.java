package Exercicio7;

public class Produto implements Identificavel<Integer> {
    private final Integer id;
    private String nome;

    public Produto(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}