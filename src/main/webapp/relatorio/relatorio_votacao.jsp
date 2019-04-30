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
	%>
	<div class="d-flex" id="wrapper">
		<%@ include file="../template/sidebar.jsp"%>
		<div id="page-content-wrapper">
			<%@ include file="../template/topbar.jsp"%>
			<div class="container-fluid">
				<h3>Relatório de Votação</h3>
				<table>
					<tr class="header">
						<th>Usuário Eleitor</th>
						<th>Usuário Candidato</th>
						<th>Usuário Seção</th>
						<th>Horário</th>
					</tr>
					<tr>
						<td>Rafael</td>
						<td>Jetulio Vargas</td>
						<td>Pedro</td>
						<td> 29/04/2019 12:25</td>
					</tr>
					<tr>
						<td>Otavio</td>
						<td>José Sarnei</td>
						<td>Pedro</td>
						<td> 29/04/2019 12:25</td>
					</tr>
					<tr>
						<td>Marcos</td>
						<td>Lula</td>
						<td>Pedro</td>
						<td> 29/04/2019 12:25</td>
					</tr>
					<tr>
						<td>Olavo</td>
						<td>Juscelino Kubischeck</td>
						<td>Amanda</td>
						<td> 29/04/2019 12:25</td>
					</tr>
					<tr>
						<td>Antonio</td>
						<td>Bolsonaro</td>
						<td>Amir</td>
						<td> 29/04/2019 12:25</td>
					</tr>
					<tr>
						<td>Abraão</td>
						<td>Marina Silva</td>
						<td>Amanda</td>
						<td> 29/04/2019 12:25</td>
					</tr>
				</table>
			</div>
		</div>

	</div>

	<%
		}
	%>

</body>

<!-- Bootstrap core JavaScript -->
<script src="../vendor/jquery/jquery.min.js"></script>
<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<script src="../js/comum.js" charset="ISO-8859-1"></script>
<script src="../js/cadastro_usuario.js" charset="ISO-8859-1"></script>
</html>
