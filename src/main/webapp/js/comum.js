var rootURL = "http://localhost:8080/votacao_aleixo/rest/";

function sendPOSTJSON(url, data) {
	 $.post(rootURL + url, function(data, status){
		    alert("Data: " + data + "\nStatus: " + status);
		  });
	
	
//	$.ajax({
//		type : "POST",
//		url : rootURL + url,
//		data : data,
//		success : success,
//		dataType : "JSON",
//		error : errorsendPOSTJSON
//	});
	
}
function success(data) {
	alertify.success("Enviado com Sucesso!");
}
function errorsendPOSTJSON() {
	alertify.error("Falha ao Enviar")
}

function sendGET(url, data, sucesso) {
	$.ajax({
		url : rootURL + url,
		data : data,
		success : sucesso,
		dataType : "text",
		error:errorSendGET
	});
}
function errorSendGET(data){
	alert("ERRO: " + JSON.stringify(data));
}



/**
 * Uf
 */
function  buscarUf(){
	sendGET("uf/get_all", "", sucessoBuscarUf);
}
function sucessoBuscarUf(data){
	var lista = JSON.parse(data);
	var select = "<label for='usuario_uf'>UF</label><select class='custom-select' id='usuario_uf' onchange='buscarMunicipio()'>";
	var fimSelect= "</select>"
	var option = "<option value=''>Selecione</option>";
	for(var i = 0; i < lista.length; i++){
		option += "<option value='"+lista[i].id+"'>"+lista[i].descricao+"</option>"
	}
	var conteudo = select + option + fimSelect;
	$("#div_usuario_uf").empty();
	$("#div_usuario_uf").append(conteudo);
}
/**
 * Municipio
 */
function  buscarMunicipio(){
	sendGET("municipio/get_all/" + $("#usuario_uf").val(), "", sucessoBuscarMunicipio);
}
function sucessoBuscarMunicipio(data){
	var lista = JSON.parse(data);
	var select = "<label for='usuario_municipio'>Município</label><select class='custom-select' id='usuario_municipio' class='selectpicker' data-show-subtext='true' data-live-search='true'>";
	var fimSelect= "</select>"
	var option = "<option value=''>Selecione</option>";
	for(var i = 0; i < lista.length; i++){
		option += "<option value='"+lista[i].id+"'>"+lista[i].descricao+"</option>"
	}
	var conteudo = select + option + fimSelect;
	$("#div_usuario_municipio").empty();
	$("#div_usuario_municipio").append(conteudo);
	
}

/**
 * Secao
 */
function  buscarSecao(){
	sendGET("secao/get_all/", "", sucessoBuscarSecao);
}
function sucessoBuscarSecao(data){
	var lista = JSON.parse(data);
	var select = "<label for='usuario_secao'>Seção</label><select onchange='buscarZona()' class='custom-select' id='usuario_secao' class='selectpicker' data-show-subtext='true' data-live-search='true'>";
	var fimSelect= "</select>"
	var option = "<option value=''>Selecione</option>";
	for(var i = 0; i < lista.length; i++){
		option += "<option value='"+lista[i].id+"'>"+lista[i].descricao+"</option>"
	}
	var conteudo = select + option + fimSelect;
	$("#div_usuario_secao").empty();
	$("#div_usuario_secao").append(conteudo);
}

/**
 * Zona
 */
function  buscarZona(){
	sendGET("zona/get_all/" + $("#usuario_secao").val(), "", sucessoBuscarZona);
}
function sucessoBuscarZona(data){
	var lista = JSON.parse(data);
	var select = "<label for='usuario_zona'>Zona</label><select class='custom-select' id='usuario_zona' class='selectpicker' data-show-subtext='true' data-live-search='true'>";
	var fimSelect= "</select>"
	var option = "<option value=''>Selecione</option>";
	for(var i = 0; i < lista.length; i++){
		option += "<option value='"+lista[i].id+"'>"+lista[i].descricao+"</option>"
	}
	var conteudo = select + option + fimSelect;
	$("#div_usuario_zona").empty();
	$("#div_usuario_zona").append(conteudo);
}

function  buscarTipoUsuario(){
	sendGET("tipo_usuario/get_all/", "", sucessoBuscarTipoUsuario);
}
function sucessoBuscarTipoUsuario(data){
	var lista = JSON.parse(data);
	var select = "<label for='usuario_tipo_usuario'>Tipo de Usuário</label><select class='custom-select' id='usuario_tipo_usuario' class='selectpicker' data-show-subtext='true' data-live-search='true'>";
	var fimSelect= "</select>"
	var option = "<option value=''>Selecione</option>";
	for(var i = 0; i < lista.length; i++){
		option += "<option value='"+lista[i].id+"'>"+lista[i].descricao+"</option>"
	}
	var conteudo = select + option + fimSelect;
	$("#div_usuario_tipo_usuario").empty();
	$("#div_usuario_tipo_usuario").append(conteudo);
}

function enviarImagem(){
	 event.preventDefault();
     // capture o formulário
     var form = $('#form_image')[0];
     // crie um FormData {Object}
     var data = new FormData(form);
	
	 $.ajax({
         type: "POST",
         enctype: 'multipart/form-data',
         url: "/votacao_aleixo/rest/file/upload/image",
         data: data,
         processData: false, // impedir que o jQuery tranforma a "data" em querystring
         contentType: false, // desabilitar o cabeçalho "Content-Type"
         cache: false, // desabilitar o "cache"
         timeout: 600000, // definir um tempo limite (opcional)
         // manipular o sucesso da requisição
         success: function (data) {
             console.log(data);
         },
         // manipular erros da requisição
         error: function (e) {
             console.log(e);
         }
     });
}
function sair(){
	document.getElementById('form_deslogar').submit();
}




