package database;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.sql.DataSource;

public class TestAccount {

	public static void main(String[] args) throws NamingException, SQLException {
		
		
				InitialContext initContext = new InitialContext();
				Context env = (Context) initContext.lookup("java:comp/env");
				DataSource ds = (DataSource) env.lookup("jdbc/webshop");

		Connection conn = null;
		try {
			conn = (Connection) ds.getConnection();
		} catch (SQLException e) {
			return;
		}

		Account account = new Account(conn);
		
		account.create("juju@gmail.com", "letmeinhere");
		
	}

}
