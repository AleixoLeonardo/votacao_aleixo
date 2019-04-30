<%@page import="br.com.votacao_aleixo.service.SecaoVotoService"%>
<%@page import="br.com.votacao_aleixo.DTO.SecaoVoto"%>
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
			SecaoVotoService secaoVotoService = SecaoVotoService.getInstance();
			List<SecaoVoto> listaSecaoVoto = secaoVotoService.listarSecoesVoto();
	%>
	<div class="d-flex" id="wrapper">
		<%@ include file="../template/sidebar.jsp"%>
		<div id="page-content-wrapper">
			<%@ include file="../template/topbar.jsp"%>
			<div class="container-fluid">
				<h3>Seções Atuais</h3>
				<div id="botoes_lista"
					style="width: 100%; text-align: right; padding-bottom: 50px;">
					<button type="button" class="btn btn-primary"
						onclick="abrirSecao();">Abrir Seção</button>
				</div>
				<div id="lista">
					<table>
						<tr>
							<th>ID</th>
							<th>Seção</th>
							<th>Status</th>
						</tr>
						<%
							for (SecaoVoto secaoVoto : listaSecaoVoto) {
						%>
						<tr onclick="onRowSelect(<%=secaoVoto.getIdSecaoVoto()%>);">
							<td><%=secaoVoto.getIdSecaoVoto()%></td>
							<td><%=secaoVoto.getSecao().getNome()%></td>
							<td>
								<%
									if (secaoVoto.getStatus()) {
								%>Aberta<%
									} else {
								%>Fechada<%
									}
								%>
							</td>
						</tr>
						<%
							}
						%>
					</table>
				</div>
			</div>
		</div>

	</div>


	<%
		}
	%>
	<!-- The Modal -->
	<div class="modal" id="modal_verificacal" role="dialog"
		style="min-width: 1024px !important;">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Verificação de Título</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="titulo_eleitor">Título do Eleitor</label> <input type="text"
							class="form-control" id="titulo_eleitor" placeholder="Nome">
					</div>
					<div class="form-group">
						<label for="secao_eleitor">Seção</label> <input type="text"
							class="form-control" id="secao_eleitor" placeholder="Nome">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success" onclick="verificar();">Verificar</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
				</div>
			</div>
			<input type="hidden" id="secao_selecionada" name="secao_selecionada">

		</div>
	</div>
</body>

<!-- Bootstrap core JavaScript -->
<script src="../vendor/jquery/jquery.min.js"></script>
<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<script src="../js/comum.js" charset="ISO-8859-1"></script>
<script src="../js/voto.js" charset="ISO-8859-1"></script>
</html>
