package br.com.votacao_aleixo.BO;

import br.com.votacao_aleixo.DAO.UsuarioDAO;
import br.com.votacao_aleixo.DTO.Usuario;

public class PermissaoAcessoBO {

	private static PermissaoAcessoBO permissaoAcessoBO;

	public static PermissaoAcessoBO getInstance() {
		if (permissaoAcessoBO == null) {
			permissaoAcessoBO = new PermissaoAcessoBO();
		}

		return permissaoAcessoBO;
	}

	public boolean verificarAcessoPagina(Integer idUsuario, String modulo) {
		UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
		Usuario usuario = usuarioDAO.getById(idUsuario);
		return usuario.getTipoUsuario().getModulos().contains(modulo);
	}
}
