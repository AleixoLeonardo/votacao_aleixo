function onRowSelect(idUsuario) {
	$("#usuario_form").modal('show');
	buscarUf();
	buscarSecao();
	buscarTipoUsuario();
	$("#btn_upload").prop("disabled", true);
	$("#usuario_senha").prop("disabled", true);
	$("#id_usuario").val(idUsuario);
	getUsuarioById(idUsuario);
}
function adicionarNovo() {
	$("#usuario_form").modal('show');
	$("#id_usuario").val("-1");
	buscarUf();
	buscarSecao();
	buscarTipoUsuario();
}
function getUsuarioById(id) {
	sendGET("usuario/get_by_id/" + id, "", sucessoBuscarUsuario);
}
function sucessoBuscarUsuario(data) {
	var usuario = JSON.parse(data);
	$("#usuario_nome").val(usuario.nome);
	$("#usuario_uf").val(usuario.uf);
	if (usuario.uf != null) {
		buscarMunicipio();
		$("#usuario_municipio").val(usuario.municipio);
	}
	$("#usuario_data_nascimento").val(usuario.dataNascimento.substring(0, 10));
	$("#usuario_numero_titulo").val(usuario.numeroTitulo);
	$("#usuario_data_emissao").val(usuario.dataEmissao.substring(0, 10));
	$("#usuario_secao").val(usuario.secao);
	if (usuario.secao != null) {
		buscarZona();
		$("#usuario_zona").val(usuario.zona);
	}
	$("#usuario_senha").val(usuario.senha);
	$("#usuario_tipo_usuario").val(usuario.tipoUsuario);
}
function voltarParaListaUsuario() {
	$("#edicao").hide();
	$("#botoes_edicao").hide();
	$("#botoes_lista").show();
	$("#lista").show();
}
function editarSenha(element) {
	if (element.checked) {
		$("#usuario_senha").removeAttr("disabled");
	} else {
		$("#usuario_senha").prop("disabled", true);
	}
}
function abrirUpload() {
	$("#upload_imagem").modal("show");
}

function verificaDado(dado) {
	if (dado != null && dado != undefined && dado != "") {
		return true;
	}
	return false;
}

function salvar() {

	var usuarioNome = $("#usuario_nome").val().trim();
	var usuarioUf = $("#usuario_uf").val().trim();
	var usuarioMunicipio = $("#usuario_municipio").val().trim();

	var usuarioDataNascimento = $("#usuario_data_nascimento").val().trim();
	var usuarioNumeroTitulo = $("#usuario_numero_titulo").val().trim();
	var usuarioDataEmissao = $("#usuario_data_emissao").val().trim();
	var usuarioSecao = $("#usuario_secao").val().trim();
	var usuarioZona = $("#usuario_zona").val().trim();
	var usuarioSenha = $("#usuario_senha").val().trim();
	var usuarioTipoUsuario = $("#usuario_tipo_usuario").val().trim();
	if (verificaDado(usuarioNome)) {
		if (verificaDado(usuarioUf)) {
			if (verificaDado(usuarioMunicipio)) {
				if (verificaDado(usuarioDataNascimento)) {
					if (verificaDado(usuarioNumeroTitulo)) {
						if (verificaDado(usuarioDataEmissao)) {
							if (verificaDado(usuarioSecao)) {
								if (verificaDado(usuarioZona)) {
									if (verificaDado(usuarioTipoUsuario)) {
										if ($("#usuario_editar_senha").is(
												":checked")) {
											if (verificaDado(usuarioSenha)) {
												montarObjeto(usuarioNome,
														usuarioUf,
														usuarioMunicipio,
														usuarioDataNascimento,
														usuarioNumeroTitulo,
														usuarioDataEmissao,
														usuarioSecao,
														usuarioZona,
														usuarioSenha,
														usuarioTipoUsuario);
											} else {
												alertify
														.warning("Insira a Senha");
											}
										} else {
											montarObjeto(usuarioNome,
													usuarioUf,
													usuarioMunicipio,
													usuarioDataNascimento,
													usuarioNumeroTitulo,
													usuarioDataEmissao,
													usuarioSecao, usuarioZona,
													usuarioSenha,
													usuarioTipoUsuario);
										}
									} else {
										alertify
												.warning("Insira o Tipo de Usuário");
									}
								} else {
									alertify.warning("Insira a Zona");
								}
							} else {
								alertify.warning("Insira a Seção");
							}
						} else {
							alertify.warning("Insira a Data de Emissão");
						}
					} else {
						alertify.warning("Insira o Número do Título");
					}
				} else {
					alertify.warning("Insira a  Data de Nascimento");
				}
			} else {
				alertify.warning("Insira o Município");
			}
		} else {
			alertify.warning("Insira o UF");
		}
	} else {
		alertify.warning("Insira o Nome");
	}
}

function montarObjeto(usuarioNome, usuarioUf, usuarioMunicipio,
		usuarioDataNascimento, usuarioNumeroTitulo, usuarioDataEmissao,
		usuarioSecao, usuarioZona, usuarioSenha, usuarioTipoUsuario) {
	var idUsuario = null;
	if ($("#id_usuario").val() != "-1") {
		idUsuario = parseInt($("#id_usuario").val());
	}
	var usuario = {
		idUsuario : idUsuario,
		nome : usuarioNome,
		uf : parseInt(usuarioUf),
		dataNascimento : usuarioDataNascimento,
		municipio : parseInt(usuarioMunicipio),
		numeroTitulo : usuarioNumeroTitulo,
		dataEmissao : usuarioDataEmissao,
		zona : parseInt(usuarioZona),
		tipoUsuario : parseInt(usuarioTipoUsuario),
		senha : usuarioSenha,
		urlFoto : "",
		secao : parseInt(usuarioSecao)
	}
	sendPOSTJSON("usuario/salvar", usuario) 
	alert(JSON.stringify(usuario))
}