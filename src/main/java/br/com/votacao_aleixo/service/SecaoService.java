package br.com.votacao_aleixo.service;

import java.util.ArrayList;
import java.util.List;

import br.com.votacao_aleixo.DAO.SecaoDAO;
import br.com.votacao_aleixo.DTO.Municipio;
import br.com.votacao_aleixo.DTO.Secao;
import br.com.votacao_aleixo.object.ObjectGenerico;

public class SecaoService {

	private static SecaoService secaoService;
	SecaoDAO secaoDAO = null;

	public static SecaoService getInstance() {
		if (secaoService == null) {
			secaoService = new SecaoService();
		}
		return secaoService;
	}

	public List<ObjectGenerico> listarSecaos() {
		secaoDAO  = SecaoDAO.getInstance();
		List<Secao> listaSecao = secaoDAO.listarTodos();
		List<ObjectGenerico> listaRetorno = new ArrayList<>();
		ObjectGenerico object = null;
		for(Secao secao : listaSecao){
			object = new ObjectGenerico();
			object.setId(secao.getIdSecao());
			object.setDescricao(secao.getNome());
			listaRetorno.add(object);
		}
		return listaRetorno;
	}
	private SecaoService() {

	}
}
