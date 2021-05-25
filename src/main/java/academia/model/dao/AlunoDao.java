package academia.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import academia.model.Aluno;
import academia.model.dao.utilDao.ConnectionFactory;

public class AlunoDao {
	
	Connection con;
	private Statement statement;
	private PreparedStatement preparedStatement;
	
	public AlunoDao()
	{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		con = connectionFactory.getConnection();
		
	}

	public List<Aluno> listarAlunos(){
		List<Aluno> alunos = new ArrayList(); //uma lista
		ResultSet set;
		
		try {
			statement = con.createStatement();
			set = statement.executeQuery("select * from funcionario;");
					
					while (set.next()) {
						Aluno aluno = new Aluno();
						aluno.setId(set.getInt("id"));
						aluno.setNome(set.getString("nome"));
						aluno.setDataNascimento(convertToLocalDateViaSqlDate(set.getDate("dataNascimento")));
						aluno.setEndereco(set.getString("endereco"));
						aluno.setTelefone(set.getString("telefone"));		
						aluno.setEmail(set.getString("email"));
						aluno.setSexo(set.getString("sexo"));
						aluno.setDataCadastro(convertToLocalDateViaSqlDate(set.getDate("dataNascimento")));
						aluno.setMatricula(set.getInt("matricula"));
						
						
						alunos.add(aluno);
						}
			
		}
		catch(Exception e) {
			
			System.err.println("erro ao listar alunos:  " + e.getMessage());
			
		}
		return alunos;
		
	}

	public boolean salvarAluno(Aluno aluno) {
		boolean isSalvo = false;

		String query = "insert into aluno (nome,dataNascimento,endereco,telefone,email,sexo,dataCadastro,matricula)"
				+ "values (?,?,?,?,?,?,?,?);";
		try {
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, aluno.getNome());
			preparedStatement.setDate(2, java.sql.Date.valueOf(aluno.getDataNascimento()) );
			preparedStatement.setString(3, aluno.getEndereco());
			preparedStatement.setString(4, aluno.getTelefone());
			preparedStatement.setString(5,aluno.getEmail());
			preparedStatement.setString(6, aluno.getSexo());
			preparedStatement.setDate(7 ,java.sql.Date.valueOf(aluno.getDataCadastro()) );
			preparedStatement.setInt(8,aluno.getMatricula());
		
			
			
			//preparedStatement.execute(query);
			preparedStatement.execute();
		//	preparedStatement.executeUpdate();
			con.commit();			
			isSalvo = true;
			
		}
		catch(Exception e){
			
			System.out.println("Errp ao inserrir aluno:" + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}
		
	public boolean editarAluno(Aluno aluno) {
		boolean isSalvo = false;
		
		 String query = "UPDATE aluno "
				+ "SET nome = ?,"
				+ "dataNascimento = ?,"
				+ "endereco = ?,"
				+ "telefone = ?,"
				+ "email = ?,"
				+ "sexo = ?,"
				+ "dataCadastro = ?,"
				+ "maticula = ?,"
				+ "WHERE id = ?";	
		
		try {
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, aluno.getNome());
			preparedStatement.setDate(2, java.sql.Date.valueOf(aluno.getDataNascimento()) );
			preparedStatement.setString(3, aluno.getEndereco());
			preparedStatement.setString(4, aluno.getTelefone());
			preparedStatement.setString(5,aluno.getEmail());
			preparedStatement.setString(6, aluno.getSexo());
			preparedStatement.setDate(7 ,java.sql.Date.valueOf(aluno.getDataCadastro()) );
			preparedStatement.setInt(8, aluno.getMatricula());
			preparedStatement.setInt(10,aluno.getId());
			
			//preparedStatement.execute(query);
		//	preparedStatement.execute();
			preparedStatement.executeUpdate();
			con.commit();			
			isSalvo = true;
			
		}
		catch(Exception e){
			
			System.out.println("Erro ao EDITAR funcionario:" + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}
		
	public boolean deletarAluno(long id) {
		boolean isSalvo = false;
		
		 String query = "delete from aluno where id = ?";
	
		
		try {
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setLong(1,id);
			
			//preparedStatement.execute(query);
		//	preparedStatement.execute();
			preparedStatement.execute();
			con.commit();			
			isSalvo = true;
			
		}
		catch(Exception e){
			
			System.out.println("Erro ao DELETAR aluno:" + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}

	public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
	    return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
	}
	
}
