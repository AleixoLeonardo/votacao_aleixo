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
@Table(name = "log_alteracao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogAlteracao.findAll", query = "SELECT l FROM LogAlteracao l")
    , @NamedQuery(name = "LogAlteracao.findByIdLogAlteracao", query = "SELECT l FROM LogAlteracao l WHERE l.idLogAlteracao = :idLogAlteracao")
    , @NamedQuery(name = "LogAlteracao.findByDescricao", query = "SELECT l FROM LogAlteracao l WHERE l.descricao = :descricao")
    , @NamedQuery(name = "LogAlteracao.findByData", query = "SELECT l FROM LogAlteracao l WHERE l.data = :data")})
public class LogAlteracao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_log_alteracao")
    private Integer idLogAlteracao;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @JoinColumn(name = "tipo_alteracao", referencedColumnName = "id_tipo_alteracao")
    @ManyToOne
    private TipoAlteracao tipoAlteracao;
    @JoinColumn(name = "usuario_alteracao", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario usuarioAlteracao;

    public LogAlteracao() {
    }

    public LogAlteracao(Integer idLogAlteracao) {
        this.idLogAlteracao = idLogAlteracao;
    }

    public Integer getIdLogAlteracao() {
        return idLogAlteracao;
    }

    public void setIdLogAlteracao(Integer idLogAlteracao) {
        this.idLogAlteracao = idLogAlteracao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public TipoAlteracao getTipoAlteracao() {
        return tipoAlteracao;
    }

    public void setTipoAlteracao(TipoAlteracao tipoAlteracao) {
        this.tipoAlteracao = tipoAlteracao;
    }

    public Usuario getUsuarioAlteracao() {
        return usuarioAlteracao;
    }

    public void setUsuarioAlteracao(Usuario usuarioAlteracao) {
        this.usuarioAlteracao = usuarioAlteracao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLogAlteracao != null ? idLogAlteracao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogAlteracao)) {
            return false;
        }
        LogAlteracao other = (LogAlteracao) object;
        if ((this.idLogAlteracao == null && other.idLogAlteracao != null) || (this.idLogAlteracao != null && !this.idLogAlteracao.equals(other.idLogAlteracao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.votacao_aleixo.DTO.LogAlteracao[ idLogAlteracao=" + idLogAlteracao + " ]";
    }
    
}
