<%@page import="br.com.votacao_aleixo.DAO.VotoDAO"%>
<%@page import="br.com.votacao_aleixo.util.Util"%>
<%@page import="br.com.votacao_aleixo.util.Constante"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.util.Base64"%>
<%@page import="java.io.File"%>
<%@page import="br.com.votacao_aleixo.DTO.Usuario"%>
<%@page import="br.com.votacao_aleixo.DAO.UsuarioDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String numeroCandidato = request.getParameter("numeroCandidato");
	UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
	Usuario usuario = usuarioDAO.buscarCandidatao(numeroCandidato);
	VotoDAO votoDAO = VotoDAO.getInstance();
	if (usuario != null) {
		String base64File = new Util().getBase64Image(Constante.getPath() + usuario.getUrlFoto());
%>
<h3><%=usuario.getNome()%></h3>
<input type="hidden" id="id_candidato" name="id_candidato"
	value="<%=usuario.getIdUsuario()%>">

<%
	
%>
<img src="<%=base64File%>" style="width: 100px; height: 180px;"><br>
<%
	}
%>