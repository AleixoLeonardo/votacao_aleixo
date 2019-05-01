function onRowSelect(id){
	$("#modal_verificacal").modal('show');
	$("#secao_selecionada").val(id.split("|")[0]);
	$("#secao_eleitor").val(id.split("|")[1]);
	$("#secao_eleitor").prop("disabled", true);
}

function verificar(){
	sendGET("secao_voto/verificar_titulo/" + $("#titulo_eleitor").val() + "/"
			 +  $("#secao_eleitor").val() , "", sucessoVerificar);
}

function sucessoVerificar(data){
	var mensagem = JSON.parse(data);
	if(mensagem.id == 0 ){
		alertify
		.error(mensagem.descricao);
	}else{
		alertify
		.success(mensagem.descricao);
		irParaVotacao(mensagem.id);
	}

}

function limpar(){
	$("#numero_candidato").val(""); 
	$("#candidato").html("")
}
function irParaVotacao(idUsuario){
	document.location.href = "./voto.jsp?secao=" +$("#secao_selecionada").val() + "&idUsuario=" + idUsuario ;
}

function digitar(numero){
	var numeroAntigo = $("#numero_candidato").val() + "";
	var numeroNovo = numeroAntigo + numero;
	$("#numero_candidato").val(numeroNovo + "");
	if(numeroNovo != null && numeroNovo != undefined && numeroNovo != ""){
		buscarCandidato(numeroNovo);	
	}
	
}

function buscarCandidato(numeroCandidato) {
	$.ajax({
		type : "GET",
		url : "./ajax_buscar_candidato.jsp?numeroCandidato=" + numeroCandidato,
		dataType : "html",
		success : function(data) {
			$("#candidato").html(data.trim())
			return data;
		},
		error : function() {
			
		}
	});
}
