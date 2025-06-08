package com.infoloxa.catequesis.logica.dao.Imp;

import com.infoloxa.catequesis.logica.dao.GenericDao;
import com.infoloxa.catequesis.logica.dao.UsuarioDao;
import com.infoloxa.catequesis.model.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class UsuarioDaoImpl extends GenericDao<Usuarios, Long> implements UsuarioDao {

    public UsuarioDaoImpl() {
        super(Usuarios.class);
    }

    @Override
    public List<Usuarios> buscarUsuario(String usuario, String clave) {
        StringBuilder sql = new StringBuilder();
        sql.append("select u from Usuarios u where u.usuario = ?1 and u.clave = ?2");
        Query query = em.createQuery(sql.toString());
        query.setParameter(1, usuario);
        query.setParameter(2, clave);
        return (List<Usuarios>) query.getResultList();
    }
}
