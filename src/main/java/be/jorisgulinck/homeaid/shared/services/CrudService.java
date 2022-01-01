package be.jorisgulinck.homeaid.shared.services;

import java.util.List;

public interface CrudService<T> {

    public T save(T entity);

    public T getById(long id);

    public List<T> getAll();

    public void delete(long id);

}
