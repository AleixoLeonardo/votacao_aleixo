package br.com.votacao_aleixo.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.votacao_aleixo.object.ObjectGenerico;
import br.com.votacao_aleixo.service.ZonaService;

@Path("/zona")
public class ZonaController {
	ZonaService zonaService = ZonaService.getInstance();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/get_all/{idSecao}")
	public List<ObjectGenerico> getBySecao(@PathParam("idSecao") int idSecao) {
		return zonaService.listarZonas(idSecao);
	}
}
