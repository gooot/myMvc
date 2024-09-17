package com.gooot;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class UserDao {

	private Connection getConnection(){

		String url = "jdbc:h2:mem://localhost/~/jdbc-practice;MODE=MySQL;DB_CLOSE_DELAY=-1";
		String id = "sa";
		String pw = "";


		try {
			Class.forName("org.h2.Driver");
			return DriverManager.getConnection(url,id,pw);

		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public void create(User user) throws SQLException {

		Connection con = null;
		PreparedStatement psmt = null;

		try {
			con = getConnection();
			String sql = "INSERT INTO USERS VALUES (?,?,?,?)";
			psmt = con.prepareStatement(sql);
			psmt.setString(1,user.getUserId());
			psmt.setString(2, user.getPassword());
			psmt.setString(3, user.getName());
			psmt.setString(4, user.getEmail());

			psmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(psmt != null){
				psmt.close();
			}

			if(con != null){
				con.close();
			}

		}


	}


	public User findByUserId(String userId) throws SQLException {

		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;


		try {

			con = getConnection();
			String sql = "SELECT * FROM USERS WHERE userId = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1,userId);

			rs = psmt.executeQuery();

			User user = null;

			if(rs.next()){
				user = new User(
					rs.getString("userId"),
					rs.getString("password"),
					rs.getString("name"),
					rs.getString("email")
				);
			}

			return user;

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if(rs != null){
				rs.close();
			}
			if(psmt != null){
				psmt.close();
			}
			if(con != null){
				con.close();
			}
		}


	}

}
