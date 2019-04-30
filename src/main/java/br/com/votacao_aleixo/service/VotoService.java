package br.com.votacao_aleixo.service;

import java.util.List;

import br.com.votacao_aleixo.DAO.VotoDAO;
import br.com.votacao_aleixo.DTO.Voto;

public class VotoService {

	private static VotoService votoService;
	VotoDAO votoDAO = null;

	public static VotoService getInstance() {
		if (votoService == null) {
			votoService = new VotoService();
		}
		return votoService;
	}

	public List<Voto> listarVotos() {
		votoDAO = VotoDAO.getInstance();
		return votoDAO.listarTodos();
	}
	private VotoService() {

	}
}
