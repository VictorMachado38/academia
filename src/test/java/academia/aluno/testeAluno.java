package academia.aluno;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import academia.controller.AlunoController;
import academia.model.Aluno;
import academia.model.Pessoa;

class testeAluno {

	AlunoController alunoController = new AlunoController();
	
	
	@Test
	public void deletarAluno() {
		Aluno aluno = new Aluno();
		alunoController.deletarAluno(1);
		
		aluno.setId(1);
		
		//assertTrue(aluno.getId().equals(alunoController.listarAlunos().get(0).getId()));
		
	}

}
