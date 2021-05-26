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
import academia.model.Pessoa;
import academia.model.dao.utilDao.ConnectionFactory;
public class ProfessorDao {
	
	Connection con;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private PreparedStatement preparedStatement2;
	

	
	public ProfessorDao()
	{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		con = connectionFactory.getConnection();
		
	}
	
	public List<Professor> listarProfessor(){
		List<Professor> professores = new ArrayList();
		ResultSet set;
		
		try {
			statement = con.createStatement();
			set = statement.executeQuery("select * from professor;");
					
					while (set.next()) {
						Professor professor = new Professor();
						professor.setId(set.getInt("id"));
						professor.setNome(set.getString("nome"));
						professor.setDataNascimento(convertToLocalDateViaSqlDate(set.getDate("dataNascimento")));
						professor.setEndereco(set.getString("endereco"));
						professor.setTelefone(set.getString("telefone"));		
						professor.setEmail(set.getString("email"));
						professor.setSexo(set.getString("sexo"));
						professor.setDataCadastro(convertToLocalDateViaSqlDate(set.getDate("dataNascimento")));
						
						professores.add(professor);
					}
			
		}
		catch(Exception e) {
			
			System.err.println("erro ao listar professor: " + e.getMessage());
			
		}
		return professores;
		
	}

	public boolean salvarProfessroComModalidades(Professor professor) throws SQLException {
		boolean isSalvo = false;
		String queryProfessor = "insert into professor (nome,dataNascimento,endereco,telefone,email,sexo,dataCadastro)"
				+ "values (?,?,?,?,?,?,?);";
		
		String queryModalidade = "insert into modalidade(nome,descricao,idProfessor)"
				+ "VALUES (?,?,?)";
		
		
		try {
			con.setAutoCommit(false);
			
			preparedStatement = con.prepareStatement(queryProfessor);
			preparedStatement.setString(1, professor.getNome());
			preparedStatement.setDate(2, java.sql.Date.valueOf(professor.getDataNascimento()) );
			preparedStatement.setString(3, professor.getEndereco());
			preparedStatement.setString(4, professor.getTelefone());
			preparedStatement.setString(5,professor.getEmail());
			preparedStatement.setString(6, professor.getSexo());
			preparedStatement.setDate(7 ,java.sql.Date.valueOf(professor.getDataCadastro()) );
			
			preparedStatement.execute();
			statement = con.createStatement();
			int idTemp = 0;
			
			try {
				ResultSet set = statement.executeQuery("select last_insert_id() as id");
				while (set.next()) {
					idTemp = set.getInt("id");
					
				}
			} catch (Exception e) {
				// TODO: handle exception
				con.rollback();
			}
			final int idProfessor = idTemp;
			
			
//			for (int i = 0; i < pessoa.getEnderecos().size(); i++) {
//				Endereco endereco = pessoa.getEnderecos().get(i);
//				
//			}
			
			professor.getModalidade().forEach(modalidade ->{
				try {
					preparedStatement = con.prepareStatement(queryModalidade);
					preparedStatement.setString(1, modalidade.getNome());
					preparedStatement.setString(2, modalidade.getDescricao());
					preparedStatement.setInt(3, idProfessor);
					
					preparedStatement.execute();
					
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					try {
						con.rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			con.commit();
			isSalvo = true;
			
			
		} catch (Exception e) {
			System.err.println("Erro ao inserir salvarProfessroComModalidades(): ERRO: " +  e.getMessage());
			isSalvo = false;
			con.rollback();
		}
		
		return isSalvo;
		
	}
	
	public boolean salvarProfessor(Professor professor) {
		boolean isSalvo = false;

		String query = "insert into professor (nome,dataNascimento,endereco,telefone,email,sexo,dataCadastro)"
				+ "values (?,?,?,?,?,?,?);";
		try {
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, professor.getNome());
			preparedStatement.setDate(2, java.sql.Date.valueOf(professor.getDataNascimento()) );
			preparedStatement.setString(3, professor.getEndereco());
			preparedStatement.setString(4, professor.getTelefone());
			preparedStatement.setString(5,professor.getEmail());
			preparedStatement.setString(6, professor.getSexo());
			preparedStatement.setDate(7 ,java.sql.Date.valueOf(professor.getDataCadastro()) );
			
			//preparedStatement.execute(query);
			preparedStatement.execute();
		//	preparedStatement.executeUpdate();
			con.commit();			
			isSalvo = true;
			
		}
		catch(Exception e){
			
			System.out.println("Errp ao inserrir Professor:" + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}
	
	public boolean editarProfessor(Professor professor) {
		boolean isSalvo = false;
		
		 String query = "UPDATE professor "
				+ "SET nome = ?,"
				+ "dataNascimento = ?,"
				+ "endereco = ?,"
				+ "telefone = ?,"
				+ "email = ?,"
				+ "sexo = ?,"
				+ "dataCadastro = ?"
				+ "WHERE id = ?";	
		
		try {
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, professor.getNome());
			preparedStatement.setDate(2, java.sql.Date.valueOf(professor.getDataNascimento()) );
			preparedStatement.setString(3, professor.getEndereco());
			preparedStatement.setString(4, professor.getTelefone());
			preparedStatement.setString(5,professor.getEmail());
			preparedStatement.setString(6, professor.getSexo());
			preparedStatement.setDate(7 ,java.sql.Date.valueOf(professor.getDataCadastro()) );
			preparedStatement.setInt(8,professor.getId());
			//preparedStatement.execute(query);
		//	preparedStatement.execute();
			preparedStatement.executeUpdate();
			con.commit();			
			isSalvo = true;
			
		}
		catch(Exception e){
			
			System.out.println("Errp ao EDITAR professor:" + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}
		
	public boolean deletarProfessor(long id) {
		boolean isSalvo = false;
		
		 String query = "delete from professor where id = ?";
			
			
			try {
				
				con.setAutoCommit(false);
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setLong(1,id);
				
			
				preparedStatement.execute();
				con.commit();			
				isSalvo = true;
				
			
		}
		catch(Exception e){
			
			System.out.println("Errp ao DELETAR professor:" + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}
	
	public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
	    return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
	}
	
	

}

