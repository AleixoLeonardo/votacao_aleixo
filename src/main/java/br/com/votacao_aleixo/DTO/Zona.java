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
 * @author Aluno
 */
@Entity
@Table(name = "zona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zona.findAll", query = "SELECT z FROM Zona z")
    , @NamedQuery(name = "Zona.findByIdZona", query = "SELECT z FROM Zona z WHERE z.idZona = :idZona")
    , @NamedQuery(name = "Zona.findByNome", query = "SELECT z FROM Zona z WHERE z.nome = :nome")})
public class Zona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_zona")
    private Integer idZona;
    @Column(name = "nome")
    private String nome;
    @JoinColumn(name = "secao", referencedColumnName = "id_secao")
    @ManyToOne
    private Secao secao;
    @OneToMany(mappedBy = "zona")
    private List<Usuario> usuarioList;

    public Zona() {
    }

    public Zona(Integer idZona) {
        this.idZona = idZona;
    }

    public Integer getIdZona() {
        return idZona;
    }

    public void setIdZona(Integer idZona) {
        this.idZona = idZona;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Secao getSecao() {
        return secao;
    }

    public void setSecao(Secao secao) {
        this.secao = secao;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZona != null ? idZona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zona)) {
            return false;
        }
        Zona other = (Zona) object;
        if ((this.idZona == null && other.idZona != null) || (this.idZona != null && !this.idZona.equals(other.idZona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.votacao_aleixo.DTO.Zona[ idZona=" + idZona + " ]";
    }
    
}
