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
	
	public SecaoVoto pegarSecaoAberta(Integer idSecao, Integer idUsuario) {
		session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT s FROM SecaoVoto s WHERE s.secao.idSecao = " + idSecao
				+ " AND s.status is TRUE AND (SELECT COUNT(v.idVoto) FROM Voto v "
				+ " WHERE v.secaoVoto.secao.idSecao = "+idSecao+" "
						+ " AND v.usuarioEleitor.idUsuario = "+idUsuario+") = 0";
		Query query = session.createQuery(hql);
		List results = query.list();
		SecaoVoto result = null;
		if(results != null && results.size() > 0 ){
			result = (SecaoVoto) results.get(0);
		}
		session.close();
		return result;
	}
}
