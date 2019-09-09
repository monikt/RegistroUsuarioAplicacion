/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicacionUsuario.fuentes.Controlador;

import com.aplicacionUsuario.fuentes.Dao.UsuarioDao;
import com.aplicacionUsuario.fuentes.Entidades.UsuarioApplication;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;


/**
 *
 * @author usuario
 */
@Named(value = "login")
@SessionScoped
public class InicioSesionController implements Serializable {

    @EJB
    private UsuarioDao uef;
    private UsuarioApplication uec;
    private String correo;
    private String clave;

    @PostConstruct
    public void init() {

        uec = new UsuarioApplication();
    }

    public UsuarioDao getUef() {
        return uef;
    }

    public void setUef(UsuarioDao uef) {
        this.uef = uef;
    }

    public UsuarioApplication getUec() {
        return uec;
    }

    public void setUec(UsuarioApplication uec) {
        this.uec = uec;
    }
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String Correo) {
        this.correo = Correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String inicioSesion() {

        String redireccion = null;
        Boolean estarLogueado = false;
        FacesContext context = FacesContext.getCurrentInstance();
        uec = uef.iniciarSesion(correo, clave);
        if (uec != null) {
            // faces se utiliza con el fin de capturar el objecto que esta iniciando sesion 
            context.getExternalContext().getSessionMap().put("usuario", uec);
            estarLogueado = true;
            redireccion = "";
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "login", " y clave incorrectas"));
            estarLogueado = false;
            //redireccion="index?faces-redirect=true";
        }
        return redireccion;

    }

    public String nombreUser() {
        FacesContext context = FacesContext.getCurrentInstance();
        UsuarioApplication user = (UsuarioApplication) context.getExternalContext().getSessionMap().get("usuario");
        return "Bienvenido " + user.getNombre();

    }

    public void cerrarCesion() {

        String redirecion;
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();

    }
}
