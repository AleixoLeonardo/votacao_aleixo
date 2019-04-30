package br.com.votacao_aleixo.service;

import java.util.List;

import br.com.votacao_aleixo.DAO.LogAlteracaoDAO;
import br.com.votacao_aleixo.DTO.LogAlteracao;

public class LogAlteracaoService {

	private static LogAlteracaoService logAlteracaoService;
	LogAlteracaoDAO logAlteracaoDAO = null;

	public static LogAlteracaoService getInstance() {
		if (logAlteracaoService == null) {
			logAlteracaoService = new LogAlteracaoService();
		}
		return logAlteracaoService;
	}

	public List<LogAlteracao> listarLogAlteracaos() {
		logAlteracaoDAO = LogAlteracaoDAO.getInstance();
		return logAlteracaoDAO.listarTodos();
	}
	private LogAlteracaoService() {

	}
}
