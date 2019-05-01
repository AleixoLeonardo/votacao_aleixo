
<!-- Sidebar -->
<%@page import="br.com.votacao_aleixo.BO.PermissaoAcessoBO"%>
<div class="bg-light border-right" id="sidebar-wrapper">
	<div class="sidebar-heading">Votação Aleixo</div>
	<div class="list-group list-group-flush">
<%
	Integer idUsuario  = null;
	PermissaoAcessoBO acessoBO = PermissaoAcessoBO.getInstance();
	if (session == null || session.getValue("idUsuario") == null) {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	} else {
		idUsuario = Integer.parseInt(session.getValue("idUsuario").toString());
	if (acessoBO.verificarAcessoPagina(idUsuario, "1")) {
%>
			<a href="./relatorio/relatorio_votacao.jsp" class="list-group-item list-group-item-action bg-light">Relatório de Votação</a>
<%
				} 
				if (acessoBO.verificarAcessoPagina(idUsuario, "2")) {
%>
			<a href="#" class="list-group-item list-group-item-action bg-light">Relatório de Auditoria</a>
<%
				} if (acessoBO.verificarAcessoPagina(idUsuario, "3")) {
%>
				<a href="./usuario/cadastro-usuario.jsp"
					class="list-group-item list-group-item-action bg-light">Cadastro de Usuário</a>
<%
				}
				if (acessoBO.verificarAcessoPagina(idUsuario, "4")) {
%>
					<a href="./voto/secao.jsp" class="list-group-item list-group-item-action bg-light">Seção</a>
<%
				}
	}
%>
	</div>
</div>