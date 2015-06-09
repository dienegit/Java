package framework.jdbc.dao;

public interface IDaoFactory<T> {
	IDao<T> produce();
}
