package com.infoloxa.catequesis.logica.dao.Imp;


import com.infoloxa.catequesis.logica.dao.GenericDao;
import com.infoloxa.catequesis.logica.dao.SacramentoDao;
import com.infoloxa.catequesis.model.Sacramentos;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SacramentoDaoImpl extends GenericDao<Sacramentos, Long> implements SacramentoDao {

    public SacramentoDaoImpl() {
        super(Sacramentos.class);
    }


//    @Override
//    public List<TcomSecuencia> getSecuencia(Long idcomprobate, String puntoEmision ) {
//        StringBuilder sqlFactory = new StringBuilder();
//        sqlFactory.append(" select t from TcomSecuencia t where");
//        sqlFactory.append(" t.comId.comId = ?1  and t.secPuntoEmision =?2");
//        Query query = em.createQuery(sqlFactory.toString());
//        query.setParameter(1, idcomprobate);
//        query.setParameter(2, puntoEmision);
//        return (List<TcomSecuencia>) query.getResultList();
//    }    
}
