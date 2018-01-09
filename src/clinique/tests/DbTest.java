package clinique.tests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import clinique.dal.jdbc.JdbcTools;

public class DbTest {

	@Test
	public void connectionTest() throws SQLException {
		Connection conn = JdbcTools.getConnection();
	}

}
