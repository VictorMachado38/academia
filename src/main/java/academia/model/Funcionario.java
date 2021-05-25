package academia.model;

public class Funcionario extends Pessoa {

	
	private String funcao;
	private String descFuncao;
	
	
	
	public Funcionario() {
		super();
	}
	
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public String getDescFuncao() {
		return descFuncao;
	}
	public void setDescFuncao(String descFuncao) {
		this.descFuncao = descFuncao;
	}
	
	
	
	
}
