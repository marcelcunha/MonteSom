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
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByCodPro", query = "SELECT p FROM Produto p WHERE p.codPro = :codPro"),
    @NamedQuery(name = "Produto.findByNomePro", query = "SELECT p FROM Produto p WHERE p.nomePro = :nomePro"),
    @NamedQuery(name = "Produto.findByDescPro", query = "SELECT p FROM Produto p WHERE p.descPro = :descPro")})
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_pro")
    private Integer codPro;
    @Basic(optional = false)
    @Column(name = "nome_pro")
    private String nomePro;
    @Column(name = "desc_pro")
    private String descPro;
    @OneToMany(mappedBy = "codPro")
    private List<Estoque> estoqueList;
    @JoinColumn(name = "cod_cat", referencedColumnName = "cod_cat")
    @ManyToOne
    private Categoria codCat;
    @JoinColumn(name = "cod_grp", referencedColumnName = "cod_grp")
    @ManyToOne
    private Grupo codGrp;
    @JoinColumn(name = "cod_vei", referencedColumnName = "cod_vei")
    @ManyToOne
    private Veiculo codVei;

    public Produto() {
    }

    public Produto(Integer codPro) {
        this.codPro = codPro;
    }

    public Produto(Integer codPro, String nomePro) {
        this.codPro = codPro;
        this.nomePro = nomePro;
    }

    public Integer getCodPro() {
        return codPro;
    }

    public void setCodPro(Integer codPro) {
        this.codPro = codPro;
    }

    public String getNomePro() {
        return nomePro;
    }

    public void setNomePro(String nomePro) {
        this.nomePro = nomePro;
    }

    public String getDescPro() {
        return descPro;
    }

    public void setDescPro(String descPro) {
        this.descPro = descPro;
    }

    @XmlTransient
    public List<Estoque> getEstoqueList() {
        return estoqueList;
    }

    public void setEstoqueList(List<Estoque> estoqueList) {
        this.estoqueList = estoqueList;
    }

    public Categoria getCodCat() {
        return codCat;
    }

    public void setCodCat(Categoria codCat) {
        this.codCat = codCat;
    }

    public Grupo getCodGrp() {
        return codGrp;
    }

    public void setCodGrp(Grupo codGrp) {
        this.codGrp = codGrp;
    }

    public Veiculo getCodVei() {
        return codVei;
    }

    public void setCodVei(Veiculo codVei) {
        this.codVei = codVei;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPro != null ? codPro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.codPro == null && other.codPro != null) || (this.codPro != null && !this.codPro.equals(other.codPro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.entidades.Produto[ codPro=" + codPro + " ]";
    }
    
}
