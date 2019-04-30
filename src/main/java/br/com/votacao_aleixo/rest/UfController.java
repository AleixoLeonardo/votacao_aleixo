package br.com.votacao_aleixo.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.votacao_aleixo.object.ObjectGenerico;
import br.com.votacao_aleixo.service.UfService;

@Path("/uf")
public class UfController {

	UfService ufService = UfService.getInstance();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/get_all")
	public List<ObjectGenerico> getAll() {

		return ufService.listarUfs();
	}

//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("/{contactId}")
//	public Contact getContact(@PathParam("contactId") int id) {
//
//		Contact result = null;
//
//		for (Contact contact : contacts) {
//			if (contact.getId() == id) {
//				result = contact;
//				break;
//			}
//		}
//
//		if (result == null) {
//			throw new WebApplicationException(404);
//		}
//
//		return result;
//	}

	// @POST
	// @Consumes(MediaType.APPLICATION_JSON)
	// @Produces(MediaType.APPLICATION_JSON)
	// public Contact add(Contact contact) {
	//
	// if (contact.getName() == null || contact.getName().trim().equals("")) {
	// throw new WebApplicationException(Response
	// .status(Response.Status.BAD_REQUEST)
	// .entity("O nome do contato é obrigatório").build());
	// }
	//
	// contacts.add(contact);
	// contact.setId(contacts.indexOf(contact) + 1);
	// return contact;
	// }
	//
	// @PUT
	// @Path("/{id}")
	// @Consumes(MediaType.APPLICATION_JSON)
	// public void update(@PathParam("id") int id, Contact contact) {
	// contacts.set(id - 1, contact);
	// contact.setId(contacts.indexOf(contact) + 1);
	// }
}
