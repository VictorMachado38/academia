package academia.model;

import java.math.BigDecimal;

public class Plano {

	private int id;
	private String nomeDoPlano;
	private Double valor;
	private String descDoPlano;
	private int idAluno;

	public Plano() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeDoPlano() {
		return nomeDoPlano;
	}

	public void setNomeDoPlano(String nomeDoPlano) {
		this.nomeDoPlano = nomeDoPlano;
	}

	public Double getValor() {
		return valor;
	}
	

	public void setValor(Double valor) {
		this.valor = valor;
	}


	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public String getDescDoPlano() {
		return descDoPlano;
	}

	public void setDescDoPlano(String descDoPlano) {
		this.descDoPlano = descDoPlano;
	}
	

}
