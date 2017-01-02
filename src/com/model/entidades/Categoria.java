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
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c"),
    @NamedQuery(name = "Categoria.findByCodCat", query = "SELECT c FROM Categoria c WHERE c.codCat = :codCat"),
    @NamedQuery(name = "Categoria.findByNomeCat", query = "SELECT c FROM Categoria c WHERE c.nomeCat = :nomeCat")})
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_cat")
    private Integer codCat;
    @Basic(optional = false)
    @Column(name = "nome_cat")
    private String nomeCat;
    @OneToMany(mappedBy = "codCat")
    private List<Produto> produtoList;

    public Categoria() {
    }

    public Categoria(Integer codCat) {
        this.codCat = codCat;
    }

    public Categoria(Integer codCat, String nomeCat) {
        this.codCat = codCat;
        this.nomeCat = nomeCat;
    }

    public Integer getCodCat() {
        return codCat;
    }

    public void setCodCat(Integer codCat) {
        this.codCat = codCat;
    }

    public String getNomeCat() {
        return nomeCat;
    }

    public void setNomeCat(String nomeCat) {
        this.nomeCat = nomeCat;
    }

    @XmlTransient
    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCat != null ? codCat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.codCat == null && other.codCat != null) || (this.codCat != null && !this.codCat.equals(other.codCat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.entidades.Categoria[ codCat=" + codCat + " ]";
    }
    
}
