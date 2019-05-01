package br.com.votacao_aleixo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.votacao_aleixo.object.ObjectGenerico;
import br.com.votacao_aleixo.service.VotoService;

@Path("/voto")
public class VotoController {
	VotoService votoSerice = VotoService.getInstance();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/votar/{idSecaoAberta}/{eleitor}/{candidato}/")
	public ObjectGenerico votar(@PathParam("idSecaoAberta") int idSecaoAberta,
			@PathParam("eleitor") int eleitor,
			@PathParam("candidato") int candidato) {
		return votoSerice.votar(idSecaoAberta, eleitor, candidato);
	}
}
