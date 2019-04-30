package br.com.votacao_aleixo.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.votacao_aleixo.DTO.TipoAlteracao;
import br.com.votacao_aleixo.conexao.HibernateUtil;

public class TipoAlteracaoDAO {
	Session session = null; 
	private static TipoAlteracaoDAO tipoAlteracaoDAO;

	public static TipoAlteracaoDAO getInstance() {
		if (tipoAlteracaoDAO == null) {
			tipoAlteracaoDAO = new TipoAlteracaoDAO();
		}
		
		return tipoAlteracaoDAO;
	}
	private TipoAlteracaoDAO(){
		
	}

	public void save(TipoAlteracao tipoAlteracao) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(tipoAlteracao);
		session.getTransaction().commit();
		session.close();
	}

	public List<TipoAlteracao> listarTodos() {
		session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT u FROM TipoAlteracao u";
		Query query = session.createQuery(hql);
		List<TipoAlteracao> results = query.list();
		session.close();
		return results;
	}
}
