/*¿+
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicacionUsuario.fuentes.Controlador;

import com.aplicacionUsuario.fuentes.Dao.UsuarioDao;
import com.aplicacionUsuario.fuentes.Entidades.Claveusuario;
import com.aplicacionUsuario.fuentes.Entidades.UsuarioApplication;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import javax.faces.application.FacesMessage;

import javax.faces.component.UIComponent;

import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.view.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author usuario
 */
@Named(value = "usuarioControlador")
@ViewScoped

//  @PostConstruct() cuando se necesiten una listas al principio
public class UsuarioController implements Serializable {

    @EJB // inicializar el objecto PARTE DEL MODDELO 
    private UsuarioDao usuarioDao;
    private UsuarioApplication usuario;
    private Claveusuario clave;
    private String nombre, numeroId, tipoId, correo;
    private int estado;

    @PostConstruct
    public void init() {
        usuario = new UsuarioApplication();
        clave = new Claveusuario();
    }

    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public UsuarioApplication getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioApplication usuario) {
        this.usuario = usuario;
    }

    public Claveusuario getClave() {
        return clave;
    }

    public void setClave(Claveusuario clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroId() {
        return numeroId;
    }

    public void setNumeroId(String numeroId) {
        this.numeroId = numeroId;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String registrarUsuario() {
        String url = "";
        try {
            usuario.setFechaModificacion(new Date());
            usuarioDao.create(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "el Usuario se ha creado correctamente"));
            url = "registroUsuarios?faces-redirect=true";

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "En el momento no se pudo procesar su solicitud"));
            url = "registroUsuarios?faces-redirect=true";
        }
        return url;
    }

    public List<UsuarioApplication> listarUsuarios() {

        FacesContext context = FacesContext.getCurrentInstance();
        return usuarioDao.findAll();

    }

    public void DeleteUsuario(UsuarioApplication usuario) {

        try {

            usuarioDao.remove(usuario);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Eliminacion", "existe el error " + e));
        }
    }

    public void cambiarUsuario() {

        if (usuario == null) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "existe el error objecto vacio"));
        } else {
            try {
                usuario.setNombre(nombre);
                usuario.setTipoDocumento(tipoId);
                usuario.setNumeroDocumento(numeroId);
                usuario.setCorreo(correo);
                usuario.setEstado(estado);
                usuario.setFechaModificacion(new Date());

                usuarioDao.edit(usuario);

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Confirmation", "Se ha modificado el usuario"));
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "" + e));

            }
        }
    }

}