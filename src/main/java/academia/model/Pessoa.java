package academia.model;

import java.time.LocalDate;

public class Pessoa {
	
	private long id;
	private String nome;
	private LocalDate dataDascimento;
	private String endereco;
	private String telefone;
	private String email;
	private char sexo;
	private LocalDate dataCadastro;
	
		
	public Pessoa() {
		super();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataDascimento() {
		return dataDascimento;
	}
	public void setDataDascimento(LocalDate dataDascimento) {
		this.dataDascimento = dataDascimento;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
	

}
