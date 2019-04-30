
<%
	String nome = session.getValue("nomeUsuarioLogado").toString();
%>

<!-- JavaScript -->
<script
	src="//cdn.jsdelivr.net/npm/alertifyjs@1.11.2/build/alertify.min.js"></script>
	

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
<nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom" >
<span > Bem Vindo, <%=nome%> </span>
	<form name="logout" method="post" action="Logout" id="form_deslogar" style="width:100%">
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
		 <input type="hidden" id="loginUsuario" name="loginUsuario" value="<%=session.getValue("loginUsuario")%>">
		 <input type="hidden" id="nomeUsuarioLogado" name="nomeUsuarioLogado" value="<%=session.getValue("nomeUsuarioLogado")%>">
		 <input type="hidden" id="idUsuario" name="idUsuario" value="<%=session.getAttribute("idUsuario")%>">
		 <input type="hidden" id="usuario" name="usuario" value="<%=session.getValue("usuario")%>">
			<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
				<li class="nav-item" onclick="sair()">Sair</li>
			</ul>
		</div>
	</form>


</nav>