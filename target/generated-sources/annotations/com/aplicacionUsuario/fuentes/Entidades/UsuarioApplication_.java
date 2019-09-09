package com.aplicacionUsuario.fuentes.Entidades;

import com.aplicacionUsuario.fuentes.Entidades.Claveusuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-09T00:02:12")
@StaticMetamodel(UsuarioApplication.class)
public class UsuarioApplication_ { 

    public static volatile SingularAttribute<UsuarioApplication, Integer> secuenciaUsuario;
    public static volatile SingularAttribute<UsuarioApplication, String> tipoDocumento;
    public static volatile SingularAttribute<UsuarioApplication, Integer> estado;
    public static volatile SingularAttribute<UsuarioApplication, Date> fechaModificacion;
    public static volatile SingularAttribute<UsuarioApplication, String> correo;
    public static volatile SingularAttribute<UsuarioApplication, Claveusuario> idClave;
    public static volatile SingularAttribute<UsuarioApplication, String> numeroDocumento;
    public static volatile SingularAttribute<UsuarioApplication, String> nombre;

}