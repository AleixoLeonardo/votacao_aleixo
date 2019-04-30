package br.com.votacao_aleixo.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.votacao_aleixo.object.ObjectGenerico;
import br.com.votacao_aleixo.service.MunicipioService;

@Path("/municipio")
public class MunicipioController {
	MunicipioService municipioService = MunicipioService.getInstance();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/get_all/{idUf}")
	public List<ObjectGenerico> getByUf(@PathParam("idUf") int idUf) {
		return municipioService.listarMunicipios(idUf);
	}
}
