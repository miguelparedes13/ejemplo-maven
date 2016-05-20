/*
 * EntidadNoBorradaException.java
 * 
 * Copyright (c) 2011 Fernando.
 * Todos los derechos reservados.
 */
package com.infoloxa.catequesis.excepciones;

import javax.ejb.ApplicationException;

/**
 * Class EntidadNoBorradaException.
 *
 * @author Eduardo Proano
 * @revision $Revision: 1.1 $$
 */
@ApplicationException(rollback = true)
public class EntidadNoBorradaException extends Exception {

    private static final long serialVersionUID = -2833270434701111945L;

    /**
     * Instancia un nuevo entidad no borrada exception.
     */
    public EntidadNoBorradaException() {
        super();
    }

    /**
     * Instancia un nuevo entidad no borrada exception.
     *
     * @param arg0 the arg0
     * @param arg1 the arg1
     */
    public EntidadNoBorradaException(final String arg0, final Throwable arg1) {
        super(arg0, arg1);
    }

    /**
     * Instancia un nuevo entidad no borrada exception.
     *
     * @param arg0 the arg0
     */
    public EntidadNoBorradaException(final String arg0) {
        super(arg0);
    }

    /**
     * Instancia un nuevo entidad no borrada exception.
     *
     * @param arg0 the arg0
     */
    public EntidadNoBorradaException(final Throwable arg0) {
        super(arg0);
    }
}
