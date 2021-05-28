package academia.pessoa;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import academia.controller.PessoaController;
import academia.model.Pessoa;

class testePessoa {

	PessoaController pessoaController = new PessoaController();
	List<Pessoa> pessoasTeste = pessoaController.listarPessoas();
	
	@Test
	void listarPessoaTeste() {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(1);
		List<Pessoa> pessoas = pessoaController.listarPessoas();
		assertTrue(!pessoas.isEmpty());
		
		pessoa.setNome("Aluno de BOX");
		assertTrue(pessoa.getNome().equals(pessoaController.listarPessoas().get(0).getNome()));
	}
	
	@Test
	void salvarPessoa() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("TESTE " );
		pessoa.setDataNascimento(LocalDate.of(2005, 05, 15));
		pessoa.setEndereco("Rua TESTE");
		pessoa.setTelefone("(62)98765-8547");
		pessoa.setEmail("TESTE@TESTE.com");
		pessoa.setSexo("Masculico");
		pessoa.setDataCadastro(LocalDate.of(2001, 05, 15));

		
		assertTrue(pessoaController.salvarPessoa(pessoa));
		
	}

}
