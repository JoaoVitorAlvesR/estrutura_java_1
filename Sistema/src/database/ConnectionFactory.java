package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	// https://dontpad.com/estrutura_matheus
	public static Connection getConnection
							(
									final String ip, 
									final String porta, 
									final String nomeBanco, 
									final String usuario, 
									final String senha
							) throws SQLException 
	{	
		return DriverManager.getConnection
				(
					"jdbc:postgresql://"
						+ip
						+":"
						+porta
						+"/"
						+nomeBanco,
						usuario,
						senha
				);
	}

}





