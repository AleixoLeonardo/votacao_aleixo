package br.com.votacao_aleixo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.votacao_aleixo.object.ObjectGenerico;
import br.com.votacao_aleixo.service.SecaoVotoService;

@Path("/secao_voto")
public class SecaoVotoController {
	SecaoVotoService secaoVotoService = SecaoVotoService.getInstance();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/verificar_titulo/{titulo}/{secao}/")
	public ObjectGenerico getAll(@PathParam("titulo") String titulo, @PathParam("secao") String secao) {
		return secaoVotoService.verificarTitulo(titulo, secao);
	}
}
