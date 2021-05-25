package academia.main;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import academia.controller.ModalidadeController;
import academia.controller.PessoaController;
import academia.controller.ProfessorController;
import academia.model.*;


public class mainAux {
	
	PessoaController pessoaContorller = new PessoaController();
	ProfessorController professorController = new ProfessorController();
	ModalidadeController modalidadeController = new ModalidadeController();
	
	public void listPessoaAllAux() {
	List<Pessoa> pessoas = pessoaContorller.listarPessoas();
	for(Pessoa atual: pessoas) {
		System.out.println("Id: " +atual.getId());
		System.out.println("Nome:" + atual.getNome());
		System.out.println("Data de Nascimento: "+ atual.getDataNascimento().toString());
		System.out.println("Endere�o" + atual.getEndereco());
		System.out.println("Email: "+ atual.getEmail());
		System.out.println("Sexo: "+ atual.getSexo());
		System.out.println("Data de nascimento: "+ atual.getDataCadastro().toString());
		
		System.out.println("\n\n");
	}
	
	}


	public void addPessoa(int num) {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Pessoa " + num);
		pessoa.setDataNascimento(LocalDate.of(2005, 05, 15));
		pessoa.setEndereco("Rua 611 Qd. 511");
		pessoa.setTelefone("(62)98765-8547");
		pessoa.setEmail("pessoa"+num+"@pessoaT.com");
		pessoa.setSexo("Masculico");
		pessoa.setDataCadastro(LocalDate.of(2001, 05, 15));
		
		pessoaContorller.salvarPessoa(pessoa);

		
		System.out.println("--------Pessoa adicionada------------");
		
	}
	
	
	public void editarPessoa(int num, int id) {
		//Pessoa pessoa = new Pessoa();
		Pessoa pessoaEditada = new Pessoa();
		/*
		pessoa.setNome("EDITADO " + num);
		pessoa.setDataNascimento(LocalDate.of(2005, 05, 15));
		pessoa.setEndereco("Rua 611 Qd. 511");
		pessoa.setTelefone("(62)98765-8547");
		pessoa.setEmail("pessoa"+num+"@pessoaT.com");
		pessoa.setSexo("Masculico");
		pessoa.setDataCadastro(LocalDate.of(2001, 05, 15));
		*/
		List<Pessoa> pessoas = pessoaContorller.listarPessoas();
		for (Iterator iterator = pessoas.iterator(); iterator.hasNext();) {
			Pessoa pessoa2 = (Pessoa) iterator.next();
			if(pessoa2.getId() == id) {
				pessoaEditada = pessoa2;
			}
			
		}
		
		
	
		pessoaEditada.setNome("Pessoa EDITADA" + num);
		pessoaEditada.setDataNascimento(LocalDate.of(2005, 05, 15));
		pessoaEditada.setEndereco("Rua 611 Qd. 511");
		pessoaEditada.setTelefone("(62)98765-8547");
		pessoaEditada.setEmail("pessoaEditada"+num+"@pessoaEditadaT.com");
		pessoaEditada.setSexo("Masculico");
		pessoaEditada.setDataCadastro(LocalDate.of(2001, 05, 15));
		
		
		
		pessoaContorller.editarPessoa(pessoaEditada);

		
		System.out.println("--------Pessoa foi editada------------");
		
	}

	public void delearPessoa() {
		
		listPessoaAllAux();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Qual o ID da pesso aque voce quer deletar ?");
		int id = sc.nextInt(); 
		
		pessoaContorller.deletarPessoa(id);
		
		System.out.println("--------PESSOA COM O ID "+id+" DELETADA! ");
		System.out.println(" | '-' | ");
		
		
		
	}
	
	public void listProfessoresAllAux() {
	List<Professor> professores = professorController.listarProfessores();
	for(Professor atual: professores) {
		System.out.println("----------Professor-----------");
		System.out.println("Id: " +atual.getId());
		System.out.println("Nome:" + atual.getNome());
		System.out.println("Data de Nascimento: "+ atual.getDataNascimento().toString());
		System.out.println("Endere�o" + atual.getEndereco());
		System.out.println("Email: "+ atual.getEmail());
		System.out.println("Sexo: "+ atual.getSexo());
		System.out.println("Data de nascimento: "+ atual.getDataCadastro().toString());
		
		System.out.println("\n\n");
	}
	}
	
	public void addProfessor(int num) {
		Professor professor = new Professor();
		professor.setNome("Professor " + num);
		professor.setDataNascimento(LocalDate.of(2005, 05, 15));
		professor.setEndereco("Rua 611 Qd. 511");
		professor.setTelefone("(62)98765-8547");
		professor.setEmail("professor"+num+"@professorT.com");
		professor.setSexo("Masculico");
		professor.setDataCadastro(LocalDate.of(2001, 05, 15));
		
		professorController.salvarProfessor(professor);

		
		System.out.println("--------Professor extend Pessoa adicionada------------");
		
	}

	public void editarProfessor(int num, int id) {
	
		Professor professorEditado = new Professor();

		List<Professor> professores = professorController.listarProfessores();
		for (Iterator iterator = professores.iterator(); iterator.hasNext();) {
			Professor professor2 = (Professor) iterator.next();
			if(professor2.getId() == id) {
				professorEditado = professor2;
			}
			
		}	
		professorEditado.setNome("Professora EDITADA" + num);
		professorEditado.setDataNascimento(LocalDate.of(2005, 05, 15));
		professorEditado.setEndereco("Rua da edi��o");
		professorEditado.setTelefone("(62)98765-8547");
		professorEditado.setEmail("pessoaEditada"+num+"@pessoaEditadaT.com");
		professorEditado.setSexo("Feminino");
		professorEditado.setDataCadastro(LocalDate.of(2001, 05, 15));
		
		
		
		professorController.editarProfessor(professorEditado);

		
		System.out.println("--------Professor foi editada------------");
		
	}
	
	public void delearProfessor() {
		
		listProfessoresAllAux();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Qual o ID da pesso aque voce quer deletar ?");
		int id = sc.nextInt(); 
		
		professorController.deletarProfessor(id);
		
		System.out.println("--------PROFESSOR COM O ID "+id+" DELETADO! ");
		System.out.println(" | '-' | ");
		
		
		
	}
	public void listModalidadeAllAux() {
		List<Modalidade> modalidades = modalidadeController.listarModalidades();
		for(Modalidade atual: modalidades) {
			System.out.println("Id: " +atual.getIdModalidade());
			System.out.println("Nome:" + atual.getNome());
			System.out.println("Descri��o modalidade: "+ atual.getDescricao());
			
			System.out.println("\n\n");
		}
		
		}


	public void addProfessroComModalidades(int num) {
		
		Professor professor = new Professor();
		professor.setNome("Professor" + num);
		professor.setDataNascimento(LocalDate.of(2005, 05, 25));
		professor.setEndereco("Endere�i do professor" + num);
		professor.setTelefone("(62)98455-8987");
		professor.setEmail("professeor"+ num +"@unialfa.com");
		professor.setSexo("Masculico");
		professor.setDataCadastro(LocalDate.of(2001, 05, 15));
		
		Modalidade modalidade = new Modalidade();
		Modalidade modalidade2 = new Modalidade();
		
		modalidade.setNome("Judo");
		modalidade.setDescricao("Aula de artes marciais");
		
		modalidade2.setNome("Modalidade " + num);
		modalidade2.setDescricao("Descri��o modalidade: " + num);
		
		List<Modalidade> modalidades = new ArrayList();
		modalidades.add(modalidade);
		modalidades.add(modalidade2);
		
		professor.setModalidade(modalidades);
		
		try {
			professorController.salvarProfessroComModalidades(professor);
			System.out.println("--------Professro Com Modalidades adicionado------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
}