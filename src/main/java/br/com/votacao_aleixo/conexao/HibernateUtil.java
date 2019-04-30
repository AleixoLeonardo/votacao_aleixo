package br.com.votacao_aleixo.conexao;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import br.com.votacao_aleixo.DTO.LogAlteracao;
import br.com.votacao_aleixo.DTO.Municipio;
import br.com.votacao_aleixo.DTO.Secao;
import br.com.votacao_aleixo.DTO.SecaoVoto;
import br.com.votacao_aleixo.DTO.TipoAlteracao;
import br.com.votacao_aleixo.DTO.TipoUsuario;
import br.com.votacao_aleixo.DTO.Uf;
import br.com.votacao_aleixo.DTO.Usuario;
import br.com.votacao_aleixo.DTO.Voto;
import br.com.votacao_aleixo.DTO.Zona;
public class HibernateUtil {
	  private static SessionFactory sessionFactory;
	    public static SessionFactory getSessionFactory() {
	        if (sessionFactory == null) {
	            try {
	                Configuration configuration = new Configuration();
	                // Hibernate settings equivalent to hibernate.cfg.xml's properties
	                Properties settings = new Properties();
	                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
	                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/votacao_aleixo?serverTimezone=UTC");
	                settings.put(Environment.USER, "root");
//	                settings.put(Environment.PASS, "Aleixo@123");
	                settings.put(Environment.PASS, "fatec");
	                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
//	                settings.put(Environment.SHOW_SQL, "true");
	                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//	                settings.put(Environment.HBM2DDL_AUTO, "create-drop");
	                configuration.setProperties(settings);
	                configuration.addAnnotatedClass(LogAlteracao.class);
	                configuration.addAnnotatedClass(Municipio.class);
	                configuration.addAnnotatedClass(Secao.class);
	                configuration.addAnnotatedClass(TipoAlteracao.class);
	                configuration.addAnnotatedClass(TipoUsuario.class);
	                configuration.addAnnotatedClass(Uf.class);
	                configuration.addAnnotatedClass(Usuario.class);
	                configuration.addAnnotatedClass(Voto.class);
	                configuration.addAnnotatedClass(Zona.class);
	                configuration.addAnnotatedClass(SecaoVoto.class);
	                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	                    .applySettings(configuration.getProperties()).build();
	                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return sessionFactory;
	    }
}
