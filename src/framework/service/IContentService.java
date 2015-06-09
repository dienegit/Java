package framework.service;

import java.util.List;

import framework.domain.Content;

public interface IContentService {

	List<Content> getAll();

	void delete(int id);

	void insert(Content content);

	Content getById(int id);

	void update(Content content);

}
