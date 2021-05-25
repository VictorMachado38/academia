package academia.controller;

import java.util.List;

import academia.model.Plano;
import academia.model.dao.PlanoDao;


public class PlanoController {
	
	PlanoDao planoDao = new PlanoDao();

	public List<Plano> listarPlanos() {
		PlanoDao planoDao = new PlanoDao();
		List<Plano> planos;
		return planos = planoDao.listarPlanos();
	}

	/*
	public boolean salvarPlano(Plano plano) {
		planoDao = new PlanoDao();
		boolean isSalvo = planoDao.salvarPlano(plano);
		return isSalvo;

	}

	public boolean editarPlano(Plano plano) {
		planoDao = new PlanoDao();
		boolean isSalvo = planoDao.editarPlano(plano);
		return isSalvo;

	}

	public boolean deletarPlano(long id) {
		planoDao = new PlanoDao();
		boolean isSalvo = planoDao.deletarPlano(id);
		return isSalvo;

	}
	*/

}
