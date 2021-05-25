package academia.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import academia.model.Funcionario;
import academia.model.dao.utilDao.ConnectionFactory;

public class FuncionarioDao {
	
	Connection con;
	private Statement statement;
	private PreparedStatement preparedStatement;
	
	public FuncionarioDao()
	{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		con = connectionFactory.getConnection();
		
	}

	public List<Funcionario> listarFuncionarios(){
		List<Funcionario> funcionarios = new ArrayList(); //uma lista
		ResultSet set;
		
		try {
			statement = con.createStatement();
			set = statement.executeQuery("select * from funcionario;");
					
					while (set.next()) {
						Funcionario funcionario = new Funcionario();
						funcionario.setId(set.getInt("id"));
						funcionario.setNome(set.getString("nome"));
						funcionario.setDataNascimento(convertToLocalDateViaSqlDate(set.getDate("dataNascimento")));
						funcionario.setEndereco(set.getString("endereco"));
						funcionario.setTelefone(set.getString("telefone"));		
						funcionario.setEmail(set.getString("email"));
						funcionario.setSexo(set.getString("sexo"));
						funcionario.setDataCadastro(convertToLocalDateViaSqlDate(set.getDate("dataNascimento")));
						funcionario.setFuncao(set.getString("funcao"));
						funcionario.setDescFuncao(set.getString("descFuncao"));
						
						funcionarios.add(funcionario);
						}
			
		}
		catch(Exception e) {
			
			System.err.println("Erro ao listar pessoa" + e.getMessage());
			
		}
		return funcionarios;
		
	}

	public boolean salvarFuncionario(Funcionario funcionario) {
		boolean isSalvo = false;

		String query = "insert into funcionario (nome,dataNascimento,endereco,telefone,email,sexo,dataCadastro,funcao,descFuncao)"
				+ "values (?,?,?,?,?,?,?,?,?);";
		try {
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, funcionario.getNome());
			preparedStatement.setDate(2, java.sql.Date.valueOf(funcionario.getDataNascimento()) );
			preparedStatement.setString(3, funcionario.getEndereco());
			preparedStatement.setString(4, funcionario.getTelefone());
			preparedStatement.setString(5,funcionario.getEmail());
			preparedStatement.setString(6, funcionario.getSexo());
			preparedStatement.setDate(7 ,java.sql.Date.valueOf(funcionario.getDataCadastro()) );
			preparedStatement.setString(8,funcionario.getFuncao());
			preparedStatement.setString(9, funcionario.getDescFuncao());
			
			
			//preparedStatement.execute(query);
			preparedStatement.execute();
		//	preparedStatement.executeUpdate();
			con.commit();			
			isSalvo = true;
			
		}
		catch(Exception e){
			
			System.out.println("Erro ao inserrir funcionario:" + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}
		
	public boolean editarFuncionario(Funcionario funcionario) {
		boolean isSalvo = false;
		
		 String query = "UPDATE funcionario "
				+ "SET nome = ?,"
				+ "dataNascimento = ?,"
				+ "endereco = ?,"
				+ "telefone = ?,"
				+ "email = ?,"
				+ "sexo = ?,"
				+ "dataCadastro = ?,"
				+ "funcao = ?,"
				+ "descFuncao = ?"
				+ "WHERE id = ?";	
		
		try {
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, funcionario.getNome());
			preparedStatement.setDate(2, java.sql.Date.valueOf(funcionario.getDataNascimento()) );
			preparedStatement.setString(3, funcionario.getEndereco());
			preparedStatement.setString(4, funcionario.getTelefone());
			preparedStatement.setString(5,funcionario.getEmail());
			preparedStatement.setString(6, funcionario.getSexo());
			preparedStatement.setDate(7 ,java.sql.Date.valueOf(funcionario.getDataCadastro()) );
			preparedStatement.setString(8, funcionario.getFuncao());
			preparedStatement.setString(9, funcionario.getDescFuncao());
			preparedStatement.setInt(10,funcionario.getId());
			
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
		
	public boolean deletarFuncionario(long id) {
		boolean isSalvo = false;
		
		 String query = "delete from funcionario where id = ?";
	
		
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
			
			System.out.println("Erro ao DELETAR funcionario:" + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}

	public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
	    return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
	}
	

	
}
