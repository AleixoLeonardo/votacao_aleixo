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

	String base64File = "";
	String base = "";
	File file = new File(Constante.getPath() + usuario.getUrlFoto());
	try (FileInputStream imageInFile = new FileInputStream(file)) {
		// Reading a file from file system
		byte fileData[] = new byte[(int) file.length()];
		imageInFile.read(fileData);
		base = Base64.getEncoder().encodeToString(fileData);
		String header = "";
        if(file.getName().contains("png")) {
                header = "data:image/png;base64,";
        } else if(file.getName().contains("jpg") || file.getName().contains("jpeg")) {
                header = "data:image/jpg;base64,";
        }
        base64File = header + base;

	} catch (FileNotFoundException e) {
		System.out.println("File not found" + e);
	} catch (IOException ioe) {
		System.out.println("Exception while reading the file " + ioe);
	}
%>
<h3><%=usuario.getNome()%></h3>
<%
	
%>
<img src="<%=base64File%>" style="width: 100px;height: 180px;">

<%
	
%>