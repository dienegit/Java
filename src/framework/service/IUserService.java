package framework.service;

import java.util.List;

import framework.domain.User;

public interface IUserService {

	List<User> getAll();

	void delete(int id);

	void insert(User user);

	User getById(int id);

	void update(User user);

}
