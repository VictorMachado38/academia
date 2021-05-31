package academia.controller;

import java.util.List;

import academia.model.Modalidade;
import academia.model.dao.ModalidadeDao;
import academia.model.dao.PessoaDao;

public class ModalidadeController {
	
	ModalidadeDao modalidadeDao;
	
	public List<Modalidade> listarModalidades(){
		ModalidadeDao modalidadeDao = new ModalidadeDao();
		List<Modalidade> modalidades;
		return modalidades = modalidadeDao.listarModalidade();
		}

	public Modalidade create() {
		Modalidade modalidade = new Modalidade();
		return modalidade;
			
	}
	
	public boolean salvarModalidade(Modalidade modalidade) {
		modalidadeDao = new ModalidadeDao();
		boolean isSalvo = modalidadeDao.salvarModalidade(modalidade);
		return isSalvo;
			
	}
	
	public boolean editarModalidade(Modalidade modalidade) {
		modalidadeDao = new ModalidadeDao();
		boolean isSalvo = modalidadeDao.editarModalidade(modalidade);
		return isSalvo;
			
	}
	
	public boolean deletarModalidade(long id) {
		modalidadeDao = new ModalidadeDao();
		boolean isSalvo = modalidadeDao.deletarModalidade(id);
		return isSalvo;
			
	}

	public Modalidade show(int idModalidade) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
