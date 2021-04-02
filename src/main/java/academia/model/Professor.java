package academia.model;

import java.util.List;

public class Professor extends Pessoa

	{

	private long idProfessor;

	private List<Modalidade> Modalidade;


	
	public Professor() {
		super();
	}


	public long getIdProfessor() {
		return idProfessor;
	}


	public void setIdProfessor(long idProfessor) {
		this.idProfessor = idProfessor;
	}


	public List<Modalidade> getModalidade() {
		return Modalidade;
	}


	public void setModalidade(List<Modalidade> modalidade) {
		Modalidade = modalidade;
	}
	
	
	
	
}
