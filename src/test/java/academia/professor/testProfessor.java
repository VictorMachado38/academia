package academia.professor;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import academia.model.Professor;

import academia.controller.ProfessorController;

class testProfessor {

	ProfessorController professorController = new ProfessorController();
	List<Professor> professorsTeste = professorController.listarProfessores();
	
	@Test
	void listarProfessorTeste() {
		Professor professor = new Professor();
		professor.setId(1);
		List<Professor> professors = professorController.listarProfessores();
		assertTrue(!professors.isEmpty());
		
		professor.setNome("Professor de BOX");
		assertTrue(professor.getNome().equals(professorController.listarProfessores().get(0).getNome()));
	}
	
	@Test
	void salvarProfessor() {
		Professor professor = new Professor();
		professor.setNome("TESTE " );
		professor.setDataNascimento(LocalDate.of(2005, 05, 15));
		professor.setEndereco("Rua TESTE");
		professor.setTelefone("(62)98765-8547");
		professor.setEmail("TESTE@TESTE.com");
		professor.setSexo("Masculico");
		professor.setDataCadastro(LocalDate.of(2001, 05, 15));

		
		assertTrue(professorController.salvarProfessor(professor));
		
	}
	
	@Test
	public void criarProfessor() {
//      criar
      assertNotNull( professorController.create());
	}
	
	@Test
	  void list() {
//	        listar Professor
		List<Professor> professors = professorController.listarProfessores();
        assertTrue(professors.size()>0);


	    }

}
