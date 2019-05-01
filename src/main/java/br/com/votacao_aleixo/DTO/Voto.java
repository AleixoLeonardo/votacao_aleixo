/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.votacao_aleixo.DTO;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leonardo
 */
@Entity
@Table(name = "voto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Voto.findAll", query = "SELECT v FROM Voto v")
    , @NamedQuery(name = "Voto.findByIdVoto", query = "SELECT v FROM Voto v WHERE v.idVoto = :idVoto")
    , @NamedQuery(name = "Voto.findByData", query = "SELECT v FROM Voto v WHERE v.data = :data")})
public class Voto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_voto")
    private Integer idVoto;
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @JoinColumn(name = "secao_voto", referencedColumnName = "id_secao_voto")
    @ManyToOne
    private SecaoVoto secaoVoto;
    @JoinColumn(name = "usuario_secao", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario usuarioSecao;
    @JoinColumn(name = "usuario_candidato", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario usuarioCandidato;
    @JoinColumn(name = "usuario_eleitor", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario usuarioEleitor;

    public Voto() {
    }

    public Voto(Integer idVoto) {
        this.idVoto = idVoto;
    }

    public Integer getIdVoto() {
        return idVoto;
    }

    public void setIdVoto(Integer idVoto) {
        this.idVoto = idVoto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public SecaoVoto getSecaoVoto() {
        return secaoVoto;
    }

    public void setSecaoVoto(SecaoVoto secaoVoto) {
        this.secaoVoto = secaoVoto;
    }

    public Usuario getUsuarioSecao() {
        return usuarioSecao;
    }

    public void setUsuarioSecao(Usuario usuarioSecao) {
        this.usuarioSecao = usuarioSecao;
    }

    public Usuario getUsuarioCandidato() {
        return usuarioCandidato;
    }

    public void setUsuarioCandidato(Usuario usuarioCandidato) {
        this.usuarioCandidato = usuarioCandidato;
    }

    public Usuario getUsuarioEleitor() {
        return usuarioEleitor;
    }

    public void setUsuarioEleitor(Usuario usuarioEleitor) {
        this.usuarioEleitor = usuarioEleitor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVoto != null ? idVoto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Voto)) {
            return false;
        }
        Voto other = (Voto) object;
        if ((this.idVoto == null && other.idVoto != null) || (this.idVoto != null && !this.idVoto.equals(other.idVoto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.votacao_aleixo.DTO.Voto[ idVoto=" + idVoto + " ]";
    }
    
}
