package br.com.votacao_aleixo.service;

import java.util.List;

import br.com.votacao_aleixo.DAO.SecaoVotoDAO;
import br.com.votacao_aleixo.DTO.SecaoVoto;

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
}
