package academia.controller;

import java.util.List;

import academia.model.Aluno;
import academia.model.dao.AlunoDao;

public class AlunoController {

	AlunoDao alunoDao = new AlunoDao();

	public List<Aluno> listarAlunos() {
		AlunoDao alunoDao = new AlunoDao();
		List<Aluno> alunos;
		return alunos = alunoDao.listarAlunos();
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

}
