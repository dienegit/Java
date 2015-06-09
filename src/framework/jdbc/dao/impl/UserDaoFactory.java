package framework.jdbc.dao.impl;

import framework.domain.User;
import framework.jdbc.dao.IDao;
import framework.jdbc.dao.IDaoFactory;

public class UserDaoFactory implements IDaoFactory<User> {

	@Override
	public IDao<User> produce() {
		return new UserDao();
	}

}
