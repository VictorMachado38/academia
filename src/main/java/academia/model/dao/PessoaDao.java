package academia.model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import academia.model.Pessoa;
import academia.model.dao.utilDao.ConnectionFactory;

//import minhacidademelhor.model.dao.utilDao.ConnectionFactory;
//import minhacidademelhor.model.Pessoa;
//import minhacidademelhor.model.Sexo;
public class PessoaDao {
	
	Connection con;
	private Statement statement;
	private PreparedStatement preparedStatement;
	
	public PessoaDao()
	{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		con = connectionFactory.getConnection();
		
	}
	
	public List<Pessoa> listarPessoas(){
		List<Pessoa> pessoas = new ArrayList();
		ResultSet set;
		
		try {
			statement = con.createStatement();
			set = statement.executeQuery("select * from pessoa;");
					
					while (set.next()) {
						Pessoa pessoa = new Pessoa();
						pessoa.setId(set.getInt("id"));
						pessoa.setNome(set.getString("nome"));
						pessoa.setDataNascimento(convertToLocalDateViaSqlDate(set.getDate("dataNascimento")));
						pessoa.setEndereco(set.getString("endereco"));
						pessoa.setTelefone(set.getString("telefone"));		
						pessoa.setEmail(set.getString("email"));
						pessoa.setSexo(set.getString("sexo"));
					//	pessoa.setDataNascimento(convertToLocalDateViaSqlDate(set.getDate("dataNascimento")));
						pessoa.setDataCadastro(convertToLocalDateViaSqlDate(set.getDate("dataNascimento")));
						
						pessoas.add(pessoa);
					}
			
		}
		catch(Exception e) {
			
			System.err.println("erro ao listar pessoa" + e.getMessage());
			
		}
		return pessoas;
		
	}
	
	public boolean salvarPessoa(Pessoa pessoa) {
		boolean isSalvo = false;
		/*String queryPessoa = 
		"INSERT INTO pessoa (nome,dataNascimento,endereco,telefone,email,sexo,dataCadastro)"+ "values(?,?,?,?,?,?,?);";
		
		String queryEndereco = "insert to indereco ("
				+"rua,numero,complemento,bairro,bairro,cidade,estado,tipoEndereco,idPessoa"
				+"values(?,?,?,?,?,?,?,?,?);";
				*/
		String query = "insert into pessoa (nome,dataNascimento,endereco,telefone,email,sexo,dataCadastro)"
				+ "values (?,?,?,?,?,?,?);";
		try {
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, pessoa.getNome());
			preparedStatement.setDate(2, java.sql.Date.valueOf(pessoa.getDataNascimento()) );
			preparedStatement.setString(3, pessoa.getEndereco());
			preparedStatement.setString(4, pessoa.getTelefone());
			preparedStatement.setString(5,pessoa.getEmail());
			preparedStatement.setString(6, pessoa.getSexo());
			preparedStatement.setDate(7 ,java.sql.Date.valueOf(pessoa.getDataCadastro()) );
			
			//preparedStatement.execute(query);
			preparedStatement.execute();
		//	preparedStatement.executeUpdate();
			con.commit();			
			isSalvo = true;
			
		}
		catch(Exception e){
			
			System.out.println("Errp ao inserrir pessoa:" + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}
	
	public boolean editarPessoa(Pessoa pessoa) {
		boolean isSalvo = false;
		
		 String query = "UPDATE PESSOA "
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
			preparedStatement.setString(1, pessoa.getNome());
			preparedStatement.setDate(2, java.sql.Date.valueOf(pessoa.getDataNascimento()) );
			preparedStatement.setString(3, pessoa.getEndereco());
			preparedStatement.setString(4, pessoa.getTelefone());
			preparedStatement.setString(5,pessoa.getEmail());
			preparedStatement.setString(5, pessoa.getSexo());
			preparedStatement.setDate(6 ,java.sql.Date.valueOf(pessoa.getDataCadastro()) );
			
			//preparedStatement.execute(query);
		//	preparedStatement.execute();
			preparedStatement.executeUpdate();
			con.commit();			
			isSalvo = true;
			
		}
		catch(Exception e){
			
			System.out.println("Errp ao EDITAR pessoa:" + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}
		
	public boolean deletarPessoa(long id) {
		boolean isSalvo = false;
		
		 String query = "delete from pessoa where id = ?";
	
		
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
			
			System.out.println("Errp ao DELETAR pessoa:" + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}

	/*public boolean salvarPessoaComEndereco(Pessoa pessoa) {
		boolean isSalvo = false;
		String query = "insert into pessoa (nome,cpf,email,telefone,sexo,dataNascimento)"
				+ "values(?,?,?,?,?,?);";

		try {
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, pessoa.getNome());
			preparedStatement.setDate(2, java.sql.Date.valueOf(pessoa.getDataNascimento()) );
			preparedStatement.setString(3, pessoa.getEndereco());
			preparedStatement.setString(4, pessoa.getTelefone());
			preparedStatement.setString(5,pessoa.getEmail());
			preparedStatement.setString(5, pessoa.getSexo());
			preparedStatement.setDate(6 ,java.sql.Date.valueOf(pessoa.getDataCadastro()) );
			
			//preparedStatement.execute(query);
		//	preparedStatement.execute();
			preparedStatement.executeUpdate();
			con.commit();			
			isSalvo = true;
			
		}
		catch(Exception e){
			
			System.out.println("Errp ao inserrir pessoa:" + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}*/
	
	public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
	    return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
	}
	
	

}
