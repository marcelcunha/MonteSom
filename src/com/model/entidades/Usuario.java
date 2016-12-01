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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcel
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByCodUsr", query = "SELECT u FROM Usuario u WHERE u.codUsr = :codUsr"),
    @NamedQuery(name = "Usuario.findByUserUsr", query = "SELECT u FROM Usuario u WHERE u.userUsr = :userUsr"),
    @NamedQuery(name = "Usuario.findBySenhaUsr", query = "SELECT u FROM Usuario u WHERE u.senhaUsr = :senhaUsr"),
    @NamedQuery(name = "Usuario.findByNomeUsr", query = "SELECT u FROM Usuario u WHERE u.nomeUsr = :nomeUsr"),
    @NamedQuery(name = "Usuario.findBySuperUsr", query = "SELECT u FROM Usuario u WHERE u.superUsr = :superUsr"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
    @NamedQuery(name = "Usuario.findByTelefone", query = "SELECT u FROM Usuario u WHERE u.telefone = :telefone")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_usr")
    private Integer codUsr;
    @Basic(optional = false)
    @Column(name = "user__usr")
    private String userUsr;
    @Basic(optional = false)
    @Column(name = "senha_usr")
    private String senhaUsr;
    @Basic(optional = false)
    @Column(name = "nome_usr")
    private String nomeUsr;
    @Basic(optional = false)
    @Column(name = "super_usr")
    private boolean superUsr;
    @Column(name = "email")
    private String email;
    @Column(name = "telefone")
    private Long telefone;

    public Usuario() {
    }

    public Usuario(Integer codUsr) {
        this.codUsr = codUsr;
    }

    public Usuario(String userUsr, String senhaUsr, String nomeUsr, boolean superUsr, String email, Long telefone) {
        this.userUsr = userUsr;
        this.senhaUsr = senhaUsr;
        this.nomeUsr = nomeUsr;
        this.superUsr = superUsr;
        this.email = email;
        this.telefone = telefone;
    }

    public Integer getCodUsr() {
        return codUsr;
    }

    public void setCodUsr(Integer codUsr) {
        this.codUsr = codUsr;
    }

    public String getUserUsr() {
        return userUsr;
    }

    public void setUserUsr(String userUsr) {
        this.userUsr = userUsr;
    }

    public String getSenhaUsr() {
        return senhaUsr;
    }

    public void setSenhaUsr(String senhaUsr) {
        this.senhaUsr = senhaUsr;
    }

    public String getNomeUsr() {
        return nomeUsr;
    }

    public void setNomeUsr(String nomeUsr) {
        this.nomeUsr = nomeUsr;
    }

    public boolean getSuperUsr() {
        return superUsr;
    }

    public void setSuperUsr(boolean superUsr) {
        this.superUsr = superUsr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUsr != null ? codUsr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codUsr == null && other.codUsr != null) || (this.codUsr != null && !this.codUsr.equals(other.codUsr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.endidades.Usuario[ codUsr=" + codUsr + " ]";
    }
    
}
