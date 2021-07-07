package org.zerock.persistence;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;
@Log4j
public class JDBCTests {

	@Test
	public void test() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			fail();
		}
		
		String url = "jdbc:mariadb://52.79.189.42/test";
		String user = "root";
		String password = "wnddkdwjdqhcjfl1";
		
		try (Connection con = DriverManager.getConnection(url, user, password)) {
			log.info(con);
			assertNotNull(con);
		} catch (Exception e) {
			fail();
		}
	}

}
