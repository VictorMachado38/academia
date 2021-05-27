package academia.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import academia.model.Professor;
import academia.model.Turma;
import academia.model.SalaDeAula;
import academia.model.dao.utilDao.ConnectionFactory;

public class SalaDeAulaDao {
	
	
	Connection con;
	private Statement statement;
	private PreparedStatement preparedStatement;
	
	public SalaDeAulaDao()
	{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		con = connectionFactory.getConnection();
		
	}
	
	public List<SalaDeAula> listarSalaDeAula() {
		List<SalaDeAula> salaDeAulas = new ArrayList();
		ResultSet set;

		try {
			statement = con.createStatement();
			set = statement.executeQuery("select * from salaDeAula;");

			while (set.next()) {
				SalaDeAula salaDeAula = new SalaDeAula(); 
				salaDeAula.setId(set.getInt("id"));
				salaDeAula.setNumero(set.getInt("numero"));
				salaDeAula.setIdTurma(set.getInt("idTurma"));
				
				salaDeAulas.add(salaDeAula);
			}

		} catch (Exception e) {

			System.err.println("erro ao listar turmas: " + e.getMessage());

		}
		return salaDeAulas;

	}

	public boolean salvarSalaDeAula(SalaDeAula salaDeAula) {

		boolean isSalvo = false;
		String query = "insert into salaDeAula (numero,idTurma)" + "values (?,?);";
		try {

			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, salaDeAula.getNumero());
			preparedStatement.setInt(2, salaDeAula.getIdTurma());


			preparedStatement.execute();

			con.commit();
			isSalvo = true;

		} catch (Exception e) {

			System.out.println("Erro ao inserrir SalaDeAula:" + e.getMessage());
			isSalvo = false;

		}

		return isSalvo;
	}
	
	public boolean salvarSalaDeAulas(SalaDeAula salaDeAula) {

		boolean isSalvo = false;
		String query = "insert into salaDeAula (numero,idTurma)" + "values (?,?);";
		try {

			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, salaDeAula.getNumero());
			preparedStatement.setInt(2, salaDeAula.getIdTurma());
		

			preparedStatement.execute();

			con.commit();
			isSalvo = true;

		} catch (Exception e) {

			System.out.println("Erro ao inserrir salaDeAula:" + e.getMessage());
			isSalvo = false;

		}

		return isSalvo;
	}

	public boolean editarSalaDeAula(SalaDeAula salaDeAula) {
		boolean isSalvo = false;

		String query = "UPDATE salaDeAula " 
				+ "SET numero = ?," 
				+ "idTurma = ? " 
				+ " WHERE id = ?";

		try {

			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, salaDeAula.getNumero());
			preparedStatement.setInt(2, salaDeAula.getIdTurma());
			preparedStatement.setInt(3, salaDeAula.getId());

			preparedStatement.executeUpdate();
			con.commit();
			isSalvo = true;

		} catch (Exception e) {

			System.out.println("Erro ao EDITAR Sala De Aula: " + e.getMessage());
			isSalvo = false;

		}

		return isSalvo;
	}

	public boolean deletarSalaDeAula(long id) {
		boolean isSalvo = false;

		String query = "delete from salaDeAula where id = ?";

		try {

			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setLong(1, id);

			preparedStatement.execute();
			con.commit();
			isSalvo = true;

		} catch (Exception e) {

			System.out.println("Erro ao DELETAR Sala De Aula:" + e.getMessage());
			isSalvo = false;

		}

		return isSalvo;
	}

	public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
		return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
	}

}
