package com.comercio.app.repositories;

import java.util.List;

public interface IBaseRepository<E> {
    public List<E> findAll();
    public E findById(Integer id);
    public void insert(E entity);
    public void update(E entity);
    public void delete(E entity);
}
