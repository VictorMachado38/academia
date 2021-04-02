package academia.model;
import java.util.List;
public class Pacote {
	
	private long idPacote;
	private List<Plano> listaDePlanos;
	
	
	public long getIdPacote() {
		return idPacote;
	}
	public void setIdPacote(long idPacote) {
		this.idPacote = idPacote;
	}
	public List<Plano> getListaDePlanos() {
		return listaDePlanos;
	}
	public void setListaDePlanos(List<Plano> listaDePlanos) {
		this.listaDePlanos = listaDePlanos;
	}
	
	
	

}
