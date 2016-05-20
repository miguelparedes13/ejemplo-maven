/*
 * EntidadNoEncontradaException.java
 * 
 * Copyright (c) 2011 Fernando.
 * Todos los derechos reservados.
 */
package com.infoloxa.catequesis.excepciones;

import javax.ejb.ApplicationException;

/**
 * Class EntidadNoEncontradaException.
 *
 * @author Eduardo Proano
 * @revision $Revision: 1.1 $$
 */
@ApplicationException(rollback = true)
public class EntidadNoEncontradaException extends Exception {

    private static final long serialVersionUID = -7344949645441998453L;

    /**
     * Instancia un nuevo entidad no encontrada exception.
     */
    public EntidadNoEncontradaException() {
        super();
    }

    /**
     * Instancia un nuevo entidad no encontrada exception.
     *
     * @param arg0 the arg0
     * @param arg1 the arg1
     */
    public EntidadNoEncontradaException(final String arg0, final Throwable arg1) {
        super(arg0, arg1);
    }

    /**
     * Instancia un nuevo entidad no encontrada exception.
     *
     * @param arg0 the arg0
     */
    public EntidadNoEncontradaException(final String arg0) {
        super(arg0);
    }

    /**
     * Instancia un nuevo entidad no encontrada exception.
     *
     * @param arg0 the arg0
     */
    public EntidadNoEncontradaException(final Throwable arg0) {
        super(arg0);
    }
}
