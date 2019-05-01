<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<script
	src="//cdn.jsdelivr.net/npm/alertifyjs@1.11.2/build/alertify.min.js"></script>

<link href="../css/style.css" rel="stylesheet" type="text/css">
<link href="../css/voto/voto.css" rel="stylesheet" type="text/css">



<!-- Bootstrap core CSS -->
<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- CSS -->
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/alertifyjs@1.11.2/build/css/alertify.min.css" />
<!-- Default theme -->
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/alertifyjs@1.11.2/build/css/themes/default.min.css" />
<!-- Semantic UI theme -->
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/alertifyjs@1.11.2/build/css/themes/semantic.min.css" />
<!-- Bootstrap theme -->
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/alertifyjs@1.11.2/build/css/themes/bootstrap.min.css" />

<!-- 
    RTL version
-->
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/alertifyjs@1.11.2/build/css/alertify.rtl.min.css" />
<!-- Default theme -->
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/alertifyjs@1.11.2/build/css/themes/default.rtl.min.css" />
<!-- Semantic UI theme -->
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/alertifyjs@1.11.2/build/css/themes/semantic.rtl.min.css" />
<!-- Bootstrap theme -->
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/alertifyjs@1.11.2/build/css/themes/bootstrap.rtl.min.css" />

<!-- Custom styles for this template -->
<link href="../css/simple-sidebar.css" rel="stylesheet">
<title>Voto</title>
</head>
<body>
	<center>
		<div id="candidato"></div>
	</center>
	<center>
		<input type="text" disabled id="numero_candidato"
			name="numero_candidato" style="width: 300px; height: 40px;">
		<br>
		<button type="button" class="btn btn-primary voto"
			onclick="digitar('1')">1</button>
		<button type="button" class="btn btn-primary voto"
			onclick="digitar('2')">2</button>
		<button type="button" class="btn btn-primary voto"
			onclick="digitar('3')">3</button>
		<br>
		<button type="button" class="btn btn-primary voto"
			onclick="digitar('4')">4</button>
		<button type="button" class="btn btn-primary voto"
			onclick="digitar('5')">5</button>
		<button type="button" class="btn btn-primary voto"
			onclick="digitar('6')">6</button>
		<br>
		<button type="button" class="btn btn-primary voto"
			onclick="digitar('7')">7</button>
		<button type="button" class="btn btn-primary voto"
			onclick="digitar('8')">8</button>
		<button type="button" class="btn btn-primary voto"
			onclick="digitar('9')">9</button>
		<br>
		<button type="button" class="btn  voto" onclick="limpar()"
		style="background-color: #ffa84b">Limpar</button>
		<button type="button" class="btn btn-primary voto"
			onclick="digitar('0')">0</button>
			
			
		<button type="button" id="votar" disabled class="btn btn-success voto"
		 onclick="votar();">Confirma</button>
		<br>
<input type="hidden" id="secao" name="secao" value="<%=request.getParameter("secao")%>">
<input type="hidden" id="eleitor" name="eleitor" value="<%=request.getParameter("idUsuario")%>">

	</center>
</body>

<script src="../js/comum.js" charset="ISO-8859-1"></script>
<script src="../js/voto.js" charset="ISO-8859-1"></script>
</html>
