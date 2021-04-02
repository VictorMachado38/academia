package academia.model;

import java.util.List;

public class Turma {

	private long id;
	private String nome;
	
	private long idProfessor; //esse atributo será uma chave estrageneria 
	
	private int maxAluno;
	
	private Horario horario;
	
	private int vagas;
	
	private List<Aluno> alunos;

	
	
	public Turma() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(long idProfessor) {
		this.idProfessor = idProfessor;
	}

	public int getMaxAluno() {
		return maxAluno;
	}

	public void setMaxAluno(int maxAluno) {
		this.maxAluno = maxAluno;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	
	
	
	

}
