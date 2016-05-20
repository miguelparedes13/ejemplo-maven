package com.infoloxa.catequesis.logica.dao.Imp;


import com.infoloxa.catequesis.logica.dao.EstudianteDao;
import com.infoloxa.catequesis.logica.dao.GenericDao;
import com.infoloxa.catequesis.model.Estudiantes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class EstudianteDaoImpl extends GenericDao<Estudiantes, Long> implements EstudianteDao {

    public EstudianteDaoImpl() {
        super(Estudiantes.class);
    }


    @Override
    public List<Estudiantes> obtenerEstudiantesCedula(String cedula) {
        StringBuilder sqlFactory = new StringBuilder();
        sqlFactory.append(" select t from Estudiantes t where");
        sqlFactory.append(" t.cedula = ?1 ");
        Query query = em.createQuery(sqlFactory.toString());
        query.setParameter(1, cedula);
        return (List<Estudiantes>) query.getResultList();
    }    
}
