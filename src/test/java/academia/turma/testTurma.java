package academia.turma;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import academia.controller.TurmaController;
import academia.model.Turma;

class testTurma {
	
		static TurmaController turmaController = new TurmaController();

		
		@Test
	    @DisplayName("Devera criar uma turma")
	    void create() {
//	        criar
	        assertNotNull( turmaController.create());
	    }
		
	
		@Test
	    void list() {
//	        listar turmas
	        List< Turma> turmas = turmaController.listarTurmas();
	        assertTrue(turmas.size()>0);
//	        mostrar turmas

	    }
		
	    @Test
	  
	    void deletar() {
	        List< Turma> turmas = turmaController.listarTurmas();
	        assertTrue(turmas.size()>0);
	        Turma turma = turmaController.show(turmas.get(0).getId());
	        boolean deleted = turmaController.deletarTurma(0);
	        assertTrue(deleted);
	    }
}
