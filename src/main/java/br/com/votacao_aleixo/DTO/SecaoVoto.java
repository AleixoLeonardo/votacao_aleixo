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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Leonardo
 */
@Entity
@Table(name = "secao_voto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SecaoVoto.findAll", query = "SELECT s FROM SecaoVoto s")
    , @NamedQuery(name = "SecaoVoto.findByIdSecaoVoto", query = "SELECT s FROM SecaoVoto s WHERE s.idSecaoVoto = :idSecaoVoto")
    , @NamedQuery(name = "SecaoVoto.findByStatus", query = "SELECT s FROM SecaoVoto s WHERE s.status = :status")})
public class SecaoVoto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_secao_voto")
    private Integer idSecaoVoto;
    @Column(name = "status")
    private Boolean status;
    @OneToMany(mappedBy = "secaoVoto")
    private List<Voto> votoList;
    @JoinColumn(name = "secao", referencedColumnName = "id_secao")
    @ManyToOne
    private Secao secao;
    @JoinColumn(name = "usuario_abertura", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario usuarioAbertura;

    public SecaoVoto() {
    }

    public SecaoVoto(Integer idSecaoVoto) {
        this.idSecaoVoto = idSecaoVoto;
    }

    public Integer getIdSecaoVoto() {
        return idSecaoVoto;
    }

    public void setIdSecaoVoto(Integer idSecaoVoto) {
        this.idSecaoVoto = idSecaoVoto;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @XmlTransient
    public List<Voto> getVotoList() {
        return votoList;
    }

    public void setVotoList(List<Voto> votoList) {
        this.votoList = votoList;
    }

    public Secao getSecao() {
        return secao;
    }

    public void setSecao(Secao secao) {
        this.secao = secao;
    }

    public Usuario getUsuarioAbertura() {
        return usuarioAbertura;
    }

    public void setUsuarioAbertura(Usuario usuarioAbertura) {
        this.usuarioAbertura = usuarioAbertura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSecaoVoto != null ? idSecaoVoto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SecaoVoto)) {
            return false;
        }
        SecaoVoto other = (SecaoVoto) object;
        if ((this.idSecaoVoto == null && other.idSecaoVoto != null) || (this.idSecaoVoto != null && !this.idSecaoVoto.equals(other.idSecaoVoto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.votacao_aleixo.DTO.SecaoVoto[ idSecaoVoto=" + idSecaoVoto + " ]";
    }
    
}
