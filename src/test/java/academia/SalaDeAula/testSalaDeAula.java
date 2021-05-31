package academia.SalaDeAula;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import academia.controller.SalaDeAulaController;
import academia.model.SalaDeAula;

class testSalaDeAula {

	static SalaDeAulaController salaDeAulaController = new SalaDeAulaController();

	
	@Test
    @DisplayName("Devera criar uma salaDeAula")
    void create() {
//        criar
        assertNotNull( salaDeAulaController.create());
    }
	

	@Test
    void list() {
//        listar salaDeAulas
        List< SalaDeAula> salaDeAulas = salaDeAulaController.listarSalaDeAulas();
        assertTrue(salaDeAulas.size()>0);
//        mostrar salaDeAulas

    }
	
    @Test
  
    void deletar() {
        List< SalaDeAula> salaDeAulas = salaDeAulaController.listarSalaDeAulas();
        assertTrue(salaDeAulas.size()>0);
        SalaDeAula salaDeAula = salaDeAulaController.show(salaDeAulas.get(0).getId());
        boolean deleted = salaDeAulaController.deletarSalaDeAula(0);
        assertTrue(deleted);
    }
	
	
	
	
	

}
