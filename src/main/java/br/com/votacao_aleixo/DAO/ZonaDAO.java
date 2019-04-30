package br.com.votacao_aleixo.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.votacao_aleixo.DTO.Zona;
import br.com.votacao_aleixo.conexao.HibernateUtil;

public class ZonaDAO {
	Session session = null;
	private static ZonaDAO zonaDAO;

	public static ZonaDAO getInstance() {
		if (zonaDAO == null) {
			zonaDAO = new ZonaDAO();
		}

		return zonaDAO;
	}

	private ZonaDAO() {

	}

	public void save(Zona zona) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(zona);
		session.getTransaction().commit();
		session.close();
	}

	public List<Zona> listarPorSecao(Integer idSecao) {
		session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT u FROM Zona u WHERE u.secao.idSecao = " + idSecao;
		Query query = session.createQuery(hql);
		List<Zona> results = query.list();
		session.close();
		return results;
	}

	public Zona getById(Integer idZona) {
		session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT u FROM Zona u WHERE u.idZona = " + idZona;
		Query query = session.createQuery(hql);
		Zona results = (Zona) query.list();
		session.close();
		return results;
	}

	public List<Zona> listarTodos() {
		session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT u FROM Zona u";
		Query query = session.createQuery(hql);
		List<Zona> results = query.list();
		session.close();
		return results;
	}

}
