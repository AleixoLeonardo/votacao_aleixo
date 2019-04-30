package br.com.votacao_aleixo.service;

import java.util.ArrayList;
import java.util.List;

import br.com.votacao_aleixo.DAO.MunicipioDAO;
import br.com.votacao_aleixo.DAO.MunicipioDAO;
import br.com.votacao_aleixo.DTO.Municipio;
import br.com.votacao_aleixo.DTO.Municipio;
import br.com.votacao_aleixo.object.ObjectGenerico;

public class MunicipioService {

	private static MunicipioService municipioService;
	MunicipioDAO municipioDAO = null;

	public static MunicipioService getInstance() {
		if (municipioService == null) {
			municipioService = new MunicipioService();
		}
		return municipioService;
	}

	public List<ObjectGenerico> listarMunicipios(Integer idUf) {
		municipioDAO = MunicipioDAO.getInstance();
		List<Municipio> listaMunicipio = municipioDAO.listarPorUf(idUf);
		List<ObjectGenerico> listaRetorno = new ArrayList<>();
		ObjectGenerico object = null;
		for(Municipio municipio : listaMunicipio){
			object = new ObjectGenerico();
			object.setId(municipio.getIdMunicipio());
			object.setDescricao(municipio.getNome());
			listaRetorno.add(object);
		}
		return listaRetorno;
	}
	private MunicipioService() {

	}
}
