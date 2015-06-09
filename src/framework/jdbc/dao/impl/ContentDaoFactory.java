package framework.jdbc.dao.impl;

import framework.domain.Content;
import framework.jdbc.dao.IDao;
import framework.jdbc.dao.IDaoFactory;

public class ContentDaoFactory implements IDaoFactory<Content> {

	@Override
	public IDao<Content> produce() {
		return new ContentDao();
	}

}
