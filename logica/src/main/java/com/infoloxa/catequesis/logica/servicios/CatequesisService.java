/*
 * CuentaService.java
 * 
 * Copyright (c) 2011 samasat.
 * Todos los derechos reservados.
 */
package com.infoloxa.catequesis.logica.servicios;


import com.infoloxa.catequesis.excepciones.EntidadNoGrabadaException;
import com.infoloxa.catequesis.model.Estudiantes;
import com.infoloxa.catequesis.model.Sacramentos;
import java.util.List;
import javax.ejb.Local;

/**
 * <p>
 * clase que permite realizar todo el proceso de facturación electronica del
 * SRI</p>
 *
 * @author anthoserv
 * @revision $Revision: $
 */
@Local
public interface CatequesisService {
/**
 * 
 * @param sacramentos
 * @throws EntidadNoGrabadaException 
 */
 void guardarSacramentos(Sacramentos sacramentos) throws EntidadNoGrabadaException;
/**
 * 
 * @param estudiantes
 * @throws EntidadNoGrabadaException 
 */
 void guardarEstudiantes(Estudiantes estudiantes) throws EntidadNoGrabadaException;

    public List<Estudiantes> ontenerEstudiantes();

}
