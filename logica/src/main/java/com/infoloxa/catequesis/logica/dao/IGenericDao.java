/*
 * IGenericDao.java
 * 
 * Copyright (c) 2011 Fernando.
 * Todos los derechos reservados.
 */
package com.infoloxa.catequesis.logica.dao;



import com.infoloxa.catequesis.excepciones.EntidadNoBorradaException;
import com.infoloxa.catequesis.excepciones.EntidadNoEncontradaException;
import com.infoloxa.catequesis.excepciones.EntidadNoGrabadaException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

/**
 * Interface IGenericDao.
 *
 * @param <T> the generic type
 * @param <PK> the generic id type
 * @author Eduardo Proano
 * @revision $Revision: 1.1 $$
 */
@Local
public interface IGenericDao<T, PK extends Serializable> {

    /**
     * Guardar un objeto en la base de datos.
     *
     * @param o the o
     * @throws com.infoloxa.catequesis.excepciones.EntidadNoGrabadaException
     
     *
     */
    void crear(T o) throws EntidadNoGrabadaException;

    /**
     * Obtener un objeto almacenado utilizando su llave primaria.
     *
     * @param id llave primaria.
     *
     * @return the T
     * @throws com.infoloxa.catequesis.excepciones.EntidadNoEncontradaException
     
     */
    T recuperar(PK id) throws EntidadNoEncontradaException;

    /**
     * Almacenar los cambios hechos a un objeto.
     *
     * @param o the o
     * @throws com.infoloxa.catequesis.excepciones.EntidadNoGrabadaException
    
     *
     */
    void actualizar(T o) throws EntidadNoGrabadaException;

    /**
     * Eliminar un objeto de la base de datos.
     *
     * @param o the o
     * @throws com.infoloxa.catequesis.excepciones.EntidadNoBorradaException
     * 
     *
     */
    void eliminar(T o) throws EntidadNoBorradaException;

    /**
     * Refresca un objeto de la base de datos.
     *
     * @param o the o
     */
    void refrescar(T o);

    /**
     * Contar todas las entidades.
     *
     * @return the long
     */
    Long contar();

    /**
     * Encuentra una pagina de datos en la base.
     *
     * @param firstRow the first row
     * @param maxResults the max results
     * @param id
     *
     * @return the list< t>
     */
    List<T> encontrarPagina(final Integer firstRow, final Integer maxResults, final String id);

    /**
     *
     * /**
     * Busca de acuerdo a una consulta y lista de parametros.
     *
     * @param sql the sql
     * @param parametros the parametros
     *
     * @return the list< t>
     */
    List<T> encontrarPorQuery(String sql, Map<String, Object> parametros);

    List<T> selectNamedQuery(String namedQuery, Map<String, Object> parameters);

    void flushQuery();

    List<T> findRange(int[] range);

    public List<T> findAll();

}
