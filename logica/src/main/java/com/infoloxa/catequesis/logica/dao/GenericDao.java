/*
 * GenericDao.java
 * 
 * Copyright (c) 2011 Fernando.
 * Todos los derechos reservados.
 */
package com.infoloxa.catequesis.logica.dao;




import com.infoloxa.catequesis.excepciones.EntidadNoBorradaException;
import com.infoloxa.catequesis.excepciones.EntidadNoEncontradaException;
import com.infoloxa.catequesis.excepciones.EntidadNoGrabadaException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

// this one is important!!!
/**
 * Class GenericDao.
 *
 * @param <T> the generic type
 * @param <PK> the generic id type
 * @revision $Revision: 1.1 $$
 */
@SuppressWarnings("unchecked")

public class GenericDao<T, PK extends Serializable> implements IGenericDao<T, PK> {

    @PersistenceContext(unitName = "catequesisDS")
    protected EntityManager em;

    private final Class<T> type;

    /**
     * Instancia un nuevo generic dao.
     *
     * @param type the type
     */
    public GenericDao(final Class<T> type) {
        this.type = type;
    }

    /**
     * @see ec.com.samasat.dao.IGenericDao#crear(java.lang.Object)
     */
    @Override
    public void crear(final T o) throws EntidadNoGrabadaException {
        try {

            em.persist(o);
        } catch (final PersistenceException e) {

            throw new EntidadNoGrabadaException("Error al grabar: ".concat(o.toString()), e);
        }
    }

    /**
     * @throws com.infoloxa.catequesis.excepciones.EntidadNoEncontradaException
     * @see ec.com.samasat.dao.IGenericDao#recuperar(java.io.Serializable)
     */
    @Override
    public T recuperar(final PK id) throws EntidadNoEncontradaException {

        final T entidad = em.find(type, id);

        if (entidad == null) {
            final StringBuffer msg = new StringBuffer();
            msg.append(type.getSimpleName());
            msg.append('[');
            msg.append(id.toString());
            msg.append("] no encontrada.");
            throw new EntidadNoEncontradaException(msg.toString());
        }

        return entidad;
    }

    /**
     * @see ec.com.samasat.dao.IGenericDao#actualizar(java.lang.Object)
     */
    @Override
    public void actualizar(final T o) throws EntidadNoGrabadaException {
        try {

            em.merge(o);

        } catch (final PersistenceException e) {

            throw new EntidadNoGrabadaException("Error al grabar: ".concat(o.toString()), e);
        }
    }

    /**
     * @see ec.com.samasat.dao.IGenericDao#eliminar(java.lang.Object)
     */
    @Override
    public void eliminar(final T o) throws EntidadNoBorradaException {
        em.merge(o);
        em.remove(o);
    }

    /**
     *
     * @return
     */
    @Override
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(type));
        return em.createQuery(cq).getResultList();
    }

    /**
     *
     * @param range
     * @return
     */
    @Override
    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(type));
        javax.persistence.Query q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    /**
     * @see ec.com.samasat.dao.IGenericDao#contar()
     */
    @Override
    public Long contar() {
        final String tableName = type.getSimpleName();
        final Query query = em.createQuery("select count(*) from " + tableName);
        return (Long) query.getSingleResult();
    }

    /**
     * @param id
     * @see ec.com.samasat.dao.IGenericDao#encontrarPagina(java.lang.Integer,
     * java.lang.Integer)
     */
    @Override
    public List<T> encontrarPagina(final Integer firstRow, final Integer maxResults, final String id) {
        final String className = type.getSimpleName();
        final StringBuffer sql = new StringBuffer();
        sql.append("from ").append(className);
        sql.append(" order by ").append(id);
        System.out.println(sql.toString());
        final Query query = em.createQuery(sql.toString());
        query.setFirstResult(firstRow);
        query.setMaxResults(maxResults);
        return query.getResultList();
    }

    /**
     *
     * @return
     */
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(type);
        cq.select(em.getCriteriaBuilder().count(rt));
        javax.persistence.Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    /**
     * @see ec.com.samasat.dao.IGenericDao#encontrarPorQuery(java.lang.String,
     * java.util.Map)
     */
    @Override
    public List<T> encontrarPorQuery(final String sql, final Map<String, Object> parametros) {
        final Query query = em.createQuery(sql);
        final Iterator<String> claves = parametros.keySet().iterator();
        while (claves.hasNext()) {
            final String clave = claves.next();
            query.setParameter(clave, parametros.get(clave));
        }
        return query.getResultList();
    }

    /**
     * @see ec.com.samasat.dao.IGenericDao#refrescar(java.lang.Object)
     */
    @Override
    public void refrescar(final T o) {
        em.refresh(o);
    }

    /**
     * @param statement
     * @param parameters
     * @return
     * @see ec.com.samasat.dao.IGenericDao#selectNativeQuery(java.lang.String,
     * java.lang.Object[])
     */
    public List<T> selectNativeQuery(final String statement, final Object[] parameters) {
        final Query query = em.createNativeQuery(statement, type);
        // parametros 
        if (parameters != null) {
            for (int i = 0; i < parameters.length; i++) {
                query.setParameter(i + 1, parameters[i]);
            }
        }
        return query.getResultList();
    }

    /**
     * @param namedQuery
     * @param parameters
     * @return
     * @see ec.com.samasat.dao.IGenericDao#selectNamedQuery(java.lang.String,
     * java.util.Map)
     */
    @Override
    public List<T> selectNamedQuery(final String namedQuery, final Map<String, Object> parameters) {
        final Query query = em.createNamedQuery(namedQuery);
        if (parameters != null) {
            for (final String key : parameters.keySet()) {
                query.setParameter(key, parameters.get(key));

            }
        }
        return query.getResultList();
    }

    @Override
    public void flushQuery() {
        em.flush();
    }

}
