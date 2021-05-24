package academia.main;

import java.time.LocalDate;
import java.util.List;

import academia.controller.ModalidadeController;
import academia.controller.PessoaController;
import academia.model.*;
import academia.model.Pessoa;

import academia.model.Modalidade;

public class mainAux {
	
	PessoaController pessoaContorller = new PessoaController();
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


	public void addPesso(int num) {
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

	public void listModalidadeAllAux() {
		List<Modalidade> modalidades = modalidadeController.listarModalidades();
		for(Modalidade atual: modalidades) {
			System.out.println("Id: " +atual.getIdModalidade());
			System.out.println("Nome:" + atual.getNome());
			System.out.println("Descrição modalidade: "+ atual.getDescricao());
			
			System.out.println("\n\n");
		}
		
		}

}
