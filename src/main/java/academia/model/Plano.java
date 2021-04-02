package academia.model;

import java.math.BigDecimal;

public class Plano {

	private long Plano;
	private String nomeDoPlano;
	private BigDecimal valor;
	
	
	
	public Plano() {
		super();
	}
	public long getPlano() {
		return Plano;
	}
	public void setPlano(long plano) {
		Plano = plano;
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
	
	
}
