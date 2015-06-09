package framework.jdbc.dao;

import java.util.List;

public interface IDao<T> {
	int insert(T entity);

	int delete(int id);

	int update(T entity);

	T getById(int id);

	List<T> getAll();
}
