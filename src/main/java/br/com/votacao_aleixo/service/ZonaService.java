package br.com.votacao_aleixo.service;

import java.util.ArrayList;
import java.util.List;

import br.com.votacao_aleixo.DAO.ZonaDAO;
import br.com.votacao_aleixo.DAO.ZonaDAO;
import br.com.votacao_aleixo.DTO.Zona;
import br.com.votacao_aleixo.DTO.Zona;
import br.com.votacao_aleixo.object.ObjectGenerico;

public class ZonaService {

	private static ZonaService zonaService;
	ZonaDAO zonaDAO = null;

	public static ZonaService getInstance() {
		if (zonaService == null) {
			zonaService = new ZonaService();
		}
		return zonaService;
	}

	public List<ObjectGenerico> listarZonas(Integer idSecao) {
		zonaDAO = ZonaDAO.getInstance();
		List<Zona> listaZona = zonaDAO.listarPorSecao(idSecao);
		List<ObjectGenerico> listaRetorno = new ArrayList<>();
		ObjectGenerico object = null;
		for(Zona zona : listaZona){
			object = new ObjectGenerico();
			object.setId(zona.getIdZona());
			object.setDescricao(zona.getNome());
			listaRetorno.add(object);
		}
		return listaRetorno;
	}
	private ZonaService() {

	}
}
