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
						modalidade.setIdModalidade(set.getInt("idModalidade"));
						modalidade.setNome(set.getString("nome"));
						modalidade.setDescricao(set.getString("descricao"));
						
						modalidades.add(modalidade);
					}
			
		}
		catch(Exception e) {
			
			System.err.println("erro ao listar Modalidade: " + e.getMessage());
			
		}
		return modalidades;
		
	}
	
	public boolean salvarvModalidade(Modalidade modalidade) {
		boolean isSalvo = false;
		/*String queryPessoa = 
		"INSERT INTO pessoa (nome,dataNascimento,endereco,telefone,email,sexo,dataCadastro)"+ "values(?,?,?,?,?,?,?);";
		
		String queryEndereco = "insert to indereco ("
				+"rua,numero,complemento,bairro,bairro,cidade,estado,tipoEndereco,idPessoa"
				+"values(?,?,?,?,?,?,?,?,?);";
				*/
		String query = "insert into modalidade (nome,descricao)"
				+ "values (?,?);";
		try {
			
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, modalidade.getNome());
			preparedStatement.setString(1, modalidade.getDescricao());
			
			//preparedStatement.execute(query);
			preparedStatement.execute();
		//	preparedStatement.executeUpdate();
			con.commit();			
			isSalvo = true;
			
		}
		catch(Exception e){
			
			System.out.println("Errp ao inserrir modalidade:" + e.getMessage());
			isSalvo = false;			
				
		}
		
		return isSalvo;
	}
	
	/*
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

	public boolean salvarPessoaComEndereco(Pessoa pessoa) {
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



