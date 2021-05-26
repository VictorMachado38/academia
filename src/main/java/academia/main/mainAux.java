package academia.main;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import academia.controller.AlunoController;
import academia.controller.FuncionarioController;
import academia.controller.ModalidadeController;
import academia.controller.PessoaController;
import academia.controller.PlanoController;
import academia.controller.ProfessorController;
import academia.controller.TurmaController;
import academia.model.*;

public class mainAux {

	PessoaController pessoaContorller = new PessoaController();
	ProfessorController professorController = new ProfessorController();
	ModalidadeController modalidadeController = new ModalidadeController();
	FuncionarioController funcionarioController = new FuncionarioController();
	AlunoController alunoController = new AlunoController();
	PlanoController planoController = new PlanoController();
	TurmaController turmaController = new TurmaController();

	public void listarPessoas() {
		List<Pessoa> pessoas = pessoaContorller.listarPessoas();
		for (Pessoa atual : pessoas) {
			System.out.println("Id: " + atual.getId());
			System.out.println("Nome:" + atual.getNome());
			System.out.println("Data de Nascimento: " + atual.getDataNascimento().toString());
			System.out.println("Endereço" + atual.getEndereco());
			System.out.println("Email: " + atual.getEmail());
			System.out.println("Sexo: " + atual.getSexo());
			System.out.println("Data de nascimento: " + atual.getDataCadastro().toString());

			System.out.println("\n\n");
		}

	}

	public void addPessoa(int num) {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Pessoa " + num);
		pessoa.setDataNascimento(LocalDate.of(2005, 05, 15));
		pessoa.setEndereco("Rua 611 Qd. 511");
		pessoa.setTelefone("(62)98765-8547");
		pessoa.setEmail("pessoa" + num + "@pessoaT.com");
		pessoa.setSexo("Masculico");
		pessoa.setDataCadastro(LocalDate.of(2001, 05, 15));

		pessoaContorller.salvarPessoa(pessoa);

		System.out.println("--------Pessoa adicionada------------");

	}

	public void editarPessoa(int num, int id) {
		// Pessoa pessoa = new Pessoa();
		Pessoa pessoaEditada = new Pessoa();
		/*
		 * pessoa.setNome("EDITADO " + num); pessoa.setDataNascimento(LocalDate.of(2005,
		 * 05, 15)); pessoa.setEndereco("Rua 611 Qd. 511");
		 * pessoa.setTelefone("(62)98765-8547");
		 * pessoa.setEmail("pessoa"+num+"@pessoaT.com"); pessoa.setSexo("Masculico");
		 * pessoa.setDataCadastro(LocalDate.of(2001, 05, 15));
		 */
		List<Pessoa> pessoas = pessoaContorller.listarPessoas();
		for (Iterator iterator = pessoas.iterator(); iterator.hasNext();) {
			Pessoa pessoa2 = (Pessoa) iterator.next();
			if (pessoa2.getId() == id) {
				pessoaEditada = pessoa2;
			}

		}

		pessoaEditada.setNome("Pessoa EDITADA" + num);
		pessoaEditada.setDataNascimento(LocalDate.of(2005, 05, 15));
		pessoaEditada.setEndereco("Rua 611 Qd. 511");
		pessoaEditada.setTelefone("(62)98765-8547");
		pessoaEditada.setEmail("pessoaEditada" + num + "@pessoaEditadaT.com");
		pessoaEditada.setSexo("Masculico");
		pessoaEditada.setDataCadastro(LocalDate.of(2001, 05, 15));

		pessoaContorller.editarPessoa(pessoaEditada);

		System.out.println("--------Pessoa foi editada------------");

	}

	public void delearPessoa() {

		listarPessoas();

		Scanner sc = new Scanner(System.in);
		System.out.println("Qual o ID da pessoa aque voce quer deletar ?");
		int id = sc.nextInt();

		pessoaContorller.deletarPessoa(id);

		System.out.println("--------PESSOA COM O ID " + id + " DELETADA! ");
		System.out.println(" | '-' | ");

	}

	public void listarProfessores() {
		List<Professor> professores = professorController.listarProfessores();
		for (Professor atual : professores) {
			System.out.println("----------Professor-----------");
			System.out.println("Id: " + atual.getId());
			System.out.println("Nome:" + atual.getNome());
			System.out.println("Data de Nascimento: " + atual.getDataNascimento().toString());
			System.out.println("Endereço" + atual.getEndereco());
			System.out.println("Email: " + atual.getEmail());
			System.out.println("Sexo: " + atual.getSexo());
			System.out.println("Data de nascimento: " + atual.getDataCadastro().toString());

			System.out.println("\n\n");
		}
	}

	public void addProfessor(int num) {
		Professor professor = new Professor();
		professor.setNome("Professor " + num);
		professor.setDataNascimento(LocalDate.of(2005, 05, 15));
		professor.setEndereco("Rua 611 Qd. 511");
		professor.setTelefone("(62)98765-8547");
		professor.setEmail("professor" + num + "@professorT.com");
		professor.setSexo("Masculico");
		professor.setDataCadastro(LocalDate.of(2001, 05, 15));

		professorController.salvarProfessor(professor);

		System.out.println("--------Professor extend Pessoa adicionada------------");

	}

	public void editarProfessor(int num, int id) {

		Professor professorEditado = new Professor();

		List<Professor> professores = professorController.listarProfessores();
		for (Iterator iterator = professores.iterator(); iterator.hasNext();) {
			Professor professor2 = (Professor) iterator.next();
			if (professor2.getId() == id) {
				professorEditado = professor2;
			}

		}
		professorEditado.setNome("Professora EDITADA" + num);
		professorEditado.setDataNascimento(LocalDate.of(2005, 05, 15));
		professorEditado.setEndereco("Rua da edição");
		professorEditado.setTelefone("(62)98765-8547");
		professorEditado.setEmail("pessoaEditada" + num + "@pessoaEditadaT.com");
		professorEditado.setSexo("Feminino");
		professorEditado.setDataCadastro(LocalDate.of(2001, 05, 15));

		professorController.editarProfessor(professorEditado);

		System.out.println("--------Professor foi editada------------");

	}

	public void delearProfessor() {

		listarProfessores();

		Scanner sc = new Scanner(System.in);
		System.out.println("Qual o ID do profrssor aque voce quer deletar ?");
		int id = sc.nextInt();

		professorController.deletarProfessor(id);

		System.out.println("--------PROFESSOR COM O ID " + id + " DELETADO! ");
		System.out.println(" | '-' | ");

	}

	public void addProfessroComModalidades(int num) {

		Professor professor = new Professor();
		professor.setNome("Professor" + num);
		professor.setDataNascimento(LocalDate.of(2005, 05, 25));
		professor.setEndereco("Endereçi do professor" + num);
		professor.setTelefone("(62)98455-8987");
		professor.setEmail("professeor" + num + "@unialfa.com");
		professor.setSexo("Masculico");
		professor.setDataCadastro(LocalDate.of(2001, 05, 15));

		Modalidade modalidade = new Modalidade();
		Modalidade modalidade2 = new Modalidade();

		modalidade.setNome("Judo");
		modalidade.setDescricao("Aula de artes marciais");

		modalidade2.setNome("Modalidade " + num);
		modalidade2.setDescricao("Descrição modalidade: " + num);

		List<Modalidade> modalidades = new ArrayList();
		modalidades.add(modalidade);
		modalidades.add(modalidade2);

		professor.setModalidade(modalidades);

		try {
			professorController.salvarProfessroComModalidades(professor);
			System.out.println("--------Professro Com Modalidades adicionado------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void listarModalidades() {
		List<Modalidade> modalidades = modalidadeController.listarModalidades();
		for (Modalidade atual : modalidades) {
			System.out.println("Id: " + atual.getIdModalidade());
			System.out.println("Nome:" + atual.getNome());
			System.out.println("Descrição modalidade: " + atual.getDescricao());
			System.out.println("Id da Professor: " + atual.getIdProfessor());
			System.out.println("\n\n");
		}

	}

	public void addModalidade(int num) {
		Modalidade modalidades = new Modalidade();
		modalidades.setNome("Modalidade add com o metodo addModalidade" + num);
		modalidades.setDescricao("Descrição da modalidade add com o metodo addModalidade" + num);

		modalidadeController.salvarModalidade(modalidades);

		System.out.println("--------Modalidade adicionada------------");

	}

	public void editarModalidade(int num, int id) {

		Modalidade modalidadeEditada = new Modalidade();

		List<Modalidade> modalidades = modalidadeController.listarModalidades();
		for (Iterator iterator = modalidades.iterator(); iterator.hasNext();) {
			Modalidade modalidades2 = (Modalidade) iterator.next();
			if (modalidades2.getIdModalidade() == id) {
				modalidadeEditada = modalidades2;
			}

		}
		modalidadeEditada.setNome("Modalidade EDITADA" + num);
		modalidadeEditada.setDescricao("Descrição Modalidade editada:" + num);

		modalidadeController.editarModalidade(modalidadeEditada);

		System.out.println("--------Modalidade foi editada------------");

	}

	public void delearModalidades() {

		listarModalidades();

		Scanner sc = new Scanner(System.in);
		System.out.println("Qual o ID da modalidade aque voce quer deletar ?");
		int id = sc.nextInt();

		modalidadeController.deletarModalidade(id);

		System.out.println("--------MODALIDADE COM O ID " + id + " DELETADO! ");
		System.out.println(" | '-' | ");

	}

	public void listarFuncionarios() {
		List<Funcionario> funcionarios = funcionarioController.listarFuncionarios();
		for (Funcionario atual : funcionarios) {
			System.out.println("Id: " + atual.getId());
			System.out.println("Nome:" + atual.getNome());
			System.out.println("Data de Nascimento: " + atual.getDataNascimento().toString());
			System.out.println("Endereço" + atual.getEndereco());
			System.out.println("Email: " + atual.getEmail());
			System.out.println("Sexo: " + atual.getSexo());
			System.out.println("Data de nascimento: " + atual.getDataCadastro().toString());
			System.out.println("Função: " + atual.getFuncao());
			System.out.println("Descrição da função: " + atual.getDescFuncao());

			System.out.println("\n\n");
		}

	}

	public void addFuncionario(int num) {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Funcionario " + num);
		funcionario.setDataNascimento(LocalDate.of(2005, 05, 15));
		funcionario.setEndereco("Rua 611 Qd. 511");
		funcionario.setTelefone("(62)98765-8547");
		funcionario.setEmail("Funcionario" + num + "@pessoaT.com");
		funcionario.setSexo("Masculico");
		funcionario.setDataCadastro(LocalDate.of(2001, 05, 15));
		funcionario.setFuncao("Funcao adcionada");
		funcionario.setDescFuncao("Descricao da funcao add");
		

		funcionarioController.salvarFuncionario(funcionario);

		System.out.println("--------Funcionario adicionado------------");

	}

	public void editarFuncionario(int num, int id) {
		// Pessoa pessoa = new Pessoa();
		Funcionario funcionarioEditado = new Funcionario();
		/*
		 * pessoa.setNome("EDITADO " + num); pessoa.setDataNascimento(LocalDate.of(2005,
		 * 05, 15)); pessoa.setEndereco("Rua 611 Qd. 511");
		 * pessoa.setTelefone("(62)98765-8547");
		 * pessoa.setEmail("pessoa"+num+"@pessoaT.com"); pessoa.setSexo("Masculico");
		 * pessoa.setDataCadastro(LocalDate.of(2001, 05, 15));
		 */
		List<Funcionario> funcionarios = funcionarioController.listarFuncionarios();
		for (Iterator iterator = funcionarios.iterator(); iterator.hasNext();) {
			Funcionario funcionarios2 = (Funcionario) iterator.next();
			
			if (funcionarios2.getId() == id) {
				funcionarioEditado = funcionarios2;
			}

		}

		funcionarioEditado.setNome("Funcionario EDITADO" + num);
		funcionarioEditado.setDataNascimento(LocalDate.of(2005, 05, 15));
		funcionarioEditado.setEndereco("Rua 611 Qd. 511");
		funcionarioEditado.setTelefone("(62)98765-8547");
		funcionarioEditado.setEmail("funcionarioEditada" + num + "@pessoaEditadaT.com");
		funcionarioEditado.setSexo("Masculico");
		funcionarioEditado.setDataCadastro(LocalDate.of(2001, 05, 15));
		funcionarioEditado.setFuncao("Funcao editada");
		funcionarioEditado.setDescFuncao("Descricao editada");

		funcionarioController.editarFuncionario(funcionarioEditado);

		System.out.println("--------Funcionario foi editado------------");

	}

	public void deletarFuncionario() {

		listarFuncionarios();

		Scanner sc = new Scanner(System.in);
		System.out.println("Qual o ID da funcionario aque voce quer deletar ?");
		int id = sc.nextInt();

		funcionarioController.deletarFuncionario(id);

		System.out.println("--------FUNCIONARIO COM O ID " + id + " DELETADO! ");
		System.out.println(" | '-' | ");

	}

	public void listarAlunos() {
		
		List<Aluno> alunos = alunoController.listarAlunos();
		for (Aluno atual : alunos) {
			System.out.println("Id: " + atual.getId());
			System.out.println("Nome:" + atual.getNome());
			System.out.println("Data de Nascimento: " + atual.getDataNascimento().toString());
			System.out.println("Endereço" + atual.getEndereco());
			System.out.println("Email: " + atual.getEmail());
			System.out.println("Sexo: " + atual.getSexo());
			System.out.println("Data de nascimento: " + atual.getDataCadastro().toString());
			System.out.println("Matriculas:" + atual.getMatricula());

			System.out.println("\n\n");
		}

	}

	public void addAluno(int num) {
		Aluno aluno = new Aluno();
		aluno.setNome("Aluno " + num);
		aluno.setDataNascimento(LocalDate.of(2005, 05, 15));
		aluno.setEndereco("Rua 611 Qd. 511");
		aluno.setTelefone("(62)98765-8547");
		aluno.setEmail("Aluno" + num + "@pessoaT.com");
		aluno.setSexo("Masculico");
		aluno.setDataCadastro(LocalDate.of(2001, 05, 15));
		aluno.setMatricula(555555555);
		
		

		alunoController.salvarAluno(aluno);

		System.out.println("--------Aluno adicionado------------");

	}

	public void editarAluno(int num, int id) {
		
		Aluno alunoEditado = new Aluno();
		
		List<Aluno> funcionarios = alunoController.listarAlunos();
		for (Iterator iterator = funcionarios.iterator(); iterator.hasNext();) {
			Aluno aluno2 = (Aluno) iterator.next();
			
			if (aluno2.getId() == id) {
				alunoEditado = aluno2;
			}

		}

		alunoEditado.setNome("Aluno EDITADO" + num);
		alunoEditado.setDataNascimento(LocalDate.of(2005, 05, 15));
		alunoEditado.setEndereco("Rua 611 Qd. 511");
		alunoEditado.setTelefone("(62)98765-8547");
		alunoEditado.setEmail("AlunoEditado" + num + "@pessoaEditadaT.com");
		alunoEditado.setSexo("Masculico");
		alunoEditado.setDataCadastro(LocalDate.of(2001, 05, 15));
		alunoEditado.setMatricula(99999);
		

		alunoController.editarAluno(alunoEditado);

		System.out.println("--------Aluno foi editado------------");

	}

	public void deletarAluno() {

		listarAlunos();

		Scanner sc = new Scanner(System.in);
		System.out.println("Qual o ID do aluno aque voce quer deletar ?");
		int id = sc.nextInt();

		alunoController.deletarAluno(id);

		System.out.println("--------ALUNO COM O ID " + id + " FOI DELETADO! ");
		System.out.println(" | '-' | ");

	}

	public void listarPlanos() {
		List<Plano> planos = planoController.listarPlanos();
		for (Plano atual : planos) {
			System.out.println("Id: " + atual.getId());
			System.out.println("Nome do plano: " + atual.getNomeDoPlano());
			System.out.println("Valor do Plano R$" + atual.getValor());
			System.out.println("Descrição do plano: " + atual.getDescDoPlano());

			System.out.println("\n\n");
		}

	}

	public void salvarAlunoComPlano(int num) {
		
		Aluno aluno = new Aluno();
		aluno.setNome("Aluno com plano" + num);
		aluno.setDataNascimento(LocalDate.of(2005, 05, 25));
		aluno.setEndereco("Endereçi do professor" + num);
		aluno.setTelefone("(62)98455-8987");
		aluno.setEmail("alunoComPlanp" + num + "@unialfa.com");
		aluno.setSexo("Masculico");
		aluno.setDataCadastro(LocalDate.of(2001, 05, 15));
		aluno.setMatricula(40028922);

		Plano plano1 = new Plano();
		Plano plano2 = new Plano();
		
		plano1.setNomeDoPlano("Plano 1");
		plano1.setDescDoPlano("O plano um tem direito a fazer tudo");
		plano1.setValor(999.50);;
		
		plano2.setNomeDoPlano("Plano 2");
		plano2.setDescDoPlano("O plano dois tem direito a fazer NADA");
		plano2.setValor(0.99);;
		
		List<Plano> planos = new ArrayList();
		
		planos.add(plano1);
		planos.add(plano2);
	

		aluno.setPlano(planos);

		try {
			alunoController.salvarAlunoComPlano(aluno);
			System.out.println("--------Aluno com Plano foi adicionado------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void addPlano(int num, Double valor) {
		Plano plano = new Plano();
		
		plano.setNomeDoPlano("Plano de número "+ num);
		plano.setDescDoPlano("Descrição do do plano "+num);
		plano.setValor(valor);
		
		planoController.salvarPlano(plano);
		
		System.out.println("--------Plano adicionado------------");
	} 

	public void deletarPlano() {
		
		listarPlanos();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Qual o ID do plano que você quer deletar ?");
		int id = sc.nextInt();
		
		planoController.deletarPlano(id);
		
		System.out.println("--------PLANO COM O ID " + id + " FOI DELETADO! ");
		System.out.println(" | '-' | ");
		
		
	}

	public void editarPlano(int num, Double valor, int id) {
		
		Plano planoEditado = new Plano();
		
		List<Plano> planos = planoController.listarPlanos();
		for (Iterator iterator = planos.iterator(); iterator.hasNext();) {
			Plano plano2 = (Plano) iterator.next();
			
			if (plano2.getId() == id) {
				planoEditado = plano2;
			}

		}

		planoEditado.setNomeDoPlano("Plano editado número: " + num);
		planoEditado.setDescDoPlano("Descrição do plano editado número "+ num);
		planoEditado.setValor(valor);
		
		
		
		planoController.editarPlano(planoEditado);
		
		System.out.println("--------Plano foi editado------------");

	}

	public void listarTurmas() {
		
		List<Turma> turmas = turmaController.listarTurmas();
		for(Turma atual: turmas) {
			
			System.out.println("ID:" + atual.getId());
			System.out.println("Nome da turma: " + atual.getNome());
			System.out.println("Descrição da turma: " + atual.getDescTurma());
			System.out.println("Horario: " + atual.getHorario());
			System.out.println("Maximo de alunos: " + atual.getMaxAluno());
			
			System.out.println("\n\n");
			
		}
		
	}
	
	public void salvarTurmaComAlunosEProfessor(int num,int maxAlnos) {

		Turma turma = new Turma();
		turma.setNome("Turma" + num);
		turma.setMaxAluno(maxAlnos);
		turma.setHorario("Horario add com turma");
		turma.setDescTurma("Descrição da turma"+num);

		Aluno aluno = new Aluno();
		Aluno aluno2 = new Aluno();

		aluno.setNome("Aluno " + num);
		aluno.setDataNascimento(LocalDate.of(2005, 05, 15));
		aluno.setEndereco("Rua com o numero " + num);
		aluno.setTelefone("(62)98765-8547");
		aluno.setEmail("Aluno" + num + "@pessoaT.com");
		aluno.setSexo("Masculico");
		aluno.setDataCadastro(LocalDate.of(2001, 05, 15));
		aluno.setMatricula(555555555);
		
		aluno2.setNome("Aluno " + num);
		aluno2.setDataNascimento(LocalDate.of(2005, 05, 15));
		aluno2.setEndereco("Rua 611 Qd. 511");
		aluno2.setTelefone("(62)98765-8547");
		aluno2.setEmail("Aluno" + num + "@pessoaT.com");
		aluno2.setSexo("Masculico");
		aluno2.setDataCadastro(LocalDate.of(2001, 05, 15));
		aluno2.setMatricula(77777777);
		

		List<Aluno> alunos = new ArrayList();
		alunos.add(aluno);
		alunos.add(aluno2);

		turma.setAlunos(alunos);
		
		Professor professor = new Professor();
		professor.setNome("Profaaaaaaaaassor " + num);
		professor.setDataNascimento(LocalDate.of(2005, 05, 15));
		professor.setEndereco("Rua 611 Qd. 511");
		professor.setTelefone("(62)98765-8547");
		professor.setEmail("professor" + num + "@professorT.com");
		professor.setSexo("Masculico");
		professor.setDataCadastro(LocalDate.of(2001, 05, 15));

		
		

		try {
			turmaController.salvarTurmaComAlunosEProfessor(turma,professor);
			//professorController.salvarProfessroComModalidades(professor);
			System.out.println("--------Turma com alunos e professor adicionado------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void addTurma(int num, int maxAlunos) {
		
		Turma turma = new Turma();
		turma.setNome("Turma" + num);
		turma.setMaxAluno(maxAlunos);
		turma.setHorario("Horario add com turma");
		turma.setDescTurma("Descrição da turma"+num);

		turmaController.salvarTurma(turma);

		System.out.println("--------Turma adicionada------------");

	}

	public void editarTurma(int num, int id) {

		Turma turmaEditado = new Turma();

		List<Turma> turmas = turmaController.listarTurmas();
		for (Iterator iterator = turmas.iterator(); iterator.hasNext();) {
			Turma turma2 = (Turma) iterator.next();
			if (turma2.getId() == id) {
				turmaEditado = turma2;
			}

		}
		
		turmaEditado.setNome("Turma editada" + num);
		turmaEditado.setMaxAluno(33);
		turmaEditado.setHorario("Horario add com turma");
		turmaEditado.setDescTurma("Descrição da turma"+num);

		turmaController.editarTurma(turmaEditado);
		
		System.out.println("--------Turma foi editada------------");

	}

	public void delearTurma() {

		listarTurmas();

		Scanner sc = new Scanner(System.in);
		System.out.println("Qual o ID do turma aque voce quer deletar ?");
		int id = sc.nextInt();

		turmaController.deletarTurma(id);

		System.out.println("--------PROFESSOR COM O ID " + id + " DELETADO! ");
		System.out.println(" | '-' | ");

	}
}
