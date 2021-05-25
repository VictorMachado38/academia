package academia.model;

import java.util.List;

public class Aluno extends Pessoa{
	
	
	private int matricula;
	private List<Plano> Plano;
	
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public List<Plano> getPlano() {
		return Plano;
	}
	public void setPlano(List<Plano> plano) {
		Plano = plano;
	}
	
	

	

}
