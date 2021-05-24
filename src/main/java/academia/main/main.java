package academia.main;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import academia.controller.PessoaController;
import academia.controller.ProfessorController;
import academia.model.*;
import academia.model.Pessoa;
//import minhacidademelhor.model.Sexo;


public class main {

	public static void main(String[] args) {
	
		ProfessorController professorController = new ProfessorController();
		mainAux mainAux = new mainAux();

		//VOCE DEVE PASSAR UM NOMERO SO PARA 
		//	mainAux.addPessoa(2); // OK
		//	mainAux.editarPessoa(3); // OK
		//	mainAux.delearPessoa(); // OK
	
		
	//	mainAux.listPessoaAllAux();
	//	mainAux.listModalidadeAllAux();
	//	mainAux.addProfessroComModalidades(1);
		
		/*
		Professor professor = new Professor();
		professor.setNome("Professor" );
		professor.setDataNascimento(LocalDate.of(2005, 05, 25));
		professor.setEndereco("aaaa");
		professor.setTelefone("ddd");
		professor.setEmail("pecccssoa@pessoaT.com");
		professor.setSexo("Mascuxxxlico");
		professor.setDataCadastro(LocalDate.of(2001, 05, 15));
		
		Modalidade modalidade = new Modalidade();
		
		modalidade.setNome("JUDO");
		modalidade.setDescricao("AULA DA JUDO MUITO BOA");
		
		List<Modalidade> modalidades = new ArrayList();
		modalidades.add(modalidade);
		modalidades.add(modalidade);
		
		professor.setModalidade(modalidades);
		
		try {
			professorController.salvarProfessroComModalidades(professor);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
		
		
		
		PessoaController pessoaContorller = new PessoaController();
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("VICTOR ");
		pessoa.setDataNascimento(LocalDate.of(2005, 05, 15));
		pessoa.setEndereco("Rua 611 Qd. 511");
		pessoa.setTelefone("(62)98765-8547");
		pessoa.setEmail("pessoaT@pessoaT.com");
		pessoa.setSexo("Masculico");
		pessoa.setDataCadastro(LocalDate.of(2001, 05, 15));
		
		pessoaContorller.salvarPessoa(pessoa);

		
		System.out.println("--------Pessoa adicionada------------");
		
		
		
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
		*/
	

		
		

	}

}
