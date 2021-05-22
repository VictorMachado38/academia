package academia.main;

import java.time.LocalDate;
import java.util.List;

import academia.controller.PessoaController;
import academia.model.*;
import academia.model.Pessoa;
//import minhacidademelhor.model.Sexo;

public class main {

	public static void main(String[] args) {
	
		
		// TODO Auto-generated method stub
		PessoaController pessoaContorller = new PessoaController();
		
		Pessoa pessoa = new Pessoa();
		//pessoa.setId(10);
		pessoa.setNome("VICTOR ");
		pessoa.setDataNascimento(LocalDate.of(2005, 05, 15));
		pessoa.setEndereco("Rua 611 Qd. 511");
		pessoa.setTelefone("(62)98765-8547");
		pessoa.setEmail("pessoaT@pessoaT.com");
		pessoa.setSexo("Masculico");
		pessoa.setDataCadastro(LocalDate.of(2001, 05, 15));
		
		pessoaContorller.salvarPessoa(pessoa);
		//pessoa.setTelefone("(62)3233-4444");
		
		System.out.println("--------------------");
		
		
		
		List<Pessoa> pessoas = pessoaContorller.listarPessoas();
		for(Pessoa atual: pessoas) {
			System.out.println("Nome:" + atual.getNome());
			System.out.println("Email: "+ atual.getEmail());
			System.out.println("Endereço" + atual.getEndereco());
			System.out.println("\n\n");
		}

		

	}

}
