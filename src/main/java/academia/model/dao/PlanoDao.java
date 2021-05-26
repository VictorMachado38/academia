package academia.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import academia.model.Modalidade;
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
						plano.setValor(set.getDouble("valor"));
						plano.setDescDoPlano(set.getString("descDoPlano"));
						
						planos.add(plano);
					}
			
		}
		catch(Exception e) {
			
			System.err.println("Erro ao listar planos" + e.getMessage());
			
		}
		return planos;
		
	}

	public boolean salvarPlano(Plano plano) {
		boolean isSalvo = false;
		String query = "insert into plano (nomeDoPlano,descDoPlano,valor)"
				+ "values (?,?,?);";
		try {
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, plano.getNomeDoPlano());
			preparedStatement.setString(2, plano.getDescDoPlano());
			preparedStatement.setDouble(3, plano.getValor());
			

			preparedStatement.execute();

			con.commit();			
			isSalvo = true;
			
		}
		catch(Exception e){
			
			System.out.println("Errp ao inserrir plano:" + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}
	
	
	public boolean editarPlano(Plano plano) {
		boolean isSalvo = false;
		
		 String query = "UPDATE plano "
				+ "SET nomeDoPlano = ?,"
				+ "descDoPlano = ?,"
				+ "valor = ?"
				+ "WHERE id = ?";	
		
		try {
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, plano.getNomeDoPlano());
			preparedStatement.setString(2, plano.getDescDoPlano());
			preparedStatement.setDouble(3, plano.getValor());
			preparedStatement.setInt(4, plano.getId());
			
	
			preparedStatement.executeUpdate();
			con.commit();			
			isSalvo = true;
			
		}
		catch(Exception e){
			
			System.out.println("Erro ao EDITAR plano: " + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}
		
	
	public boolean deletarPlano(long id) {
		boolean isSalvo = false;
		
		 String query = "delete from plano where id = ?";
	
		
		try {
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setLong(1,id);

			preparedStatement.execute();
			con.commit();			
			isSalvo = true;
			
		}
		catch(Exception e){
			
			System.out.println("Erro ao DELETAR plano:" + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}

	public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
	    return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
	}
	
	
}
