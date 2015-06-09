package framework.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import framework.domain.User;
import framework.jdbc.conn.JdbcConnSingleton;
import framework.jdbc.dao.IDao;

public class UserDao implements IDao<User> {

	private JdbcConnSingleton db = JdbcConnSingleton.getInstance();

	@Override
	public int insert(User user) {
		String sql = "insert t_user(username,address) values(?,?)";
		return db.executeSQL(sql, user.getUsername(), user.getAddress());
	}

	@Override
	public int delete(int id) {
		String sql = "delete from t_user where id=?";
		return db.executeSQL(sql, id);
	}

	@Override
	public int update(User user) {
		String sql = "update t_user set username=?,address=? where id=?";
		return db.executeSQL(sql, user.getUsername(), user.getAddress(),
				user.getId());
	}

	@Override
	public User getById(int id) {
		Connection conn = db.getConn();
		PreparedStatement sta = null;
		ResultSet rs = null;
		User user = null;

		try {
			String sql = "select id,username,address from t_user where id=?";
			sta = conn.prepareStatement(sql);
			sta.setInt(1, id);
			rs = sta.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setAddress(rs.getString("address"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs, sta, conn);
		}
		return user;
	}

	@Override
	public List<User> getAll() {
		List<User> list = new ArrayList<User>();
		Connection conn = db.getConn();
		PreparedStatement sta = null;
		ResultSet rs = null;

		try {
			String sql = "select id,username,address from t_user";
			sta = conn.prepareStatement(sql);
			rs = sta.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setAddress(rs.getString("address"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close(rs, sta, conn);
		}
		return list;
	}

	// @Override
	public List<User> getByName(String name) {
		List<User> list = new ArrayList<User>();
		Connection conn = db.getConn();
		PreparedStatement sta = null;
		ResultSet rs = null;

		try {
			String sql = "select id,username,address from t_user where name=?";
			sta = conn.prepareStatement(sql);
			sta.setString(1, name);
			rs = sta.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setAddress(rs.getString("address"));
				list.add(user);
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
