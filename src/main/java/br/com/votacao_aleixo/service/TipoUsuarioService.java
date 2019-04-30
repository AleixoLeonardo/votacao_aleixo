package br.com.votacao_aleixo.service;

import java.util.ArrayList;
import java.util.List;

import br.com.votacao_aleixo.DAO.TipoUsuarioDAO;
import br.com.votacao_aleixo.DAO.TipoUsuarioDAO;
import br.com.votacao_aleixo.DTO.TipoUsuario;
import br.com.votacao_aleixo.DTO.TipoUsuario;
import br.com.votacao_aleixo.object.ObjectGenerico;

public class TipoUsuarioService {

	private static TipoUsuarioService tipoUsuarioService;
	TipoUsuarioDAO tipoUsuarioDAO = null;

	public static TipoUsuarioService getInstance() {
		if (tipoUsuarioService == null) {
			tipoUsuarioService = new TipoUsuarioService();
		}
		return tipoUsuarioService;
	}

	public List<ObjectGenerico> listarTipoUsuarios() {
		tipoUsuarioDAO = TipoUsuarioDAO.getInstance();
		List<TipoUsuario> listaTipoUsuario = tipoUsuarioDAO.listarTodos();
		List<ObjectGenerico> listaRetorno = new ArrayList<>();
		ObjectGenerico object = null;
		for(TipoUsuario tipoUsuario : listaTipoUsuario){
			object = new ObjectGenerico();
			object.setId(tipoUsuario.getIdTipoUsuario());
			object.setDescricao(tipoUsuario.getNome());
			listaRetorno.add(object);
		}
		return listaRetorno;
	}
	private TipoUsuarioService() {

	}
}
