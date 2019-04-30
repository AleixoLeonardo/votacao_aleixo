<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <input type="hidden" id="id_usuario" name="id_usuario" >
<form >
	<div class="container">
		<div class="row">
			<div class="col-sm">
				<div class="form-group">
					<label for="usuario_nome">Usuário</label> <input type="text"
						class="form-control" id="usuario_nome" placeholder="Nome">
				</div>
			</div>
			<div class="col-sm">
				<div class="form-group" id="div_usuario_uf"></div>
			</div>
			<div class="col-sm">
				<div class="form-group" id="div_usuario_municipio"></div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm">
				<label for="usuario_data_nascimento">Data de Nascimento</label> <input
					type="date" class="form-control" id="usuario_data_nascimento"
					placeholder="dd/MM/YYYY">
			</div>
			<div class="form-group">
				<label for="usuario_nome">Nº Título</label> <input type="text"
					class="form-control" id="usuario_numero_titulo"
					placeholder="Número do Título">
			</div>
			<div class="col-sm">
				<label for="usuario_data_emissao">Data de Emissão</label> <input
					type="date" class="form-control" id="usuario_data_emissao"
					placeholder="dd/MM/YYYY">
			</div>
		</div>
		<div class="row">
			<div class="col-sm">
				<div class="form-group" id="div_usuario_secao"></div>
			</div>
			<div class="col-sm">
				<div class="form-group" id="div_usuario_zona"></div>
			</div>
			<div class="col-sm">
				<div class="form-group" id="div_usuario_tipo_usuario"></div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm">
				Editar Senha <br> <input type="checkbox" name="editar_senha"
				onclick="editarSenha(this);"
				id="usuario_editar_senha"
					value="1" checked="false">

			</div>
			<div class="col-sm">
				<div class="form-group">
					<label for="usuario_senha">Senha</label> <input type="password"
						class="form-control" id="usuario_senha" placeholder="Senha">
				</div>
			</div>
		</div>
	</div>
</form>
<button type="button" class="btn btn-success" id="btn_upload"
	data-dismiss="modal" onclick="abrirUpload();">Imagem</button>
