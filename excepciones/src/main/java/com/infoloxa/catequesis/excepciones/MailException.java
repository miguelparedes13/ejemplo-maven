/*
 * NotificacionException.java
 * 
 * Copyright (c) 2011 Fernando.
 * Todos los derechos reservados.
 */
package com.infoloxa.catequesis.excepciones;

/**
 * Class MailException.
 *
 * @author Eduardo Proano
 * @revision $Revision: 1.1 $$
 */
public class MailException extends Exception {

    private static final long serialVersionUID = -4358123656518484876L;

    /**
     * Instancia una mail exception.
     */
    public MailException() {
        super();
    }

    /**
     * Instancia una mail exception.
     *
     * @param arg0 the arg0
     * @param arg1 the arg1
     */
    public MailException(final String arg0, final Throwable arg1) {
        super(arg0, arg1);
    }

    /**
     * Instancia una mail exception.
     *
     * @param arg0 the arg0
     */
    public MailException(final String arg0) {
        super(arg0);
    }

    /**
     * Instancia una mail exception.
     *
     * @param arg0 the arg0
     */
    public MailException(final Throwable arg0) {
        super(arg0);
    }
}
