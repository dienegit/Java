package framework.service.impl;

import java.util.List;

import framework.domain.User;
import framework.jdbc.dao.IDao;
import framework.jdbc.dao.impl.UserDaoFactory;
import framework.service.IUserService;

public class UserService implements IUserService {

	private IDao<User> userDao = new UserDaoFactory().produce();

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

	@Override
	public void insert(User user) {
		userDao.insert(user);
	}

	@Override
	public User getById(int id) {
		return userDao.getById(id);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

}
