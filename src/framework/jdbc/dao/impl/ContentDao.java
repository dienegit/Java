package framework.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import framework.domain.Content;
import framework.domain.User;
import framework.jdbc.conn.JdbcConnSingleton;
import framework.jdbc.dao.IDao;

public class ContentDao implements IDao<Content> {

	private JdbcConnSingleton db = JdbcConnSingleton.getInstance();
	private IDao<User> userDao = new UserDaoFactory().produce();

	@Override
	public int insert(Content content) {
		String sql = "insert t_content(title,text,userid) values(?,?,?)";
		return db.executeSQL(sql, content.getTitle(), content.getText(),
				content.getAuthor().getId());
	}

	@Override
	public int delete(int id) {
		String sql = "delete from t_content where id=?";
		return db.executeSQL(sql, id);
	}

	@Override
	public int update(Content content) {
		String sql = "update t_content set title=?,text=?,userid=? where id=?";
		return db.executeSQL(sql, content.getTitle(), content.getText(),
				content.getAuthor().getId(), content.getId());
	}

	@Override
	public Content getById(int id) {
		Connection conn = db.getConn();
		PreparedStatement sta = null;
		ResultSet rs = null;
		Content content = null;

		try {
			String sql = "select id,title,text,userid from t_content where id=?";
			sta = conn.prepareStatement(sql);
			sta.setInt(1, id);
			rs = sta.executeQuery();
			if (rs.next()) {
				content = new Content();
				content.setId(rs.getInt("id"));
				content.setTitle(rs.getString("title"));
				content.setText(rs.getString("text"));
				content.setAuthor(userDao.getById(rs.getInt("userid")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs, sta, conn);
		}
		return content;
	}

	@Override
	public List<Content> getAll() {
		List<Content> list = new ArrayList<Content>();
		Connection conn = db.getConn();
		PreparedStatement sta = null;
		ResultSet rs = null;

		try {
			String sql = "select id,title,text,userid from t_content";
			sta = conn.prepareStatement(sql);
			rs = sta.executeQuery();

			while (rs.next()) {
				Content content = new Content();
				content.setId(rs.getInt("id"));
				content.setTitle(rs.getString("title"));
				content.setText(rs.getString("text"));
				content.setAuthor(userDao.getById(rs.getInt("userid")));
				list.add(content);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close(rs, sta, conn);
		}
		return list;
	}

}
