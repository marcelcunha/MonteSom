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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    @NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g"),
    @NamedQuery(name = "Grupo.findByCodGrp", query = "SELECT g FROM Grupo g WHERE g.codGrp = :codGrp"),
    @NamedQuery(name = "Grupo.findByNomeGrp", query = "SELECT g FROM Grupo g WHERE g.nomeGrp = :nomeGrp")})
public class Grupo implements Serializable, IEntidades{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_grp")
    private Integer codGrp;
    @Basic(optional = false)
    @Column(name = "nome_grp")
    private String nomeGrp;
    @JoinTable(name = "pertence_grupo", joinColumns = {
        @JoinColumn(name = "cod_grp", referencedColumnName = "cod_grp")}, inverseJoinColumns = {
        @JoinColumn(name = "cod_vei", referencedColumnName = "cod_vei")})
    @ManyToMany
    private List<Veiculo> veiculoList;
    @OneToMany(mappedBy = "codGrp")
    private List<Produto> produtoList;

    public Grupo() {
    }

    public Grupo(Integer codGrp) {
        this.codGrp = codGrp;
    }

    public Grupo(Integer codGrp, String nomeGrp) {
        this.codGrp = codGrp;
        this.nomeGrp = nomeGrp;
    }

    public Integer getCodGrp() {
        return codGrp;
    }

    public void setCodGrp(Integer codGrp) {
        this.codGrp = codGrp;
    }

    public String getNomeGrp() {
        return nomeGrp;
    }

    public void setNomeGrp(String nomeGrp) {
        this.nomeGrp = nomeGrp;
    }

    @XmlTransient
    public List<Veiculo> getVeiculoList() {
        return veiculoList;
    }

    public void setVeiculoList(List<Veiculo> veiculoList) {
        this.veiculoList = veiculoList;
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
        hash += (codGrp != null ? codGrp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.codGrp == null && other.codGrp != null) || (this.codGrp != null && !this.codGrp.equals(other.codGrp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomeGrp;
    }
    
}
