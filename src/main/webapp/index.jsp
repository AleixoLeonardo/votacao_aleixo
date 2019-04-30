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

<!-- Bootstrap core CSS -->
<link href="./vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/simple-sidebar.css" rel="stylesheet">
<title>Cadastro de Usuário</title>
</head>
<body>
	<%
		//Verifica se está logado
		if (session.getValue("loginUsuario") == null) {
	%>
	<%@ include file="error403.jsp"%>
	<%
		} else {
	%>
	<div class="d-flex" id="wrapper">
		<%@ include file="template/sidebar.jsp"%>
		<div id="page-content-wrapper">
			<%@ include file="template/topbar.jsp"%>
			<div class="container-fluid">
			
			</div>
		</div>
	</div>
	<%
		}
	%>
</body>

<!-- Bootstrap core JavaScript -->
<script src="./vendor/jquery/jquery.min.js"></script>
<script src="./vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Menu Toggle Script -->
<script>
	// 	$("#menu-toggle").click(function(e) {
	// // 		e.preventDefault();
	// // 		$("#wrapper").toggleClass("toggled");
	// 	});
</script>

</html>
