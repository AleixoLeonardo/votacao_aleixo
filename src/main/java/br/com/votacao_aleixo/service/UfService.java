package br.com.votacao_aleixo.service;

import java.util.ArrayList;
import java.util.List;

import br.com.votacao_aleixo.DAO.UfDAO;
import br.com.votacao_aleixo.DTO.Uf;
import br.com.votacao_aleixo.object.ObjectGenerico;

public class UfService {

	private static UfService ufService;
	UfDAO ufDAO = null;

	public static UfService getInstance() {
		if (ufService == null) {
			ufService = new UfService();
		}
		return ufService;
	}

	public List<ObjectGenerico> listarUfs() {
		ufDAO = UfDAO.getInstance();
		List<Uf> listaUf = ufDAO.listarTodos();
		List<ObjectGenerico> listaRetorno = new ArrayList<>();
		ObjectGenerico object = null;
		for(Uf uf : listaUf){
			object = new ObjectGenerico();
			object.setId(uf.getIdUf());
			object.setDescricao(uf.getNome() + " " + uf.getSigla());
			listaRetorno.add(object);
		}
		return listaRetorno;
	}
	private UfService() {

	}
}
