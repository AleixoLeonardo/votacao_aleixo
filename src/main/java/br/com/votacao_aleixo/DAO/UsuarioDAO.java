package br.com.votacao_aleixo.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.votacao_aleixo.DTO.Usuario;
import br.com.votacao_aleixo.conexao.HibernateUtil;

public class UsuarioDAO {
	Session session = null;
	private static UsuarioDAO usuarioDAO;

	public static UsuarioDAO getInstance() {
		if (usuarioDAO == null) {
			usuarioDAO = new UsuarioDAO();
		}

		return usuarioDAO;
	}

	private UsuarioDAO() {

	}

	public void save(Usuario usuario) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(usuario);
		session.getTransaction().commit();
		session.close();
	}

	public List<Usuario> listarTodos() {
		session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT u FROM Usuario u";
		Query query = session.createQuery(hql);
		List<Usuario> results = query.list();
		session.close();
		return results;
	}

	public Usuario getById(Integer idUsuario) {
		session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT u FROM Usuario u WHERE u.idUsuario = " + idUsuario;
		Query query = session.createQuery(hql);
		Usuario results = (Usuario) query.list().get(0);
		session.close();
		return results;
	}

	public Usuario verificaUsuario(String numeroTitulo, String senha) {
		session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT u FROM Usuario u WHERE u.numeroTitulo = " + numeroTitulo + " AND u.senha = " + senha;
		Query query = session.createQuery(hql);
		List results = query.list();
		if (results != null && !results.isEmpty()) {
			Usuario usuario = (Usuario) query.list().get(0);
			session.close();
			return usuario;
		}
		session.close();
		return null;
	}
}
