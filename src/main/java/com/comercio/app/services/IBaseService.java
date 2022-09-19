package com.comercio.app.services;

import java.util.List;

public interface IBaseService<E> {
    public List<E> findAll() throws Exception;
    public E findById(Integer id);
    public E insert(E entity);
    public E update(Integer id, E entity);
    public boolean delete(Integer id);
}
