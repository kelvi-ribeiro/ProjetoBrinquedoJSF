package controle.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import modelo.dao.BrinquedoDAO;
import modelo.dao.TipoDAO;
import modelo.dominio.Brinquedo;
import modelo.dominio.Tipo;

@ManagedBean(name = "brinquedoMB")
@RequestScoped
public class BrinquedoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Brinquedo brinquedo = new Brinquedo();

	private Tipo filtroTipo = null;
	private String filtroNome = null;

	private BrinquedoDAO dao = new BrinquedoDAO();

	private List<Brinquedo> brinquedos = null;
	
	

	private List<Tipo> tipos = null;

	public List<Brinquedo> getBrinquedos() {

		if (this.brinquedos == null)
			this.brinquedos = this.dao.lerTodos();

		return brinquedos;
	}
	
	

	public List<Tipo> getTipos() {

		if (this.tipos == null)
			this.tipos = new TipoDAO().lerTodos();

		return tipos;
	}

	public Brinquedo getBrinquedo() {
		return brinquedo;
	}

	public void setBrinquedo(Brinquedo brinquedo) {
		this.brinquedo = brinquedo;
	}

	public Tipo getFiltroTipo() {
		return filtroTipo;
	}

	public void setFiltroTipo(Tipo filtroTipo) {
		this.filtroTipo = filtroTipo;
	}

	public String getFiltroNome() {
		return filtroNome;
	}

	public void setFiltroNome(String filtroNome) {
		this.filtroNome = filtroNome;
	}

	public String acaoListar() {
		return "brinquedoListar.jsf?faces-redirect=true";
	}

	public String acaoPesquisar() {

		this.brinquedos = this.dao.filtrarBrinquedos(filtroTipo, filtroNome);

		return "brinquedoListar.jsf";
	}

	public String acaoAbrirInclusao() {

		this.brinquedo = new Brinquedo();

		return "brinquedoEditar.jsf";
	}

	public String acaoAbrirAlteracao(Integer codigo) {

		this.brinquedo = dao.lerPorId(codigo);
		
		

		return "brinquedoEditar.jsf";
	}

	public String acaoExcluir(Integer codigo) {

		// ler objeto do banco
		this.brinquedo = dao.lerPorId(codigo);

		this.dao.excluir(this.brinquedo);

		return acaoListar();
	}

	public String acaoSalvar() {

		this.dao.salvar(this.brinquedo);

		return acaoListar();
	}

	public String acaoCancelar() {

		return acaoListar();
	}
	

}
