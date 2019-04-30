/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.votacao_aleixo.DTO;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aluno
 */
@Entity
@Table(name = "tipo_alteracao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAlteracao.findAll", query = "SELECT t FROM TipoAlteracao t")
    , @NamedQuery(name = "TipoAlteracao.findByIdTipoAlteracao", query = "SELECT t FROM TipoAlteracao t WHERE t.idTipoAlteracao = :idTipoAlteracao")
    , @NamedQuery(name = "TipoAlteracao.findByNome", query = "SELECT t FROM TipoAlteracao t WHERE t.nome = :nome")})
public class TipoAlteracao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_alteracao")
    private Integer idTipoAlteracao;
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "tipoAlteracao")
    private List<LogAlteracao> logAlteracaoList;

    public TipoAlteracao() {
    }

    public TipoAlteracao(Integer idTipoAlteracao) {
        this.idTipoAlteracao = idTipoAlteracao;
    }

    public Integer getIdTipoAlteracao() {
        return idTipoAlteracao;
    }

    public void setIdTipoAlteracao(Integer idTipoAlteracao) {
        this.idTipoAlteracao = idTipoAlteracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<LogAlteracao> getLogAlteracaoList() {
        return logAlteracaoList;
    }

    public void setLogAlteracaoList(List<LogAlteracao> logAlteracaoList) {
        this.logAlteracaoList = logAlteracaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoAlteracao != null ? idTipoAlteracao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAlteracao)) {
            return false;
        }
        TipoAlteracao other = (TipoAlteracao) object;
        if ((this.idTipoAlteracao == null && other.idTipoAlteracao != null) || (this.idTipoAlteracao != null && !this.idTipoAlteracao.equals(other.idTipoAlteracao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.votacao_aleixo.DTO.TipoAlteracao[ idTipoAlteracao=" + idTipoAlteracao + " ]";
    }
    
}
