package academia.aluno;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import academia.controller.AlunoController;
import academia.model.Aluno;
import academia.model.Pessoa;
import academia.model.Turma;
import academia.view.View;

class testeAluno {

	AlunoController alunoController = new AlunoController();
	View view = new View();
	
	
	@Test
	public void criraAluno() {
//        criar
        assertNotNull( alunoController.create());
	}
	
	
	@Test
	public void deletarAluno() {
			List<Aluno> alunos = alunoController.listarAlunos();
	     Aluno aluno = alunoController.show(alunos.get(0).getId());

		alunoController.deletarAluno(aluno.getId());
		
	}
	
	@Test
    void list() {
//        listar turmas
		 List<Aluno> alunos = alunoController.listarAlunos();
	      assertTrue(alunos.size()>0);
//        mostrar turmas

    }

}
