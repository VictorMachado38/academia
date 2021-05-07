package academia.model;

public class Funcionario extends Pessoa {

	private int id;
	private String funcao;
	private String descFuncao;
	
	
	
	public Funcionario() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
