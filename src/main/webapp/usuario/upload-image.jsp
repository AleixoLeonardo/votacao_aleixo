<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<form method="post"
id="form_image"
	enctype="multipart/form-data">

	<p>
		Buscar Arquivo : <input type="file" name="file" size="45" />
	</p>

	<input type="submit" value="Enviar" id="btnSubmit"  onclick="enviarImagem();"/>
</form>