/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.votacao_aleixo.DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Leonardo
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome")
    , @NamedQuery(name = "Usuario.findByDataNascimento", query = "SELECT u FROM Usuario u WHERE u.dataNascimento = :dataNascimento")
    , @NamedQuery(name = "Usuario.findByNumeroTitulo", query = "SELECT u FROM Usuario u WHERE u.numeroTitulo = :numeroTitulo")
    , @NamedQuery(name = "Usuario.findByDataEmissao", query = "SELECT u FROM Usuario u WHERE u.dataEmissao = :dataEmissao")
    , @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha")
    , @NamedQuery(name = "Usuario.findByUrlFoto", query = "SELECT u FROM Usuario u WHERE u.urlFoto = :urlFoto")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "nome")
    private String nome;
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Column(name = "numero_titulo")
    private String numeroTitulo;
    @Column(name = "data_emissao")
    @Temporal(TemporalType.DATE)
    private Date dataEmissao;
    @Column(name = "senha")
    private String senha;
    @Column(name = "url_foto")
    private String urlFoto;
    @OneToMany(mappedBy = "usuarioSecao")
    private List<Voto> votoList;
    @OneToMany(mappedBy = "usuarioCandidato")
    private List<Voto> votoList1;
    @OneToMany(mappedBy = "usuarioEleitor")
    private List<Voto> votoList2;
    @OneToMany(mappedBy = "usuarioAlteracao")
    private List<LogAlteracao> logAlteracaoList;
    @JoinColumn(name = "municipio", referencedColumnName = "id_municipio")
    @ManyToOne
    private Municipio municipio;
    @JoinColumn(name = "tipo_usuario", referencedColumnName = "id_tipo_usuario")
    @ManyToOne
    private TipoUsuario tipoUsuario;
    @JoinColumn(name = "zona", referencedColumnName = "id_zona")
    @ManyToOne
    private Zona zona;
    @OneToMany(mappedBy = "usuarioAbertura")
    private List<SecaoVoto> secaoVotoList;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNumeroTitulo() {
        return numeroTitulo;
    }

    public void setNumeroTitulo(String numeroTitulo) {
        this.numeroTitulo = numeroTitulo;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
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

    @XmlTransient
    public List<Voto> getVotoList() {
        return votoList;
    }

    public void setVotoList(List<Voto> votoList) {
        this.votoList = votoList;
    }

    @XmlTransient
    public List<Voto> getVotoList1() {
        return votoList1;
    }

    public void setVotoList1(List<Voto> votoList1) {
        this.votoList1 = votoList1;
    }

    @XmlTransient
    public List<Voto> getVotoList2() {
        return votoList2;
    }

    public void setVotoList2(List<Voto> votoList2) {
        this.votoList2 = votoList2;
    }

    @XmlTransient
    public List<LogAlteracao> getLogAlteracaoList() {
        return logAlteracaoList;
    }

    public void setLogAlteracaoList(List<LogAlteracao> logAlteracaoList) {
        this.logAlteracaoList = logAlteracaoList;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    @XmlTransient
    public List<SecaoVoto> getSecaoVotoList() {
        return secaoVotoList;
    }

    public void setSecaoVotoList(List<SecaoVoto> secaoVotoList) {
        this.secaoVotoList = secaoVotoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.votacao_aleixo.DTO.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
