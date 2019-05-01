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
<title>Relat�rio de Vota��o</title>
</head>
<body>
	<%
		//Verifica se est� logado
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
				<h3>Relat�rio de Vota��o</h3>
				<label for='secoes'>Se��o</label>
				<div class="form-group" id="div_secao"></div>
				<div id="relatorio"></div>
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
<script src="../js/relatorio.js" charset="ISO-8859-1"></script>
<script >
buscarSecoes();
</script>
</html>
