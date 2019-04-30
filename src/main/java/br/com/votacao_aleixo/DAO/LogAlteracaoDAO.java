package br.com.votacao_aleixo.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.votacao_aleixo.DTO.LogAlteracao;
import br.com.votacao_aleixo.conexao.HibernateUtil;

public class LogAlteracaoDAO {
	Session session = null; 
	private static LogAlteracaoDAO logAlteracaoDAO;

	public static LogAlteracaoDAO getInstance() {
		if (logAlteracaoDAO == null) {
			logAlteracaoDAO = new LogAlteracaoDAO();
		}
		
		return logAlteracaoDAO;
	}
	private LogAlteracaoDAO(){
		
	}

	public void save(LogAlteracao logAlteracao) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(logAlteracao);
		session.getTransaction().commit();
		session.close();
	}

	public List<LogAlteracao> listarTodos() {
		session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT u FROM LogAlteracao u";
		Query query = session.createQuery(hql);
		List<LogAlteracao> results = query.list();
		session.close();
		return results;
	}

}
