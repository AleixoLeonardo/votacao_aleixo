package br.com.votacao_aleixo.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.votacao_aleixo.DTO.Voto;
import br.com.votacao_aleixo.conexao.HibernateUtil;

public class VotoDAO {
	Session session = null; 
	private static VotoDAO votoDAO;

	public static VotoDAO getInstance() {
		if (votoDAO == null) {
			votoDAO = new VotoDAO();
		}
		
		return votoDAO;
	}
	private VotoDAO(){
		
	}

	public void save(Voto voto) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(voto);
		session.getTransaction().commit();
		session.close();
	}

	public List<Voto> listarTodos() {
		session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT u FROM Voto u";
		Query query = session.createQuery(hql);
		List<Voto> results = query.list();
		session.close();
		return results;
	}
}
