
package creche;
import java.sql.*;
import java.lang.reflect.Method;

public class ConnexionJDBC {
        public ConnexionJDBC(){}
	public Connection getConnPostgre() throws Exception
	{
		Class.forName("org.postgresql.Driver");
		Connection conn =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/crechebase","postgres", "itu");
		return conn;
	}
}
