package ra.edu.ss02.service;

public interface IService<T, ID> {
    T save(T entity);
    T findById(ID id);
    T update(T entity);
    void delete(ID id);
}
