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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Veiculo.findAll", query = "SELECT v FROM Veiculo v"),
    @NamedQuery(name = "Veiculo.findByCodVei", query = "SELECT v FROM Veiculo v WHERE v.codVei = :codVei"),
    @NamedQuery(name = "Veiculo.findByDescVei", query = "SELECT v FROM Veiculo v WHERE v.descVei = :descVei"),
    @NamedQuery(name = "Veiculo.findByQtdPortas", query = "SELECT v FROM Veiculo v WHERE v.qtdPortas = :qtdPortas")})
public class Veiculo implements Serializable, IEntidades {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_vei")
    private Integer codVei;
    @Column(name = "desc_vei")
    private String descVei;
    @Column(name = "qtd_portas")
    private Integer qtdPortas;
    @ManyToMany(mappedBy = "veiculoList")
    private List<Grupo> grupoList;
    @JoinColumn(name = "cod_mod", referencedColumnName = "cod")
    @ManyToOne
    private Modelo codMod;
    @OneToMany(mappedBy = "codVei")
    private List<Produto> produtoList;

    public Veiculo(String descVei, Integer qtdPortas, Modelo codMod) {
        this.descVei = descVei;
        this.qtdPortas = qtdPortas;
        this.codMod = codMod;
    }

    public Veiculo() {
    }

    public Veiculo(Integer codVei) {
        this.codVei = codVei;
    }

    public Integer getCodVei() {
        return codVei;
    }

    public void setCodVei(Integer codVei) {
        this.codVei = codVei;
    }

    public String getDescVei() {
        return descVei;
    }

    public void setDescVei(String descVei) {
        this.descVei = descVei;
    }

    public Integer getQtdPortas() {
        return qtdPortas;
    }

    public void setQtdPortas(Integer qtdPortas) {
        this.qtdPortas = qtdPortas;
    }

    @XmlTransient
    public List<Grupo> getGrupoList() {
        return grupoList;
    }

    public void setGrupoList(List<Grupo> grupoList) {
        this.grupoList = grupoList;
    }

    public Modelo getCodMod() {
        return codMod;
    }

    public void setCodMod(Modelo codMod) {
        this.codMod = codMod;
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
        hash += (codVei != null ? codVei.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Veiculo)) {
            return false;
        }
        Veiculo other = (Veiculo) object;
        if ((this.codVei == null && other.codVei != null) || (this.codVei != null && !this.codVei.equals(other.codVei))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descVei;
    }
    
}
