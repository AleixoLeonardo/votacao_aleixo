package br.com.votacao_aleixo.object;

import java.util.Date;

public class ObjectUsuario {
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Integer getMunicipio() {
		return municipio;
	}
	public void setMunicipio(Integer municipio) {
		this.municipio = municipio;
	}
	public String getNumeroTitulo() {
		return numeroTitulo;
	}
	public void setNumeroTitulo(String numeroTitulo) {
		this.numeroTitulo = numeroTitulo;
	}
	public String getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	public Integer getZona() {
		return zona;
	}
	public void setZona(Integer zona) {
		this.zona = zona;
	}
	public Integer getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(Integer tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getUrlFoto() {
		return urlFoto;
	}
	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getUf() {
		return uf;
	}
	public void setUf(Integer uf) {
		this.uf = uf;
	}

	public Integer getSecao() {
		return secao;
	}
	public void setSecao(Integer secao) {
		this.secao = secao;
	}
	
	private Integer idUsuario;
	private String nome;
	private Integer uf;
	private String dataNascimento;
	private Integer municipio;
	private String numeroTitulo;
	private String dataEmissao;
	private Integer zona;
	private Integer tipoUsuario;
	private String senha;
	private String urlFoto;
	private Integer secao;

}
