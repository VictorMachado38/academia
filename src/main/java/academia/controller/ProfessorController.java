package academia.controller;

import java.sql.SQLException;
import java.util.List;

import academia.model.Professor;
import academia.model.dao.ProfessorDao;


public class ProfessorController {
	
	ProfessorDao professorDao = new ProfessorDao();
	
	
	public List<Professor> listarProfessores(){
		professorDao = new ProfessorDao();
		 List<Professor> professor; 
		 return professor = professorDao.listarProfessor();
//		 return null;
	}
	
	public Professor create() {
		Professor professor = new Professor();
		return professor;
			
	}

	public boolean salvarProfessor(Professor professor) {
		professorDao = new ProfessorDao();
		boolean isSalvo = professorDao.salvarProfessor(professor);
		return isSalvo;
	}
	
	public boolean editarProfessor(Professor professor) {
		professorDao = new ProfessorDao();
		boolean isSalvo = professorDao.editarProfessor(professor);
		return isSalvo;
	}
	
	public boolean deletarProfessor(int id) {
		professorDao = new ProfessorDao();
		boolean isSalvo = professorDao.deletarProfessor(id);
		return isSalvo;
	}
	
	public boolean salvarProfessroComModalidades(Professor professor) throws SQLException {
		professorDao = new ProfessorDao();
		boolean isSalvo = professorDao.salvarProfessroComModalidades(professor);
		return isSalvo;
	}

}
