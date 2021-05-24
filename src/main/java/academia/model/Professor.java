package academia.model;

import java.util.List;

public class Professor extends Pessoa{

//	private int idProfessor; //auto incremente
//	private int idPessoa; //add
//	private int idModalidade; //add
	private List<Modalidade> Modalidade; // ja precisa ter


	
	/*
	public int getIdPessoa() {
		return idPessoa;
	}


	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

*/
	public Professor() {
		super();
	}

/*
	public long getIdProfessor() {
		return idProfessor;
	}


	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}

*/
	/*
	public int getIdModalidade() {
		return idModalidade;
	}


	public void setIdModalidade(int idModalidade) {
		this.idModalidade = idModalidade;
	}
*/

	public List<Modalidade> getModalidade() {
		return Modalidade;
	}


	public void setModalidade(List<Modalidade> modalidade) {
		Modalidade = modalidade;
	}



	
	
	
}
