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


<link href="../css/style.css" rel="stylesheet" type="text/css">
<link href="../css/voto/voto.css" rel="stylesheet" type="text/css">



<!-- Bootstrap core CSS -->
<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../css/simple-sidebar.css" rel="stylesheet">
<title>Voto</title>
</head>
<body>
	<center>
		<input type="number" disabled id="numero_candidato"
			name="numero_candidato" style="width: 300px; height: 40px;">
		<br>
		<button type="button" class="btn btn-primary voto">1</button>
		<button type="button" class="btn btn-primary voto">2</button>
		<button type="button" class="btn btn-primary voto">3</button>
		<br>
		<button type="button" class="btn btn-primary voto">4</button>
		<button type="button" class="btn btn-primary voto">5</button>
		<button type="button" class="btn btn-primary voto">6</button>
		<br>
		<button type="button" class="btn btn-primary voto">7</button>
		<button type="button" class="btn btn-primary voto">8</button>
		<button type="button" class="btn btn-primary voto">9</button>
		<br>
		<button type="button" class="btn btn-primary voto">Limpar</button>
		<button type="button" class="btn btn-primary voto">0</button>
		<a href="./secao.jsp" >
			<button type="button" onclick="Seu Voto Está Seguro" class="btn btn-primary voto">Votar</button>
		</a>
		<br>

	</center>
</body>
</html>