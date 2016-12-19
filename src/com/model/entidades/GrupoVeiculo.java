/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "grupo_veiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoVeiculo.findAll", query = "SELECT g FROM GrupoVeiculo g"),
    @NamedQuery(name = "GrupoVeiculo.findByCodGrupo", query = "SELECT g FROM GrupoVeiculo g WHERE g.grupoVeiculoPK.codGrupo = :codGrupo"),
    @NamedQuery(name = "GrupoVeiculo.findByCodVeiculo", query = "SELECT g FROM GrupoVeiculo g WHERE g.grupoVeiculoPK.codVeiculo = :codVeiculo"),
    @NamedQuery(name = "GrupoVeiculo.findByNomeGrupo", query = "SELECT g FROM GrupoVeiculo g WHERE g.nomeGrupo = :nomeGrupo")})
public class GrupoVeiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GrupoVeiculoPK grupoVeiculoPK;
    @Column(name = "nome_grupo")
    private String nomeGrupo;
    @JoinColumn(name = "cod_veiculo", referencedColumnName = "cod", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Veiculo veiculo;

    public GrupoVeiculo() {
    }

    public GrupoVeiculo(GrupoVeiculoPK grupoVeiculoPK) {
        this.grupoVeiculoPK = grupoVeiculoPK;
    }

    public GrupoVeiculo(int codGrupo, int codVeiculo) {
        this.grupoVeiculoPK = new GrupoVeiculoPK(codGrupo, codVeiculo);
    }

    public GrupoVeiculoPK getGrupoVeiculoPK() {
        return grupoVeiculoPK;
    }

    public void setGrupoVeiculoPK(GrupoVeiculoPK grupoVeiculoPK) {
        this.grupoVeiculoPK = grupoVeiculoPK;
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grupoVeiculoPK != null ? grupoVeiculoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoVeiculo)) {
            return false;
        }
        GrupoVeiculo other = (GrupoVeiculo) object;
        if ((this.grupoVeiculoPK == null && other.grupoVeiculoPK != null) || (this.grupoVeiculoPK != null && !this.grupoVeiculoPK.equals(other.grupoVeiculoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomeGrupo;
    }
    
}
