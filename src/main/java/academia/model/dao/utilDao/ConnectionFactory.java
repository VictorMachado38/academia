package academia.model.dao.utilDao;

import java.sql.Connection;
import java.sql.DriverManager;



public class ConnectionFactory {
	
	private Connection con;
	
	public Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/academia_eclipse","root","root");
			return con;
			
		}
		catch (Exception e){
			System.err.println("erro ao obter a conex�o" + e.getMessage());
			
		}
		
		return con;
	}
	
	public void setClouse() {
		try {
			con.close();
		}
		catch(Exception e) {
			
			System.err.println("erro ao fechar a conex�o" + e.getMessage());
		}
	}

}