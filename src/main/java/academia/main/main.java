package academia.main;

import java.util.List;

import academia.controller.PessoaController;
import academia.model.*;
import academia.model.Pessoa;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PessoaController pessoaContorller = new PessoaController();
		
		
		
		List<Pessoa> pessoas = pessoaContorller.listarPessoas();
		for(Pessoa atual: pessoas) {
			System.out.println("Nome:" + atual.getNome());
			System.out.println("Email: "+ atual.getEmail());
			System.out.println("Endereço" + atual.getEndereco());
			System.out.println("\n\n");
		}

		

	}

}
