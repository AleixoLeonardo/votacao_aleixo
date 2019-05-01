package br.com.votacao_aleixo.service;

import java.util.Date;
import java.util.List;

import br.com.votacao_aleixo.DAO.SecaoVotoDAO;
import br.com.votacao_aleixo.DAO.UsuarioDAO;
import br.com.votacao_aleixo.DAO.VotoDAO;
import br.com.votacao_aleixo.DTO.SecaoVoto;
import br.com.votacao_aleixo.DTO.Usuario;
import br.com.votacao_aleixo.DTO.Voto;
import br.com.votacao_aleixo.object.ObjectGenerico;

public class VotoService {

	private static VotoService votoService;
	VotoDAO votoDAO = null;

	public static VotoService getInstance() {
		if (votoService == null) {
			votoService = new VotoService();
		}
		return votoService;
	}

	public List<Voto> listarVotos() {
		votoDAO = VotoDAO.getInstance();
		return votoDAO.listarTodos();
	}

	private VotoService() {

	}

	public ObjectGenerico votar(Integer idSecaoAberta, Integer eleitor, Integer candidato) {
		SecaoVotoDAO secaoVotoDAO = SecaoVotoDAO.getInstance();
		SecaoVoto secaoVoto = secaoVotoDAO.pegarSecaoAberta(idSecaoAberta, eleitor);
		ObjectGenerico generico = new ObjectGenerico();
		if (secaoVoto == null) {
			generico.setId(0);
			generico.setDescricao("Você já possui um Voto nesta Seção ou a Seção já está fechada");
		} else {
			// se for diferente de null, a seção está aberta
			if (secaoVoto != null) {
				UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
				Usuario usuarioEleitor = usuarioDAO.getById(eleitor);
				if (usuarioEleitor != null) {
					Usuario usuarioCandidato = usuarioDAO.getById(candidato);
					if (usuarioCandidato != null) {
						Voto voto = new Voto();
						voto.setData(new Date());
						voto.setUsuarioCandidato(usuarioCandidato);
						voto.setUsuarioEleitor(usuarioEleitor);
						voto.setUsuarioSecao(secaoVoto.getUsuarioAbertura());
						voto.setSecaoVoto(secaoVoto);
						VotoDAO votoDAO = VotoDAO.getInstance();
						votoDAO.save(voto);
						generico.setId(1);
						generico.setDescricao("Seu Voto foi Salvo com Sucesso");
					} else {
						generico.setId(0);
						generico.setDescricao("Não foi possível Salvar seu Voto");
					}
				} else {
					generico.setId(0);
					generico.setDescricao("Não foi possível Salvar seu Voto");
				}

			}
		}
		return generico;
	}
}
