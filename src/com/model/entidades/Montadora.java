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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcel
 */
@Entity
@Table(name = "montadora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Montadora.findAll", query = "SELECT m FROM Montadora m"),
    @NamedQuery(name = "Montadora.findByCodMarca", query = "SELECT m FROM Montadora m WHERE m.codMarca = :codMarca"),
    @NamedQuery(name = "Montadora.findByNomeMarca", query = "SELECT m FROM Montadora m WHERE m.nomeMarca = :nomeMarca")})
public class Montadora implements Serializable, IEntidades {
    @OneToMany(mappedBy = "codMarca")
    private List<Veiculo> veiculoList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_marca")
    private Integer codMarca;
    @Basic(optional = false)
    @Column(name = "nome_marca")
    private String nomeMarca;

    public Montadora() {
    }

    public Montadora(Integer codMarca) {
        this.codMarca = codMarca;
    }

    public Montadora(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }

    public Integer getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(Integer codMarca) {
        this.codMarca = codMarca;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMarca != null ? codMarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Montadora)) {
            return false;
        }
        Montadora other = (Montadora) object;
        if ((this.codMarca == null && other.codMarca != null) || (this.codMarca != null && !this.codMarca.equals(other.codMarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomeMarca;
    }

    @XmlTransient
    public List<Veiculo> getVeiculoList() {
        return veiculoList;
    }

    public void setVeiculoList(List<Veiculo> veiculoList) {
        this.veiculoList = veiculoList;
    }
    
}
