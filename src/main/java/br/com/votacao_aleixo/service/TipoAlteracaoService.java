package br.com.votacao_aleixo.service;

import java.util.List;

import br.com.votacao_aleixo.DAO.TipoAlteracaoDAO;
import br.com.votacao_aleixo.DTO.TipoAlteracao;

public class TipoAlteracaoService {

	private static TipoAlteracaoService tipoAlteracaoService;
	TipoAlteracaoDAO tipoAlteracaoDAO = null;

	public static TipoAlteracaoService getInstance() {
		if (tipoAlteracaoService == null) {
			tipoAlteracaoService = new TipoAlteracaoService();
		}
		return tipoAlteracaoService;
	}

	public List<TipoAlteracao> listarTipoAlteracaos() {
		tipoAlteracaoDAO = TipoAlteracaoDAO.getInstance();
		return tipoAlteracaoDAO.listarTodos();
	}
	private TipoAlteracaoService() {

	}
}
