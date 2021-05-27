package academia.controller;

import academia.model.dao.SalaDeAulaDao;

import java.util.List;

import academia.model.SalaDeAula;

public class SalaDeAulaController {
	
	SalaDeAulaDao salaDeAulaDao = new SalaDeAulaDao();
	
	
	public List<SalaDeAula> listarSalaDeAulas(){
		SalaDeAulaDao salaDeAulaDao = new SalaDeAulaDao();
		List<SalaDeAula> salaDeAulas;
		return salaDeAulas = salaDeAulaDao.listarSalaDeAula();
		}
	
	public boolean salvarSalaDeAula(SalaDeAula salaDeAula) {
		salaDeAulaDao = new SalaDeAulaDao();
		boolean isSalvo = salaDeAulaDao.salvarSalaDeAula(salaDeAula);
		return isSalvo;
			
	}
	
	public boolean editarSalaDeAula(SalaDeAula salaDeAula) {
		salaDeAulaDao = new SalaDeAulaDao();
		boolean isSalvo = salaDeAulaDao.editarSalaDeAula(salaDeAula);
		return isSalvo;
			
	}
	
	public boolean deletarSalaDeAula(long id) {
		salaDeAulaDao = new SalaDeAulaDao();
		boolean isSalvo = salaDeAulaDao.deletarSalaDeAula(id);
		return isSalvo;
			
	}
	
}
