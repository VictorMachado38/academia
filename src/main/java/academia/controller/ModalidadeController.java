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
	/*
	public boolean salvarPessoa(Pessoa pessoa) {
		modalidadeDao = new ModalidadeDao();
		boolean isSalvo = modalidadeDao.salvarPessoa(pessoa);
		return isSalvo;
			
	}
	
	public boolean editarPessoa(Pessoa pessoa) {
		modalidadeDao = new ModalidadeDao();
		boolean isSalvo = modalidadeDao.editarPessoa(pessoa);
		return isSalvo;
			
	}
	public boolean deletarPessoa(long id) {
		modalidadeDao = new ModalidadeDao();
		boolean isSalvo = modalidadeDao.deletarPessoa(id);
		return isSalvo;
			
	}
*/
	

}
