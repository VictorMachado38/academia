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
		System.out.println("Endereço" + atual.getEndereco());
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
	
	
	public void editarPessoa(int num) {
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
		//	System.out.println("Id: " + pessoa2.getId());
		//	System.out.println("nome: "+ pessoa2.getNome());
		//	System.out.println("cpf: "+ pessoa2.getCpf());
		//	System.out.println("Data de Nascimento: "+ pessoa2.getDataNascimento().toString());
			if(pessoa2.getId() == 2) {
				pessoaEditada = pessoa2;
			}
			
		}
		
		//pessoaContorller.salvarPessoa(pessoa);
		
	
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
	
	public void listModalidadeAllAux() {
		List<Modalidade> modalidades = modalidadeController.listarModalidades();
		for(Modalidade atual: modalidades) {
			System.out.println("Id: " +atual.getIdModalidade());
			System.out.println("Nome:" + atual.getNome());
			System.out.println("Descrição modalidade: "+ atual.getDescricao());
			
			System.out.println("\n\n");
		}
		
		}


	public void addProfessroComModalidades(int num) {
		
		Professor professor = new Professor();
		professor.setNome("Professor" + num);
		professor.setDataNascimento(LocalDate.of(2005, 05, 25));
		professor.setEndereco("Endereçi do professor" + num);
		professor.setTelefone("(62)98455-8987");
		professor.setEmail("professeor"+ num +"@unialfa.com");
		professor.setSexo("Masculico");
		professor.setDataCadastro(LocalDate.of(2001, 05, 15));
		
		Modalidade modalidade = new Modalidade();
		Modalidade modalidade2 = new Modalidade();
		
		modalidade.setNome("Judo");
		modalidade.setDescricao("Aula de artes marciais");
		
		modalidade2.setNome("Modalidade " + num);
		modalidade2.setDescricao("Descrição modalidade: " + num);
		
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
