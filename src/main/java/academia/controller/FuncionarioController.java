package academia.controller;

import java.util.List;

import academia.model.Funcionario;
import academia.model.dao.FuncionarioDao;

public class FuncionarioController {

	FuncionarioDao funcionarioDao;

	public List<Funcionario> listarFuncionarios() {
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		List<Funcionario> pessoas;
		return pessoas = funcionarioDao.listarFuncionarios();
	}

	public Funcionario create() {
		Funcionario funcionario = new Funcionario();
		return funcionario;
			
	}
	public boolean salvarFuncionario(Funcionario pessoa) {
		funcionarioDao = new FuncionarioDao();
		boolean isSalvo = funcionarioDao.salvarFuncionario(pessoa);
		return isSalvo;

	}

	public boolean editarFuncionario(Funcionario pessoa) {
		funcionarioDao = new FuncionarioDao();
		boolean isSalvo = funcionarioDao.editarFuncionario(pessoa);
		return isSalvo;

	}

	public boolean deletarFuncionario(long id) {
		funcionarioDao = new FuncionarioDao();
		boolean isSalvo = funcionarioDao.deletarFuncionario(id);
		return isSalvo;

	}

}
