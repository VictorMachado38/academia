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

import academia.model.Modalidade;
import academia.model.Professor;
import academia.model.Turma;
import academia.model.dao.utilDao.ConnectionFactory;

public class TurmaDao {
	
	Connection con;
	private Statement statement;
	private PreparedStatement preparedStatement;
	
	public TurmaDao()
	{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		con = connectionFactory.getConnection();
		
	}

	public List<Turma> listarTurma(){
		List<Turma> turmas = new ArrayList();
		ResultSet set;
		
		try {
			statement = con.createStatement();
			set = statement.executeQuery("select * from turma;");
					
					while (set.next()) {
						Turma turma = new Turma();
						turma.setId(set.getInt("id"));
						turma.setNome(set.getString("nome"));
						turma.setMaxAluno(set.getInt("maxAluno"));
						turma.setHorario(set.getString("horario"));
						turma.setDescTurma(set.getString("descTurma"));
						
						turmas.add(turma);
					}
			
		}
		catch(Exception e) {
			
			System.err.println("erro ao listar turmas: " + e.getMessage());
			
		}
		return turmas;
		
	}


	public boolean salvarTurmaComAlunosEProfessor(Turma turma,Professor professor) throws SQLException {
		
		boolean isSalvo = false;
		String queryTurma = "insert into turma (nome,maxAluno,horario,descTurma)"
				+ "values (?,?,?,?);";
		
		String queryAlunos = "insert into aluno (nome,dataNascimento,endereco,telefone,email,sexo,dataCadastro,matricula,idTurma)"
				+ "values (?,?,?,?,?,?,?,?,?);";
		
		String queryPrefessor = "insert into professor (nome,dataNascimento,endereco,telefone,email,sexo,dataCadastro,idTurma)"
				+ "values (?,?,?,?,?,?,?,?);";
		
		
		try {
			con.setAutoCommit(false);
			
			preparedStatement = con.prepareStatement(queryTurma);
			preparedStatement.setString(1, turma.getNome());
			preparedStatement.setInt(2, turma.getMaxAluno());
			preparedStatement.setString(3, turma.getHorario());
			preparedStatement.setString(4, turma.getDescTurma());
			//preparedStatement.setInt(5, turma.getIdProfessor());
							
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
			final int idTurma = idTemp;
			
			
//			for (int i = 0; i < pessoa.getEnderecos().size(); i++) {
//				Endereco endereco = pessoa.getEnderecos().get(i);
//				
//			}
			
			turma.getAlunos().forEach(alunos ->{
				try {
					preparedStatement = con.prepareStatement(queryAlunos);
					preparedStatement.setString(1, alunos.getNome());
					preparedStatement.setDate(2, java.sql.Date.valueOf(alunos.getDataNascimento()) );
					preparedStatement.setString(3, alunos.getEndereco());
					preparedStatement.setString(4, alunos.getTelefone());
					preparedStatement.setString(5,alunos.getEmail());
					preparedStatement.setString(6, alunos.getSexo());
					preparedStatement.setDate(7 ,java.sql.Date.valueOf(alunos.getDataCadastro()) );
					preparedStatement.setInt(8,alunos.getMatricula());
					preparedStatement.setInt(9, idTurma);
					
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
			
		//	Professor professor = new Professor();
				try {
					con.setAutoCommit(false);
					
					preparedStatement = con.prepareStatement(queryPrefessor);
					preparedStatement.setString(1, professor.getNome());
					preparedStatement.setDate(2, java.sql.Date.valueOf(professor.getDataNascimento()) );
					preparedStatement.setString(3, professor.getEndereco());
					preparedStatement.setString(4, professor.getTelefone());
					preparedStatement.setString(5,professor.getEmail());
					preparedStatement.setString(6, professor.getSexo());
					preparedStatement.setDate(7 ,java.sql.Date.valueOf(professor.getDataCadastro()) );
					preparedStatement.setInt(8, idTurma);
					
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
				};
			
			con.commit();
			isSalvo = true;
			
			
		} catch (Exception e) {
			System.err.println("Erro ao inserir salvarTurmaComAlunosEProfessor(): ERRO: " +  e.getMessage());
			isSalvo = false;
			con.rollback();
		}
		
		return isSalvo;
		
	}
	
	
	public boolean salvarTurma(Turma turma) {
		
		boolean isSalvo = false;
		String query = "insert into turma (nome,maxAluno,horario,descTurma)"
				+ "values (?,?,?,?);";
		try {
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, turma.getNome());
			preparedStatement.setInt(2, turma.getMaxAluno());
			preparedStatement.setString(3, turma.getHorario());
			preparedStatement.setString(4, turma.getDescTurma());
			

			preparedStatement.execute();

			con.commit();			
			isSalvo = true;
			
		}
		catch(Exception e){
			
			System.out.println("Erro ao inserrir turma:" + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}
	
	
	public boolean editarTurma(Turma turma) {
		boolean isSalvo = false;
		
		 String query = "UPDATE turma "
				+ "SET nome = ?,"
				+ "maxAluno = ?,"
				+ "horario = ?,"
				+ "descTurma = ?"
				+ "WHERE id = ?";	
		
		try {
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, turma.getNome());
			preparedStatement.setInt(2, turma.getMaxAluno());
			preparedStatement.setString(3, turma.getHorario());
			preparedStatement.setString(4, turma.getDescTurma());
			preparedStatement.setInt(5, turma.getId());

	
			preparedStatement.executeUpdate();
			con.commit();			
			isSalvo = true;
			
		}
		catch(Exception e){
			
			System.out.println("Erro ao EDITAR turma: " + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}
		
	
	public boolean deletarTurma(long id) {
		boolean isSalvo = false;
		
		 String query = "delete from turma where id = ?";
	
		
		try {
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setLong(1,id);

			preparedStatement.execute();
			con.commit();			
			isSalvo = true;
			
		}
		catch(Exception e){
			
			System.out.println("Erro ao DELETAR turma:" + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}

	public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
	    return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
	}
}
