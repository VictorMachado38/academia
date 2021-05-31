package academia.funcionario;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import academia.controller.FuncionarioController;
import academia.model.Funcionario;

class testFuncionario {

	FuncionarioController funcionarioController = new FuncionarioController();
	List<Funcionario> funcionariosTeste = funcionarioController.listarFuncionarios();
	
	@Test
	void listarFuncionarioTeste() {
		Funcionario funcionario = new Funcionario();
		funcionario.setId(1);
		List<Funcionario> funcionarios = funcionarioController.listarFuncionarios();
		assertTrue(!funcionarios.isEmpty());
		
		funcionario.setNome("Aluno de BOX");
		assertTrue(funcionario.getNome().equals(funcionarioController.listarFuncionarios().get(0).getNome()));
	}
	
	@Test
	void salvarFuncionario() {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("FUNCIONARIA" );
		funcionario.setDataNascimento(LocalDate.of(2005, 05, 15));
		funcionario.setEndereco("Rua TESTE");
		funcionario.setTelefone("(62)98765-8547");
		funcionario.setEmail("TESTE@TESTE.com");
		funcionario.setSexo("Feminino");
		funcionario.setDataCadastro(LocalDate.of(2001, 05, 15));

		
		assertTrue(funcionarioController.salvarFuncionario(funcionario));
		
	}
	
	@Test
	public void criarFuncionario() {
//      criar
      assertNotNull( funcionarioController.create());
	}
	
	@Test
	  void list() {
//	        listar Funcionario
		List<Funcionario> funcionarios = funcionarioController.listarFuncionarios();
        assertTrue(funcionarios.size()>0);


	    }
}
