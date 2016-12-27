/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.entidades;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcel
 */
@Entity
@Table(name = "modelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modelo.findAll", query = "SELECT m FROM Modelo m"),
    @NamedQuery(name = "Modelo.findByCodModelo", query = "SELECT m FROM Modelo m WHERE m.codModelo = :codModelo"),
    @NamedQuery(name = "Modelo.findByModeloModelo", query = "SELECT m FROM Modelo m WHERE m.modeloModelo = :modeloModelo"),
    @NamedQuery(name = "Modelo.findByDescricacaoModelo", query = "SELECT m FROM Modelo m WHERE m.descricacaoModelo = :descricacaoModelo"),
    @NamedQuery(name = "Modelo.findByPortasModelo", query = "SELECT m FROM Modelo m WHERE m.portasModelo = :portasModelo")})
public class Modelo implements Serializable, IEntidades {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_modelo")
    private Integer codModelo;
    @Basic(optional = false)
    @Column(name = "modelo_modelo")
    private String modeloModelo;
    @Column(name = "descricacao_modelo")
    private String descricacaoModelo;
    @Basic(optional = false)
    @Column(name = "portas_modelo")
    private short portasModelo;
    @JoinColumn(name = "cod_veiculo", referencedColumnName = "cod")
    @ManyToOne(optional = false)
    private Veiculo codVeiculo;

    public Modelo() {
    }

    public Modelo(Integer codModelo) {
        this.codModelo = codModelo;
    }

    public Modelo(Integer codModelo, String modeloModelo, short portasModelo) {
        this.codModelo = codModelo;
        this.modeloModelo = modeloModelo;
        this.portasModelo = portasModelo;
    }

    public Integer getCodModelo() {
        return codModelo;
    }

    public void setCodModelo(Integer codModelo) {
        this.codModelo = codModelo;
    }

    public String getModeloModelo() {
        return modeloModelo;
    }

    public void setModeloModelo(String modeloModelo) {
        this.modeloModelo = modeloModelo;
    }

    public String getDescricacaoModelo() {
        return descricacaoModelo;
    }

    public void setDescricacaoModelo(String descricacaoModelo) {
        this.descricacaoModelo = descricacaoModelo;
    }

    public short getPortasModelo() {
        return portasModelo;
    }

    public void setPortasModelo(short portasModelo) {
        this.portasModelo = portasModelo;
    }

    public Veiculo getCodVeiculo() {
        return codVeiculo;
    }

    public void setCodVeiculo(Veiculo codVeiculo) {
        this.codVeiculo = codVeiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codModelo != null ? codModelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modelo)) {
            return false;
        }
        Modelo other = (Modelo) object;
        if ((this.codModelo == null && other.codModelo != null) || (this.codModelo != null && !this.codModelo.equals(other.codModelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.entidades.Modelo[ codModelo=" + codModelo + " ]";
    }
    
}
