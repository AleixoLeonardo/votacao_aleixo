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
 * @author Leonardo
 */
@Entity
@Table(name = "secao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Secao.findAll", query = "SELECT s FROM Secao s")
    , @NamedQuery(name = "Secao.findByIdSecao", query = "SELECT s FROM Secao s WHERE s.idSecao = :idSecao")
    , @NamedQuery(name = "Secao.findByNome", query = "SELECT s FROM Secao s WHERE s.nome = :nome")})
public class Secao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_secao")
    private Integer idSecao;
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "secao")
    private List<Zona> zonaList;
    @OneToMany(mappedBy = "secao")
    private List<SecaoVoto> secaoVotoList;

    public Secao() {
    }

    public Secao(Integer idSecao) {
        this.idSecao = idSecao;
    }

    public Integer getIdSecao() {
        return idSecao;
    }

    public void setIdSecao(Integer idSecao) {
        this.idSecao = idSecao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Zona> getZonaList() {
        return zonaList;
    }

    public void setZonaList(List<Zona> zonaList) {
        this.zonaList = zonaList;
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
        hash += (idSecao != null ? idSecao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Secao)) {
            return false;
        }
        Secao other = (Secao) object;
        if ((this.idSecao == null && other.idSecao != null) || (this.idSecao != null && !this.idSecao.equals(other.idSecao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.votacao_aleixo.DTO.Secao[ idSecao=" + idSecao + " ]";
    }
    
}
