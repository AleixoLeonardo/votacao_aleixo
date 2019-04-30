<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<link href="./css/login.css" rel="stylesheet" type="text/css">
<title>Login</title>
</head>
<body>
	<form name="login" method="post" action="Logar">
		<div class="container">
			<div class="center">
				<label for="uname"> <b>Login</b></label> <input type="text"
					placeholder="Digite o Título" name="numeroTitulo" value="" required>
				<label for="senha"><b>Senha</b></label> <input type="password"
					placeholder="Digite a Senha" name="senha" value="" required>
				<button type="submit">Login</button>
			</div>
		</div>
	</form>
</body>

</html>