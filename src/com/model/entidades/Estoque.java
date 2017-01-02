/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcel
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estoque.findAll", query = "SELECT e FROM Estoque e"),
    @NamedQuery(name = "Estoque.findByCodEst", query = "SELECT e FROM Estoque e WHERE e.codEst = :codEst"),
    @NamedQuery(name = "Estoque.findByPrVenda", query = "SELECT e FROM Estoque e WHERE e.prVenda = :prVenda"),
    @NamedQuery(name = "Estoque.findByPrCusto", query = "SELECT e FROM Estoque e WHERE e.prCusto = :prCusto"),
    @NamedQuery(name = "Estoque.findByValidade", query = "SELECT e FROM Estoque e WHERE e.validade = :validade"),
    @NamedQuery(name = "Estoque.findByQtdEstoque", query = "SELECT e FROM Estoque e WHERE e.qtdEstoque = :qtdEstoque")})
public class Estoque implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_est")
    private Integer codEst;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pr_venda")
    private BigDecimal prVenda;
    @Column(name = "pr_custo")
    private BigDecimal prCusto;
    @Temporal(TemporalType.DATE)
    private Date validade;
    @Basic(optional = false)
    @Column(name = "qtd_estoque")
    private int qtdEstoque;
    @JoinColumn(name = "cod_prat", referencedColumnName = "cod_prat")
    @ManyToOne
    private Prateleira codPrat;
    @JoinColumn(name = "cod_pro", referencedColumnName = "cod_pro")
    @ManyToOne
    private Produto codPro;

    public Estoque() {
    }

    public Estoque(Integer codEst) {
        this.codEst = codEst;
    }

    public Estoque(Integer codEst, int qtdEstoque) {
        this.codEst = codEst;
        this.qtdEstoque = qtdEstoque;
    }

    public Integer getCodEst() {
        return codEst;
    }

    public void setCodEst(Integer codEst) {
        this.codEst = codEst;
    }

    public BigDecimal getPrVenda() {
        return prVenda;
    }

    public void setPrVenda(BigDecimal prVenda) {
        this.prVenda = prVenda;
    }

    public BigDecimal getPrCusto() {
        return prCusto;
    }

    public void setPrCusto(BigDecimal prCusto) {
        this.prCusto = prCusto;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Prateleira getCodPrat() {
        return codPrat;
    }

    public void setCodPrat(Prateleira codPrat) {
        this.codPrat = codPrat;
    }

    public Produto getCodPro() {
        return codPro;
    }

    public void setCodPro(Produto codPro) {
        this.codPro = codPro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEst != null ? codEst.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estoque)) {
            return false;
        }
        Estoque other = (Estoque) object;
        if ((this.codEst == null && other.codEst != null) || (this.codEst != null && !this.codEst.equals(other.codEst))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.entidades.Estoque[ codEst=" + codEst + " ]";
    }
    
}
