/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoloxa.catequesis.logica.servicios.Imp;

import com.infoloxa.catequesis.excepciones.EntidadNoEncontradaException;
import com.infoloxa.catequesis.excepciones.EntidadNoGrabadaException;
import com.infoloxa.catequesis.logica.dao.EstudianteDao;
import com.infoloxa.catequesis.logica.dao.SacramentoDao;
import com.infoloxa.catequesis.logica.servicios.CatequesisService;
import com.infoloxa.catequesis.model.Estudiantes;
import com.infoloxa.catequesis.model.Sacramentos;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Clase que permite realizar todo el proceso de facturación electtrónica
 *
 * @author anthoserv
 */
@ApplicationScoped
public class CatequesisServiceImpl implements CatequesisService {

    @Inject
    private EstudianteDao estudiantesDao;
    @Inject
    private SacramentoDao sacramentoDao;
    
    @Override
    public void guardarSacramentos(Sacramentos sacramentos) throws EntidadNoGrabadaException {
         if(sacramentos.getCodigo()==null){
            throw new EntidadNoGrabadaException("El código es obligatorio");
        }
        if(sacramentos.getNombre()==null){
            throw new EntidadNoGrabadaException("El nombre es obligatorio");
        }
        if (sacramentos.getId() == null) {
            sacramentoDao.crear(sacramentos);
        } else {
            sacramentoDao.actualizar(sacramentos);
        }        
    }
    /**
     * 
     * @param estudiantes
     * @throws EntidadNoGrabadaException 
     */
    @Override
    public void guardarEstudiantes(Estudiantes estudiantes) throws EntidadNoGrabadaException {
        if(estudiantes.getCedula()==null){
            throw new EntidadNoGrabadaException("La cédula es obligatorio");
        }
        if(estudiantes.getApellidos()==null){
            throw new EntidadNoGrabadaException("El apellido es obligatorio");
        }
        if(estudiantes.getNombres()==null){
            throw new EntidadNoGrabadaException("El nombre es obligatorio");
        }
        if (estudiantes.getId() == null) {
            estudiantesDao.crear(estudiantes);
        } else {
            estudiantesDao.actualizar(estudiantes);
            
        }
    }
    /**
     * 
     * @return 
     */
    public List<Sacramentos> obtenerSacramentos(){
      return sacramentoDao.findAll();
    }
    
    /**
     * 
     * @param cedula
     * @return
     * @throws EntidadNoEncontradaException 
     */
    public Estudiantes obtenerEstudiantePorCedula(String cedula) throws EntidadNoEncontradaException{
        List<Estudiantes> obtenerEstudiantesCedula = estudiantesDao.obtenerEstudiantesCedula(cedula);
    if(obtenerEstudiantesCedula.isEmpty()){
        throw new EntidadNoEncontradaException("Estudiante no encontrado");
    }
    return obtenerEstudiantesCedula.get(0);
    }
    /**
     * 
     * @return 
     */
    public List<Estudiantes> ontenerEstudiantes(){
        return estudiantesDao.findAll();
    }
}
