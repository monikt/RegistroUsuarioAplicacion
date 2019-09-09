/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicacionUsuario.fuentes.Dao;

import com.aplicacionUsuario.fuentes.Entidades.UsuarioApplication;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author usuario
 */
@Stateless
public class UsuarioDao extends AbstractFacade<UsuarioApplication> {

    @PersistenceContext(unitName = "examenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioDao() {
        super(UsuarioApplication.class);
    }
  

    public UsuarioApplication iniciarSesion(String correo, String clave){
    
      //  SELECT u FROM UsuarioEntity u WHERE u.correo = :correo AND u.clave = :clave""
       UsuarioApplication user = null;
       Query q=em.createQuery("SELECT u FROM UsuarioApplication u WHERE u.correo = ?1 and u.idClave.clave = ?2");
       q.setParameter(1, correo);
       q.setParameter(2, clave);
       List<UsuarioApplication> usuarios = q.getResultList() ;
        if (usuarios != null ) {
          user = usuarios.get(0);
        }
        return user;
    }
     
   
    }
    
