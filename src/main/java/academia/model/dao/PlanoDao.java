package academia.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import academia.model.Plano;
import academia.model.dao.utilDao.ConnectionFactory;

public class PlanoDao {
	Connection con;
	private Statement statement;
	private PreparedStatement preparedStatement;
	
	public PlanoDao()
	{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		con = connectionFactory.getConnection();
		
	}

	public List<Plano> listarPlanos(){
		List<Plano> planos = new ArrayList();
		ResultSet set;
		
		try {
			statement = con.createStatement();
			set = statement.executeQuery("select * from plano;");
					
					while (set.next()) {
						Plano plano = new Plano();
						plano.setId(set.getInt("id"));
						plano.setNomeDoPlano(set.getString("nomeDoPlano"));
						plano.setValor(set.getBigDecimal("valor"));
						
						planos.add(plano);
					}
			
		}
		catch(Exception e) {
			
			System.err.println("Erro ao listar planos" + e.getMessage());
			
		}
		return planos;
		
	}
	
}
