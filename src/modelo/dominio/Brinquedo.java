package modelo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="tab_brinquedos")
public class Brinquedo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ID_PRODUTO")
	@SequenceGenerator(name="ID_PRODUTO", sequenceName="SEQ_PRODUTO", allocationSize=1)
	private Integer codigo;
	
	
	private String nome;
	
	private String fornecedor;
	
	
	@Column(name="data_comprado")
	private Date dataComprado;
	
	
	@Column(name="preco_aluguel", columnDefinition="NUMERIC(15,2)")
	private float precoAluguel;
	
	@Column(name="preco_venda", columnDefinition="NUMERIC(15,2)")
	private float precoVenda;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_fk")
	private Tipo tipo;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Date getDataComprado() {
		return dataComprado;
	}

	public void setDataComprado(Date dataComprado) {
		this.dataComprado = dataComprado;
	}

	public float getPrecoAluguel() {
		return precoAluguel;
	}

	public void setPrecoAluguel(float precoAluguel) {
		this.precoAluguel = precoAluguel;
	}

	public float getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(float precoVenda) {
		this.precoVenda = precoVenda;
	}
	

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Brinquedo [codigo=" + codigo + ", nome=" + nome + ", fornecedor=" + fornecedor + ", dataComprado="
				+ dataComprado + ", precoAluguel=" + precoAluguel + ", precoVenda=" + precoVenda + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Brinquedo other = (Brinquedo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	

}
