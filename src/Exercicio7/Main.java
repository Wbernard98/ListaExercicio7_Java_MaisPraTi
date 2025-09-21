package Exercicio7;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- Repositório de Produtos ---");

        IRepository<Produto, Integer> repoProdutos = new InMemoryRepository<>();

        Produto tv = new Produto(1, "Smart TV");
        Produto fone = new Produto(2, "Fone de Ouvido");

        repoProdutos.salvar(tv);
        repoProdutos.salvar(fone);

        // Buscar e exibir um produto
        Optional<Produto> produtoEncontrado = repoProdutos.buscarPorId(1);
        produtoEncontrado.ifPresent(p -> System.out.println("Produto encontrado: " + p));

        // Listar todos os produtos
        System.out.println("\nTodos os produtos:");
        List<Produto> todosProdutos = repoProdutos.listarTodos();
        todosProdutos.forEach(System.out::println);

        // Remover um produto
        System.out.println("\nRemovendo produto com ID 2...");
        repoProdutos.remover(2);

        System.out.println("Lista após a remoção:");
        repoProdutos.listarTodos().forEach(System.out::println);

        // Tentar remover um produto que não existe
        try {
            System.out.println("\nTentando remover um produto inexistente (ID 99)...");
            repoProdutos.remover(99);
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Erro: " + e.getMessage());
        }

        System.out.println("\n--- Repositório de Funcionários ---");

        IRepository<Funcionario, String> repoFuncionarios = new InMemoryRepository<>();

        Funcionario gerente = new Funcionario("g-101", "Ana Costa");
        Funcionario dev = new Funcionario("d-202", "Bruno Silva");

        repoFuncionarios.salvar(gerente);
        repoFuncionarios.salvar(dev);

        // Listar todos os funcionários
        System.out.println("\nTodos os funcionários:");
        repoFuncionarios.listarTodos().forEach(System.out::println);

        // Remover um funcionário
        System.out.println("\nRemovendo funcionário com ID g-101...");
        repoFuncionarios.remover("g-101");

        System.out.println("Lista após a remoção:");
        repoFuncionarios.listarTodos().forEach(System.out::println);
    }
}
