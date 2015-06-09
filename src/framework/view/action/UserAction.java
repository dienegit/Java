package framework.view.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import framework.domain.User;
import framework.service.IUserService;
import framework.service.impl.UserService;

public class UserAction extends ActionSupport {

	private IUserService userService = new UserService();

	private int id;
	private String username;
	private String address;

	public String list() throws Exception {
		List<User> userList = userService.getAll();
		ActionContext.getContext().put("userList", userList);
		return "list";
	}

	public String delete() throws Exception {
		userService.delete(id);
		return "toList";
	}

	public String addUI() throws Exception {
		return "addUI";
	}

	public String add() throws Exception {
		User user = new User();
		user.setUsername(username);
		user.setAddress(address);
		userService.insert(user);
		return "toList";
	}

	public String editUI() throws Exception {
		User user = userService.getById(id);
		ActionContext.getContext().getValueStack().push(user);
		return "editUI";
	}

	public String edit() throws Exception {
		User user = userService.getById(id);
		user.setUsername(username);
		user.setAddress(address);
		userService.update(user);
		return "toList";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
