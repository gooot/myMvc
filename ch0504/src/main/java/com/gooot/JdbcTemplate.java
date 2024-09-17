package com.gooot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplate {

	public void excuteUpdate(User user , String sql , PreparedStatementSetter pss ) throws SQLException {

		Connection con = null;
		PreparedStatement psmt = null;

		try {
			con = ConnectionManager.getConnection();
			psmt = con.prepareStatement(sql);
			pss.setter(psmt);

			psmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (psmt != null) {
				psmt.close();
			}

			if (con != null) {
				con.close();
			}

		}

	}

	public Object executeQuery(String sql , PreparedStatementSetter pss, RowMapper rowMapper) throws SQLException {

		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {

			con = ConnectionManager.getConnection();
			psmt = con.prepareStatement(sql);
			pss.setter(psmt);

			rs = psmt.executeQuery();

			Object obj = null;

			if (rs.next()) {
				return rowMapper.map(rs);
			}

			return obj;

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

	}

}
