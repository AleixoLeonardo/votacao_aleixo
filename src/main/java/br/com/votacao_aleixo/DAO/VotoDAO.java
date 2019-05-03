package br.com.votacao_aleixo.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.votacao_aleixo.DTO.Voto;
import br.com.votacao_aleixo.conexao.HibernateUtil;
import br.com.votacao_aleixo.object.ObjectRelatorio;

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
	
	public List<ObjectRelatorio> listarRelatorio(Integer secao) {
		session = HibernateUtil.getSessionFactory().openSession();
		String where = "";
		if(secao != 0){
			where += " WHERE sv.secao =" + secao;
		}
		String stringQuery = "SELECT usu.nome, usu.url_foto as url, "+
							 " (SELECT COUNT(voto.id_voto) FROM voto voto " +
							 " WHERE voto.usuario_candidato = usu.id_usuario) as quantidade " +
							 " FROM votacao_aleixo.voto vot " +
							 " JOIN usuario usu ON vot.usuario_candidato = usu.id_usuario " +
							 " JOIN secao_voto sv ON vot.secao_voto = sv.id_secao_voto " +
							 where  + " GROUP by usu.id_usuario ORDER BY quantidade desc";
		Query query = session.createNativeQuery(stringQuery);
		List<Object[]> results = (List<Object[]>) query.list();
		List<ObjectRelatorio> retorno = new ArrayList<>();
		ObjectRelatorio objectRelatorio = null;
		for(Object[] object : results){
			objectRelatorio = new ObjectRelatorio();
			objectRelatorio.setNome(object[0] + "");
			objectRelatorio.setUrl(object[1] + "");
			objectRelatorio.setQuantidade(object[2] + "");
			retorno.add(objectRelatorio);
		}
		session.close();
		return retorno;
	}
	
	public List<Voto> listarPorSecao(Integer idSecao) {
		session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT u FROM Voto u WHERE u.secaoVoto.secao.idSecao = " + idSecao;
		Query query = session.createQuery(hql);
		List<Voto> results = query.list();
		session.close();
		return results;
	}
}
