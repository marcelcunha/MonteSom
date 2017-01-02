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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcel
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fabricante.findAll", query = "SELECT f FROM Fabricante f"),
    @NamedQuery(name = "Fabricante.findByCodFab", query = "SELECT f FROM Fabricante f WHERE f.codFab = :codFab"),
    @NamedQuery(name = "Fabricante.findByNomeFab", query = "SELECT f FROM Fabricante f WHERE f.nomeFab = :nomeFab")})
public class Fabricante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_fab")
    private Integer codFab;
    @Basic(optional = false)
    @Column(name = "nome_fab")
    private String nomeFab;

    public Fabricante() {
    }

    public Fabricante(Integer codFab) {
        this.codFab = codFab;
    }

    public Fabricante(Integer codFab, String nomeFab) {
        this.codFab = codFab;
        this.nomeFab = nomeFab;
    }

    public Integer getCodFab() {
        return codFab;
    }

    public void setCodFab(Integer codFab) {
        this.codFab = codFab;
    }

    public String getNomeFab() {
        return nomeFab;
    }

    public void setNomeFab(String nomeFab) {
        this.nomeFab = nomeFab;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFab != null ? codFab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fabricante)) {
            return false;
        }
        Fabricante other = (Fabricante) object;
        if ((this.codFab == null && other.codFab != null) || (this.codFab != null && !this.codFab.equals(other.codFab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.entidades.Fabricante[ codFab=" + codFab + " ]";
    }
    
}
