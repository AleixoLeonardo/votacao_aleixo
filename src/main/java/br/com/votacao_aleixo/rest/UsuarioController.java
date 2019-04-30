package br.com.votacao_aleixo.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.votacao_aleixo.object.ObjectUsuario;
import br.com.votacao_aleixo.service.UsuarioService;

@Path("/usuario")
public class UsuarioController {
	UsuarioService usuarioService = UsuarioService.getInstance();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/get_by_id/{idUsuario}")
	public ObjectUsuario getById(@PathParam("idUsuario") int idUsuario) {
		return usuarioService.getById(idUsuario);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/salvar")
	public ObjectUsuario add(ObjectUsuario objectUsuario) {
		return usuarioService.add(objectUsuario);
	}
}
