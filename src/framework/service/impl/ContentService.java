package framework.service.impl;

import java.util.List;

import framework.domain.Content;
import framework.jdbc.dao.IDao;
import framework.jdbc.dao.impl.ContentDaoFactory;
import framework.service.IContentService;

public class ContentService implements IContentService {

	private IDao<Content> contentDao = new ContentDaoFactory().produce();

	@Override
	public List<Content> getAll() {
		return contentDao.getAll();
	}

	@Override
	public void delete(int id) {
		contentDao.delete(id);
	}

	@Override
	public void insert(Content content) {
		contentDao.insert(content);
	}

	@Override
	public Content getById(int id) {
		return contentDao.getById(id);
	}

	@Override
	public void update(Content content) {
		contentDao.update(content);
	}

}
