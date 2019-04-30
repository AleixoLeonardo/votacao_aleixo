package br.com.votacao_aleixo.service;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.votacao_aleixo.DAO.MunicipioDAO;
import br.com.votacao_aleixo.DAO.TipoUsuarioDAO;
import br.com.votacao_aleixo.DAO.UsuarioDAO;
import br.com.votacao_aleixo.DAO.ZonaDAO;
import br.com.votacao_aleixo.DTO.Usuario;
import br.com.votacao_aleixo.object.ObjectUsuario;

public class UsuarioService {

	private static UsuarioService usuarioService;
	UsuarioDAO usuarioDAO = null;
	MunicipioDAO municipioDAO = null;
	TipoUsuarioDAO tipoUsuarioDAO = null;
	ZonaDAO zonaDAO = null;

	public static UsuarioService getInstance() {
		if (usuarioService == null) {
			usuarioService = new UsuarioService();
		}
		return usuarioService;
	}

	public List<Usuario> listarUsuarios() {
		usuarioDAO = UsuarioDAO.getInstance();
		return usuarioDAO.listarTodos();
	}

	private UsuarioService() {

	}

	public ObjectUsuario getById(Integer idUsuario) {
		ObjectUsuario objectUsuario = null;
		Usuario usuario = usuarioDAO.getById(idUsuario);
		if (usuario != null) {
			SimpleDateFormat anoMesDia = new SimpleDateFormat();
			objectUsuario = new ObjectUsuario();
			if(usuario.getDataEmissao() != null){
				objectUsuario.setDataEmissao(anoMesDia.format(usuario.getDataEmissao()));
			}
			if(usuario.getDataNascimento() != null){
				objectUsuario.setDataNascimento(anoMesDia.format(usuario.getDataNascimento()));	
			}
			objectUsuario.setNome(usuario.getNome());
			objectUsuario.setIdUsuario(usuario.getIdUsuario());
			objectUsuario.setMunicipio(usuario.getMunicipio() != null ? usuario.getMunicipio().getIdMunicipio() : null);
			objectUsuario.setNumeroTitulo(usuario.getNumeroTitulo());
			objectUsuario.setSenha(usuario.getSenha());
			objectUsuario.setTipoUsuario(usuario.getTipoUsuario().getIdTipoUsuario());
			objectUsuario.setUrlFoto(usuario.getUrlFoto());
			objectUsuario.setZona(usuario.getZona() != null ? usuario.getZona().getIdZona() : null);
			objectUsuario.setUf(usuario.getMunicipio() != null ? usuario.getMunicipio().getUf().getIdUf() : null);
			objectUsuario.setSecao(usuario.getZona() != null ? usuario.getZona().getSecao().getIdSecao() : null);
		}
		return objectUsuario;
	}

	public ObjectUsuario add(ObjectUsuario objectUsuario) {
		SimpleDateFormat anoMesDia = new SimpleDateFormat();
		municipioDAO = MunicipioDAO.getInstance();
		usuarioDAO = UsuarioDAO.getInstance();
		tipoUsuarioDAO = TipoUsuarioDAO.getInstance();
		zonaDAO = ZonaDAO.getInstance();
		Usuario usuario = new Usuario();
		try {
			usuario.setDataEmissao(anoMesDia.parse(objectUsuario.getDataEmissao()));
			usuario.setDataNascimento(anoMesDia.parse(objectUsuario.getDataNascimento()));
		} catch (Exception e) {

		}
		usuario.setMunicipio(municipioDAO.getById(objectUsuario.getMunicipio()));
		usuario.setNome(objectUsuario.getNome());
		usuario.setNumeroTitulo(objectUsuario.getNumeroTitulo());
		usuario.setSenha(objectUsuario.getSenha());
		usuario.setTipoUsuario(tipoUsuarioDAO.getById(objectUsuario.getTipoUsuario()));
		usuario.setZona(zonaDAO.getById(objectUsuario.getZona()));
		usuarioDAO.save(usuario);
		return objectUsuario;
	}

	public Usuario verificaUsuario(String numeroTitulo, String senha) {
		usuarioDAO = UsuarioDAO.getInstance();
		Usuario usuario = null;
		usuario = usuarioDAO.verificaUsuario(numeroTitulo, senha);
		return usuario;
	}
}
