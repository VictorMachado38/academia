package academia.model;

import java.math.BigDecimal;

public class Plano {

	private int id;
	private String nomeDoPlano;
	private BigDecimal valor;
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

	public BigDecimal getValor() {
		return valor;
	}
	

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}


	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

}
