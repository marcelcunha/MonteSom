/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Marcel
 */
@Embeddable
public class GrupoVeiculoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "cod_grupo")
    private int codGrupo;
    @Basic(optional = false)
    @Column(name = "cod_veiculo")
    private int codVeiculo;

    public GrupoVeiculoPK() {
    }

    public GrupoVeiculoPK(int codGrupo, int codVeiculo) {
        this.codGrupo = codGrupo;
        this.codVeiculo = codVeiculo;
    }

    public int getCodGrupo() {
        return codGrupo;
    }

    public void setCodGrupo(int codGrupo) {
        this.codGrupo = codGrupo;
    }

    public int getCodVeiculo() {
        return codVeiculo;
    }

    public void setCodVeiculo(int codVeiculo) {
        this.codVeiculo = codVeiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codGrupo;
        hash += (int) codVeiculo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoVeiculoPK)) {
            return false;
        }
        GrupoVeiculoPK other = (GrupoVeiculoPK) object;
        if (this.codGrupo != other.codGrupo) {
            return false;
        }
        if (this.codVeiculo != other.codVeiculo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.entidades.GrupoVeiculoPK[ codGrupo=" + codGrupo + ", codVeiculo=" + codVeiculo + " ]";
    }
    
}
