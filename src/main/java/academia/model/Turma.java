package academia.model;

import java.util.List;

public class Turma {

	private int id;

	private String nome;

	private int idProfessor; // esse atributo será uma chave estrageneria

	private int maxAluno;

	private String horario;

	private String descTurma;
	

	// private int vagas;

	private List<Aluno> alunos;
	

	public Turma() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}

	public int getMaxAluno() {
		return maxAluno;
	}

	public void setMaxAluno(int maxAluno) {
		this.maxAluno = maxAluno;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getDescTurma() {
		return descTurma;
	}

	public void setDescTurma(String descTurma) {
		this.descTurma = descTurma;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	

}
