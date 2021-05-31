package academia.mdalidade;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import academia.controller.ModalidadeController;
import academia.model.Modalidade;

class testModalidade {

	ModalidadeController modalidadeController = new ModalidadeController();

	@Test
	@DisplayName("Devera criar uma modalidade")
	void create() {
//        criar
		assertNotNull(modalidadeController.create());
	}

	@Test
	void list() {
//        listar modalidades
		List<Modalidade> modalidades = modalidadeController.listarModalidades();
		assertTrue(modalidades.size() > 0);
//        mostrar modalidades

	}

	@Test

	void deletar() {
		List<Modalidade> modalidades = modalidadeController.listarModalidades();
		assertTrue(modalidades.size() > 0);
		Modalidade modalidade = modalidadeController.show(modalidades.get(0).getIdModalidade());
		boolean deleted = modalidadeController.deletarModalidade(0);
		assertTrue(deleted);
	}

	public void criraModalidade() {
//    criar
		assertNotNull(modalidadeController.create());
	}

	@Test
	public void deletarModalidade() {
		List<Modalidade> modalidades = modalidadeController.listarModalidades();
		Modalidade modalidade = modalidadeController.show(modalidades.get(0).getIdModalidade());

		modalidadeController.deletarModalidade(modalidade.getIdModalidade());

	}

}
