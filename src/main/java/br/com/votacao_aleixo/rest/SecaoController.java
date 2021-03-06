package br.com.votacao_aleixo.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.votacao_aleixo.object.ObjectGenerico;
import br.com.votacao_aleixo.service.SecaoService;

@Path("/secao")
public class SecaoController {
	SecaoService secaoService = SecaoService.getInstance();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/get_all/")
	public List<ObjectGenerico> getAll() {
		return secaoService.listarSecaos();
	}
}
