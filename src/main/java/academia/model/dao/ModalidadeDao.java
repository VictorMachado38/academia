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
import academia.model.dao.utilDao.ConnectionFactory;

public class ModalidadeDao {
	
	Connection con;
	private Statement statement;
	private PreparedStatement preparedStatement;
	
	public ModalidadeDao()
	{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		con = connectionFactory.getConnection();
		
	}
	
	public List<Modalidade> listarModalidade(){
		List<Modalidade> modalidades = new ArrayList();
		ResultSet set;
		
		try {
			statement = con.createStatement();
			set = statement.executeQuery("select * from modalidade;");
					
					while (set.next()) {
						Modalidade modalidade = new Modalidade();
						modalidade.setIdModalidade(set.getInt("id"));
						modalidade.setNome(set.getString("nome"));
						modalidade.setDescricao(set.getString("descricao"));
						modalidade.setIdProfessor(set.getInt("idProfessor"));
						
						modalidades.add(modalidade);
					}
			
		}
		catch(Exception e) {
			
			System.err.println("erro ao listar Modalidade: " + e.getMessage());
			
		}
		return modalidades;
		
	}
	
	public boolean salvarModalidade(Modalidade modalidade) {
		boolean isSalvo = false;
		String query = "insert into modalidade (nome,descricao)"
				+ "values (?,?);";
		try {
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, modalidade.getNome());
			preparedStatement.setString(2, modalidade.getDescricao());
			

			preparedStatement.execute();

			con.commit();			
			isSalvo = true;
			
		}
		catch(Exception e){
			
			System.out.println("Errp ao inserrir modalidade:" + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}
	
	
	public boolean editarModalidade(Modalidade modalidade) {
		boolean isSalvo = false;
		
		 String query = "UPDATE modalidade "
				+ "SET nome = ?,"
				+ "descricao = ?"
				+ "WHERE id = ?";	
		
		try {
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, modalidade.getNome());
			preparedStatement.setString(2, modalidade.getDescricao());
			preparedStatement.setInt(3, modalidade.getIdModalidade());

	
			preparedStatement.executeUpdate();
			con.commit();			
			isSalvo = true;
			
		}
		catch(Exception e){
			
			System.out.println("Erro ao EDITAR modalidade: " + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}
		
	
	public boolean deletarModalidade(long id) {
		boolean isSalvo = false;
		
		 String query = "delete from modalidade where id = ?";
	
		
		try {
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setLong(1,id);

			preparedStatement.execute();
			con.commit();			
			isSalvo = true;
			
		}
		catch(Exception e){
			
			System.out.println("Erro ao DELETAR modalidade:" + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}

	public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
	    return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
	}
	
	

}



