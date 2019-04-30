package br.com.votacao_aleixo.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.votacao_aleixo.DTO.Uf;
import br.com.votacao_aleixo.conexao.HibernateUtil;

public class UfDAO {
	Session session = null; 
	private static UfDAO ufDAO;

	public static UfDAO getInstance() {
		if (ufDAO == null) {
			ufDAO = new UfDAO();
		}
		
		return ufDAO;
	}
	private UfDAO(){
		
	}

	public void save(Uf uf) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(uf);
		session.getTransaction().commit();
		session.close();
	}

	public List<Uf> listarTodos() {
		session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT u FROM Uf u";
		Query query = session.createQuery(hql);
		List<Uf> results = query.list();
		session.close();
		return results;
	}
}
