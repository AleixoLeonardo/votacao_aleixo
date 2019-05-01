function  buscarSecoes(){
	sendGET("secao/get_all/", "", sucessoBuscarSecoes);
}
function sucessoBuscarSecoes(data){
	var lista = JSON.parse(data);
	var select = "<select class='custom-select' id='secao_filtro' " +
			" onchange='buscarRelatorio(this)'>";
	var fimSelect= "</select>"
	var option = "<option value='0'>Todos</option>";
	for(var i = 0; i < lista.length; i++){
		option += "<option value='"+lista[i].id+"'>"+lista[i].descricao+"</option>"
	}
	var conteudo = select + option + fimSelect;
	$("#div_secao").empty();
	$("#div_secao").append(conteudo);
}

function buscarRelatorio(element){
	$.ajax({
		type : "GET",
		url : "./ajax_montar_relatorio.jsp?secao=" + element.value,
		dataType : "html",
		success : function(data) {
			$("#relatorio").html(data.trim());
			return data;
		},
		error : function() {
			
		}
	});
}