/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.entidades;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcel
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prateleira.findAll", query = "SELECT p FROM Prateleira p"),
    @NamedQuery(name = "Prateleira.findByCodPrat", query = "SELECT p FROM Prateleira p WHERE p.codPrat = :codPrat"),
    @NamedQuery(name = "Prateleira.findByNomePrat", query = "SELECT p FROM Prateleira p WHERE p.nomePrat = :nomePrat")})
public class Prateleira implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_prat")
    private Integer codPrat;
    @Basic(optional = false)
    @Column(name = "nome_prat")
    private String nomePrat;
    @OneToMany(mappedBy = "codPrat")
    private List<Estoque> estoqueList;

    public Prateleira() {
    }

    public Prateleira(Integer codPrat) {
        this.codPrat = codPrat;
    }

    public Prateleira(Integer codPrat, String nomePrat) {
        this.codPrat = codPrat;
        this.nomePrat = nomePrat;
    }

    public Integer getCodPrat() {
        return codPrat;
    }

    public void setCodPrat(Integer codPrat) {
        this.codPrat = codPrat;
    }

    public String getNomePrat() {
        return nomePrat;
    }

    public void setNomePrat(String nomePrat) {
        this.nomePrat = nomePrat;
    }

    @XmlTransient
    public List<Estoque> getEstoqueList() {
        return estoqueList;
    }

    public void setEstoqueList(List<Estoque> estoqueList) {
        this.estoqueList = estoqueList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPrat != null ? codPrat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prateleira)) {
            return false;
        }
        Prateleira other = (Prateleira) object;
        if ((this.codPrat == null && other.codPrat != null) || (this.codPrat != null && !this.codPrat.equals(other.codPrat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.entidades.Prateleira[ codPrat=" + codPrat + " ]";
    }
    
}
