<%@page import="br.com.votacao_aleixo.service.UsuarioService"%>
<%@page import="br.com.votacao_aleixo.DTO.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>


<link href="../css/style.css" rel="stylesheet" type="text/css">



<!-- Bootstrap core CSS -->
<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../css/simple-sidebar.css" rel="stylesheet">
<title>Cadastro de Usuário</title>
</head>
<body>
	<%
		//Verifica se está logado
		if (session.getValue("loginUsuario") == null) {
	%>
	<%@ include file="../error403.jsp"%>
	<%
		} else {
			UsuarioService usuarioService = UsuarioService.getInstance();
			List<Usuario> listaUsuario = usuarioService.listarUsuarios();
	%>
	<div class="d-flex" id="wrapper">
		<%@ include file="../template/sidebar.jsp"%>
		<div id="page-content-wrapper">
			<%@ include file="../template/topbar.jsp"%>
			<div class="container-fluid">
				<h3>Cadastro de Usuário</h3>
				<div id="botoes_lista"
					style="width: 100%; text-align: right; padding-bottom: 50px;">
					<button type="button" class="btn btn-primary" onclick="adicionarNovo();">Adicionar</button>
				</div>
				<div id="botoes_edicao"
					style="width: 100%; text-align: right; padding-bottom: 50px; display: none;">
					<button type="button" class="btn btn-warning"
						onclick="voltarParaListaUsuario();">Voltar</button>
				</div>
				<div id="lista">
					<table>
						<tr>
							<th>Nome</th>
							<th>Data Nacimento</th>
							<th>Título</th>
						</tr>
						<%
							for (Usuario usuario : listaUsuario) {
						%>
						<tr onclick="onRowSelect(<%=usuario.getIdUsuario()%>);">
							<td><%=usuario.getNome()%></td>
							<td><%=usuario.getDataNascimento()%></td>
							<td><%=usuario.getNumeroTitulo()%></td>
						</tr>
						<%
							}
						%>
					</table>
				</div>
				<div id="edicao" style="display: none;"></div>
			</div>
		</div>

	</div>
	<!-- The Modal -->
	<div class="modal" id="usuario_form" role="dialog"
		style="min-width: 1024px !important;">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Usuário</h4>
				</div>
				<div class="modal-body">
					<%@ include file="usuario-form.jsp"%>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success" onclick="salvar();">Salvar</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
				</div>
			</div>

		</div>
	</div>

	<!-- The Modal -->
	<div class="modal" id="upload_imagem" role="dialog"
		style="min-width: 1024px !important;">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Imagem</h4>
				</div>
				<div class="modal-body">
					<%@ include file="upload-image.jsp"%>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
				</div>
			</div>

		</div>
	</div>
	<%
		}
	%>
	<input type="hidden" id="index_edicao" name="index_edicao">

</body>

<!-- Bootstrap core JavaScript -->
<script src="../vendor/jquery/jquery.min.js"></script>
<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<script src="../js/comum.js" charset="ISO-8859-1"></script>
<script src="../js/cadastro_usuario.js" charset="ISO-8859-1"></script>
</html>
