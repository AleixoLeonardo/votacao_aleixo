package br.com.votacao_aleixo.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.votacao_aleixo.DTO.Municipio;
import br.com.votacao_aleixo.conexao.HibernateUtil;

public class MunicipioDAO {
	Session session = null; 
	private static MunicipioDAO municipioDAO;

	public static MunicipioDAO getInstance() {
		if (municipioDAO == null) {
			municipioDAO = new MunicipioDAO();
		}
		
		return municipioDAO;
	}
	private MunicipioDAO(){
		
	}

	public void save(Municipio municipio) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(municipio);
		session.getTransaction().commit();
		session.close();
	}
	public List<Municipio> listarPorUf(Integer idUf) {
		session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT u FROM Municipio u WHERE u.uf.idUf = " + idUf;
		Query query = session.createQuery(hql);
		List<Municipio> results = query.list();
		session.close();
		return results;
	}
	
	public Municipio getById(Integer idMunicipio) {
		session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT u FROM Municipio u WHERE u.idMunicipio = " + idMunicipio;
		Query query = session.createQuery(hql);
		Municipio results = (Municipio) query.list().get(0);
		session.close();
		return results;
	}


	public List<Municipio> listarTodos() {
		session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT u FROM Municipio u";
		Query query = session.createQuery(hql);
		List<Municipio> results = query.list();
		session.close();
		return results;
	}
}
