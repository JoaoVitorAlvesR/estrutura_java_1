package main;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import database.ConnectionFactory;
import graphic.LoginWindow;

public class Start {

	public static void main(String[] args) {
		
		try {
			Connection conn = ConnectionFactory.getConnection("localhost", "5432", "postgres", "postgres", "12345");
			if (conn != null) {
				
				new LoginWindow(conn).setVisible(true);
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Não foi possível conectar no banco de dados!");
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Não foi possível conectar no banco de dados: "+e.getMessage());
		}		
	}

}
