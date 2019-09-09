/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicacionUsuario.fuentes.Entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc lenovo
 */
@Entity
@Table(name = "claveusuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Claveusuario.findAll", query = "SELECT c FROM Claveusuario c")
    , @NamedQuery(name = "Claveusuario.findBySecuenciaClave", query = "SELECT c FROM Claveusuario c WHERE c.secuenciaClave = :secuenciaClave")
    , @NamedQuery(name = "Claveusuario.findByClave", query = "SELECT c FROM Claveusuario c WHERE c.clave = :clave")})
public class Claveusuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "secuencia_clave")
    private Integer secuenciaClave;
    @Basic(optional = false)
    @NotNull
    @Size(max = 20)
    @Column(name = "clave")
    private String clave;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idClave")
    private UsuarioApplication usuarioApplication;

    public Claveusuario() {
    }

    public Claveusuario(Integer secuenciaClave) {
        this.secuenciaClave = secuenciaClave;
    }

    public Claveusuario(Integer secuenciaClave, String clave) {
        this.secuenciaClave = secuenciaClave;
        this.clave = clave;
    }

    public Integer getSecuenciaClave() {
        return secuenciaClave;
    }

    public void setSecuenciaClave(Integer secuenciaClave) {
        this.secuenciaClave = secuenciaClave;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @XmlTransient
    public UsuarioApplication getUsuarioApplication() {
        return usuarioApplication;
    }

    public void setUsuarioApplication(UsuarioApplication usuarioApplication) {
        this.usuarioApplication = usuarioApplication;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secuenciaClave != null ? secuenciaClave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Claveusuario)) {
            return false;
        }
        Claveusuario other = (Claveusuario) object;
        if ((this.secuenciaClave == null && other.secuenciaClave != null) || (this.secuenciaClave != null && !this.secuenciaClave.equals(other.secuenciaClave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aplicacionUsuario.fuentes.Entidades.Claveusuario[ secuenciaClave=" + secuenciaClave + " ]";
    }
    
}
