package framework.jdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcConnSingleton {
	private Connection conn = null;

	private String className = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://db4free.net:3306/oodfinal";
	private String userName = "lukechen";
	private String password = "oodfinal";

	private static JdbcConnSingleton db;

	private JdbcConnSingleton() {
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static synchronized JdbcConnSingleton getInstance() {
		if (db == null) {
			db = new JdbcConnSingleton();
		}
		return db;
	}

	public Connection getConn() {
		try {
			conn = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public int executeSQL(String sql, Object... args) {
		Connection conn = getConn();
		PreparedStatement sta = null;
		int rows = 0;

		try {
			sta = conn.prepareStatement(sql);

			for (int i = 0; i < args.length; i++) {
				sta.setObject(i + 1, args[i]);
			}

			rows = sta.executeUpdate();
			if (rows > 0) {
				System.out.println("success!");
			} else {
				System.out.println("fail!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(sta, conn);
		}
		return rows;
	}

	public void close(ResultSet rs, PreparedStatement sta, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (sta != null) {
					sta.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void close(PreparedStatement sta, Connection conn) {
		this.close(null, sta, conn);
	}
}
