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

		//	VOCE DEVE PASSAR UM NOMERO SO PARA 
//			mainAux.addPessoa(2); // OK Tem que passar um int que vai ser adicionada no nome da PESSOA, para ajudar nos testes
//			mainAux.listarPessoas(); // OK
//			mainAux.editarPessoa(99,3); // tem passar um 2 int, um para ficar mais facil de olhar no banco e o um ID para editar
//			mainAux.delearPessoa(); // OK
//		
//		
//			mainAux.listarProfessores();
//			mainAux.addProfessor(10); // Recebe um int que vai para o nome do professror para ajudar nos testes
//			mainAux.editarProfessor(55,4); // tem passar um 2 int, um para ficar mais facil de olhar no banco e o um ID para editar
//			mainAux.delearProfessor();
//			mainAux.addProfessroComModalidades(70); //Tem que passar um int que vai ser adicionada no nome do PROFESSOR e e nome da MODALIDADE, para ajudar nos testes
//		
//		
//		
//			
//			mainAux.addModalidade(10); // Tem que passar um int que vai ser adicionada no nome da PESSOA, para ajudar nos testes
//			mainAux.listarModalidades();
//			mainAux.editarModalidade(7777, 9); // tem passar um 2 int, um para ficar mais facil de olhar no banco e o um ID para editar
//			mainAux.delearModalidades();
//		
//		
//			mainAux.listarFuncionarios();
//			mainAux.addFuncionario(99); // Tem que passar um int que vai ser adicionada no nome do Funcionario, para ajudar nos testes
//			mainAux.editarFuncionario(100, 3); // tem passar um 2 int, um para ficar mais facil de olhar no banco e o um ID para editar
//			mainAux.deletarFuncionario();
//		
//		
//			mainAux.listarAlunos();
//			mainAux.addAluno(33);
//			mainAux.editarAluno(77, 3); // recebe dois INT um vai para o nome do aluno e o outro qual ID vai ser editado
//		 	mainAux.deletarAluno();
//	
//			mainAux.listarPlanos();
//			mainAux.salvarAlunoComPlano(10);
//			mainAux.addPlano(50, 50.0); //Aqui recebe um INT e um Double o int vai para o nome do plano (para ajduar nos testes) e o Dolve é o valor do plano;
//			mainAux.editarPlano(71, 888.88, 5); //Aqui recebe INT = parecer no nome do banco /DOUBLE = Novo valor do plano / INT = id do plano que ira ser editado;
//			mainAux.deletarPlano();
//		
//		
//		
//			mainAux.listarTurmas();
//			mainAux.salvarTurmaComAlunosEProfessor(77, 99); // Aqui recebe dois INT um vai para o nome do professor e do aluno e ou outro é a quantidade maxima de aluno
//			mainAux.addTurma(14, 33); //Recebe dois INT o primeiro vai para o nome da turma e o segundo é a quantidade maxima de alunos
//			mainAux.editarTurma(15, 4); //Recebe dois INT o primeiro vai para o nome da turma e o segundo é o ID da turma que vai ser editada
//			mainAux.delearTurma();
//		
//		
//			mainAux.listarSalaDeAulas();
//			mainAux.addSalaDeAula(14, 1); // Aqui vai são 2 INT o primeiro corresponde ao numero da sala e o segundo ao ID da turma vinculada
//			mainAux.editarSalaDeAula(55,1,3); //Aqui recebe 3 int primeiro para o novo numero, segundo para o novo Id da turma, e o terceiro para o ID que quero editar
//			mainAux.delearSalaDeAula();
//		
//			mainAux.salvarTurmaComAlunosEProfessorESalaDeAula(2525, 50, 99); // Esse ultimo eu fiz vinculando tudo!

	}

}
