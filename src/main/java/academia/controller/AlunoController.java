package academia.controller;

import java.sql.SQLException;
import java.util.List;

import academia.model.Aluno;

import academia.model.dao.AlunoDao;
import academia.model.dao.ProfessorDao;

public class AlunoController {

	AlunoDao alunoDao = new AlunoDao();

	public List<Aluno> listarAlunos() {
		AlunoDao alunoDao = new AlunoDao();
		List<Aluno> alunos;
		return alunos = alunoDao.listarAlunos();
	}
	
	public Aluno create() {
		Aluno aluno = new Aluno();
		return aluno;
			
	}

	public boolean salvarAluno(Aluno aluno) {
		alunoDao = new AlunoDao();
		boolean isSalvo = alunoDao.salvarAluno(aluno);
		return isSalvo;

	}

	public boolean editarAluno(Aluno aluno) {
		alunoDao = new AlunoDao();
		boolean isSalvo = alunoDao.editarAluno(aluno);
		return isSalvo;

	}

	public boolean deletarAluno(long id) {
		alunoDao = new AlunoDao();
		boolean isSalvo = alunoDao.deletarAluno(id);
		return isSalvo;

	}
	
	public boolean salvarAlunoComPlano(Aluno aluno) throws SQLException {
		alunoDao = new AlunoDao();
		boolean isSalvo = alunoDao.salvarAlunoComPlano(aluno);
		return isSalvo;
	}

	public Aluno show(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
