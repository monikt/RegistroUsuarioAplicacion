/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicacionUsuario.fuentes.Entidades;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc lenovo
 */
@Entity
@Table(name = "usuario_application")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioApplication.findAll", query = "SELECT u FROM UsuarioApplication u")
    , @NamedQuery(name = "UsuarioApplication.findBySecuenciaUsuario", query = "SELECT u FROM UsuarioApplication u WHERE u.secuenciaUsuario = :secuenciaUsuario")
    , @NamedQuery(name = "UsuarioApplication.findByNumeroDocumento", query = "SELECT u FROM UsuarioApplication u WHERE u.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "UsuarioApplication.findByTipoDocumento", query = "SELECT u FROM UsuarioApplication u WHERE u.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "UsuarioApplication.findByNombre", query = "SELECT u FROM UsuarioApplication u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "UsuarioApplication.findByCorreo", query = "SELECT u FROM UsuarioApplication u WHERE u.correo = :correo")
    , @NamedQuery(name = "UsuarioApplication.findByFechaModificacion", query = "SELECT u FROM UsuarioApplication u WHERE u.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "UsuarioApplication.findByEstado", query = "SELECT u FROM UsuarioApplication u WHERE u.estado = :estado")})
public class UsuarioApplication implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "secuencia_usuario")
    private Integer secuenciaUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(max = 60)
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(max = 200)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(max = 200)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @JoinColumn(name = "id_clave", referencedColumnName = "secuencia_clave")
    @OneToOne(optional = false)
    private Claveusuario idClave;

    public UsuarioApplication() {
    }

    public UsuarioApplication(Integer secuenciaUsuario) {
        this.secuenciaUsuario = secuenciaUsuario;
    }

    public UsuarioApplication(Integer secuenciaUsuario, String numeroDocumento, String tipoDocumento, String nombre, String correo, Date fechaModificacion, int estado) {
        this.secuenciaUsuario = secuenciaUsuario;
        this.numeroDocumento = numeroDocumento;
        this.tipoDocumento = tipoDocumento;
        this.nombre = nombre;
        this.correo = correo;
        this.fechaModificacion = fechaModificacion;
        this.estado = estado;
    }

    public Integer getSecuenciaUsuario() {
        return secuenciaUsuario;
    }

    public void setSecuenciaUsuario(Integer secuenciaUsuario) {
        this.secuenciaUsuario = secuenciaUsuario;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Claveusuario getIdClave() {
        return idClave;
    }

    public void setIdClave(Claveusuario idClave) {
        this.idClave = idClave;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secuenciaUsuario != null ? secuenciaUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioApplication)) {
            return false;
        }
        UsuarioApplication other = (UsuarioApplication) object;
        if ((this.secuenciaUsuario == null && other.secuenciaUsuario != null) || (this.secuenciaUsuario != null && !this.secuenciaUsuario.equals(other.secuenciaUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aplicacionUsuario.fuentes.Entidades.UsuarioApplication[ secuenciaUsuario=" + secuenciaUsuario + " ]";
    }
    
}
