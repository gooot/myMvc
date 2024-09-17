package com.gooot;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementSetter {

	void setter(PreparedStatement psmt) throws SQLException;

}
