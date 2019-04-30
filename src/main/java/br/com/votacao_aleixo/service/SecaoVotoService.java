package br.com.votacao_aleixo.service;

import java.util.List;

import br.com.votacao_aleixo.DAO.SecaoVotoDAO;
import br.com.votacao_aleixo.DAO.UsuarioDAO;
import br.com.votacao_aleixo.DTO.SecaoVoto;
import br.com.votacao_aleixo.DTO.Usuario;
import br.com.votacao_aleixo.object.ObjectGenerico;

public class SecaoVotoService {

	private static SecaoVotoService secaoVotoService;
	SecaoVotoDAO secaoVotoDAO = null;

	public static SecaoVotoService getInstance() {
		if (secaoVotoService == null) {
			secaoVotoService = new SecaoVotoService();
		}
		return secaoVotoService;
	}

	public List<SecaoVoto> listarSecoesVoto() {
		secaoVotoDAO  = SecaoVotoDAO.getInstance();
		List<SecaoVoto> listaSecaoVoto = secaoVotoDAO.listarTodos();
		return listaSecaoVoto;
	}
	private SecaoVotoService() {

	}
	
	public ObjectGenerico verificarTitulo(String titulo, String secao) {
		UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
		Usuario usuario = usuarioDAO.verificaTituloSecao(titulo, secao);
		ObjectGenerico generico = new ObjectGenerico();
		if(usuario != null && usuario.getIdUsuario() != null) {
			generico.setDescricao("Número de Título Válido");
			generico.setId(usuario.getIdUsuario());
		}else {
			generico.setDescricao("Número de Título Inválido");
			generico.setId(0);
		}
		return generico;
	}
}
