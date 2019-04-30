package br.com.votacao_aleixo.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.votacao_aleixo.DTO.SecaoVoto;
import br.com.votacao_aleixo.conexao.HibernateUtil;

public class SecaoVotoDAO {
	Session session = null;
	private static SecaoVotoDAO secaoVotoDAO;

	public static SecaoVotoDAO getInstance() {
		if (secaoVotoDAO == null) {
			secaoVotoDAO = new SecaoVotoDAO();
		}

		return secaoVotoDAO;
	}

	private SecaoVotoDAO() {

	}

	public void save(SecaoVoto secaoVoto) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(secaoVoto);
		session.getTransaction().commit();
		session.close();
	}

	public List<SecaoVoto> listarTodos() {
		session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT s FROM SecaoVoto s";
		Query query = session.createQuery(hql);
		List<SecaoVoto> results = query.list();
		session.close();
		return results;
	}
}
