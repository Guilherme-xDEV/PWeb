package com.guilherme.example.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<T, TypeID> {

  T salvar(T entidade);

  Optional<T> buscarPorId(TypeID id);

  List<T> buscarTodos();

  T atualizar(T entidade);

  void remover(TypeID id);
}
