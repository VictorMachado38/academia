package academia.controller;

import academia.model.dao.ProfessorDao;
import academia.model.dao.TurmaDao;
import academia.model.Professor;
import academia.model.Turma;

import java.sql.SQLException;
import java.util.List;

public class TurmaController {
	
	TurmaDao turmaDao = new TurmaDao();
	
	public List<Turma> listarTurmas(){
		TurmaDao turmaDao = new TurmaDao();
		List<Turma> turmas;
		return turmas = turmaDao.listarTurma();
		}
	/*
	public boolean salvarTurma(Turma turma) {
		turmaDao = new TurmaDao();
		boolean isSalvo = turmaDao.salvarTurma(turma);
		return isSalvo;
			
	}
	
	public boolean editarTurma(Turma turma) {
		turmaDao = new TurmaDao();
		boolean isSalvo = turmaDao.editarTurma(turma);
		return isSalvo;
			
	}
	
	public boolean deletarTurma(long id) {
		turmaDao = new TurmaDao();
		boolean isSalvo = turmaDao.deletarTurma(id);
		return isSalvo;
			
	}
	
*/
	public boolean salvarTurmaComAlunosEProfessor(Turma turma,Professor professor) throws SQLException {
		turmaDao = new TurmaDao();
		boolean isSalvo = turmaDao.salvarTurmaComAlunosEProfessor(turma,professor);
		return isSalvo;
	}
}
