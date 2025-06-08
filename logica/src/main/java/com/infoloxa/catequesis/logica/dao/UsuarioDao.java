package com.infoloxa.catequesis.logica.dao;

import com.infoloxa.catequesis.model.Usuarios;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UsuarioDao extends IGenericDao<Usuarios, Long> {
    List<Usuarios> buscarUsuario(String usuario, String clave);
}
