package com.comercio.app.services;

import java.util.List;

public interface IBaseService<E> {
    public List<E> findAll() throws Exception;
    public E findById(Long id);
    public E insert(E entity);
    public E update(Long id, E entity);
    public boolean delete(Long id);
}
