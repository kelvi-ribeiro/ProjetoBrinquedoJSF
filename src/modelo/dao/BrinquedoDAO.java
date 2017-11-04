package modelo.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import modelo.dominio.Tipo;
import modelo.dominio.Brinquedo;

public class BrinquedoDAO extends JpaDAO<Brinquedo> {

	public List<Brinquedo> filtrarBrinquedos(Tipo tip, String nome) {
		String jpql = "from Brinquedo b ";

		if (tip != null) {
			jpql = jpql + " where b.tipo = :ti";
		} else if (nome != null) {
			jpql = jpql + " where b.nome like :no";
		}

		jpql = jpql + " order by b.nome";

		TypedQuery<Brinquedo> comando = this.getEntityManager().createQuery(jpql, Brinquedo.class);

		if (tip != null)
			comando.setParameter("ti", tip);
		else if (nome != null)
			comando.setParameter("no", "%" + nome + "%");

		return comando.getResultList();
	}

}
