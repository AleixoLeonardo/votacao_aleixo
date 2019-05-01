<%@page import="br.com.votacao_aleixo.object.ObjectRelatorio"%>
<%@page import="br.com.votacao_aleixo.util.Util"%>
<%@page import="br.com.votacao_aleixo.util.Constante"%>
<%@page import="br.com.votacao_aleixo.DAO.VotoDAO"%>
<%@page import="br.com.votacao_aleixo.DTO.Voto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String secao = request.getParameter("secao");
	VotoDAO votoDAO = VotoDAO.getInstance();
	List<ObjectRelatorio> listaVoto =  votoDAO.listarRelatorio(Integer.parseInt(secao));
	
	String path = Constante.getPath();
	Util util = new Util();
%>
<div class="container">
	<div class="row">
		<%
			for (ObjectRelatorio voto : listaVoto) {
		%>
		<div class="col-sm-3">
			<img src="<%=util.getBase64Image(path + voto.getUrl())%>" style="width: 160px; height: 180px;">
			
			<div style="text-align: center;">
				<h3> <%=voto.getNome()%></h3><br>
				<h4><%=voto.getQuantidade()%> Votos</h4>
			</div>
		</div>

		<%
			}
		%>
	</div>
</div>