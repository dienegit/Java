package framework.view.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import framework.domain.Content;
import framework.domain.User;
import framework.service.IContentService;
import framework.service.IUserService;
import framework.service.impl.ContentService;
import framework.service.impl.UserService;

public class ContentAction extends ActionSupport {

	private IContentService contentService = new ContentService();
	private IUserService userService = new UserService();

	private int id;
	private String title;
	private String text;
	private int userid;

	public String list() throws Exception {
		List<Content> contentList = contentService.getAll();
		ActionContext.getContext().put("contentList", contentList);
		return "list";
	}

	public String delete() throws Exception {
		contentService.delete(id);
		return "toList";
	}

	public String addUI() throws Exception {
		List<User> userList = userService.getAll();
		ActionContext.getContext().put("userList", userList);
		return "addUI";
	}

	public String add() throws Exception {
		Content content = new Content();
		User user = userService.getById(userid);
		content.setTitle(title);
		content.setText(text);
		content.setAuthor(user);
		contentService.insert(content);
		return "toList";
	}

	public String editUI() throws Exception {
		List<User> userList = userService.getAll();
		ActionContext.getContext().put("userList", userList);
		Content content = contentService.getById(id);
		ActionContext.getContext().getValueStack().push(content);
		userid = content.getAuthor().getId();
		return "editUI";
	}

	public String edit() throws Exception {
		Content content = contentService.getById(id);
		User user = userService.getById(userid);
		content.setTitle(title);
		content.setText(text);
		content.setAuthor(user);
		contentService.update(content);
		return "toList";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
}
