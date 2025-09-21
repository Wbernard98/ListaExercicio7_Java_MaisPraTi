package Exercicio7;

import java.util.*;

public class InMemoryRepository<T extends Identificavel<ID>, ID> implements IRepository<T, ID> {

    private final Map<ID, T> bancoDeDados = new HashMap<>();

    @Override
    public T salvar(T entidade) {
        bancoDeDados.put(entidade.getId(), entidade);
        return entidade;
    }

    @Override
    public Optional<T> buscarPorId(ID id) {
        return Optional.ofNullable(bancoDeDados.get(id));
    }

    @Override
    public List<T> listarTodos() {
        return Collections.unmodifiableList(new ArrayList<>(bancoDeDados.values()));
    }

    @Override
    public void remover(ID id) {
        if (!bancoDeDados.containsKey(id)) {
            throw new EntidadeNaoEncontradaException("Entidade com ID " + id + " não encontrada para remoção.");
        }
        bancoDeDados.remove(id);
    }
}