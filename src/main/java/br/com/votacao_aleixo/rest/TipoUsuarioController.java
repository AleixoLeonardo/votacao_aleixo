package br.com.votacao_aleixo.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.votacao_aleixo.object.ObjectGenerico;
import br.com.votacao_aleixo.service.TipoUsuarioService;

@Path("/tipo_usuario")
public class TipoUsuarioController {
	TipoUsuarioService tipoUsuarioService = TipoUsuarioService.getInstance();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/get_all")
	public List<ObjectGenerico> getAll() {
		return tipoUsuarioService.listarTipoUsuarios();
	}
}
