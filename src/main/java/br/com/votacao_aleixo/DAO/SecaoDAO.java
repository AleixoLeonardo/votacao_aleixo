package br.com.votacao_aleixo.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.votacao_aleixo.DTO.Secao;
import br.com.votacao_aleixo.conexao.HibernateUtil;

public class SecaoDAO {
	Session session = null; 
	private static SecaoDAO secaoDAO;

	public static SecaoDAO getInstance() {
		if (secaoDAO == null) {
			secaoDAO = new SecaoDAO();
		}
		
		return secaoDAO;
	}
	private SecaoDAO(){
		
	}

	public void save(Secao secao) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(secao);
		session.getTransaction().commit();
		session.close();
	}

	public List<Secao> listarTodos() {
		session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT u FROM Secao u";
		Query query = session.createQuery(hql);
		List<Secao> results = query.list();
		session.close();
		return results;
	}
	
}
