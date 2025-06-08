/*
 * TestController.java
 * 
 * Copyright (c) 2011 polimundo.
 * Todos los derechos reservados.
 */
package com.infoloxa.catequesis.vistas;


import com.infoloxa.catequesis.excepciones.EntidadNoGrabadaException;
import com.infoloxa.catequesis.logica.servicios.CatequesisService;
import com.infoloxa.catequesis.model.Estudiantes;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.context.FacesContext;

/**
 * Controlador de vista Administración de activos fijos
 *
 * @author Miguel Paredes
 * @revision $Revision: $
 */
@Named("estudianteController")
@ViewScoped
public class EstudianteController implements Serializable {
    private static final long serialVersionUID = 2894565334915564100L;

    @Inject
    private EstudianteDM estudianteDM;

    @Inject
    CatequesisService catequesisServicio;
    
    public void inform(){
        List<Estudiantes> listaEstudiantes = catequesisServicio.obtenerEstudiantes();
        estudianteDM.setListaEstudiantes(listaEstudiantes);
    }

    public void nuevo(){
        estudianteDM.setEstudiantes(new Estudiantes());
          estudianteDM.setShowDialogo(Boolean.TRUE);
    }
    
    public void cancelar(){
        estudianteDM.setShowDialogo(Boolean.FALSE);
    }
    
    public void guardarEstudiante(){
        try {
            catequesisServicio.guardarEstudiantes(estudianteDM.getEstudiantes());
            addInfoMessage("El registro se guardo correctamente");
            inform();
            cancelar();
        } catch (EntidadNoGrabadaException ex) {
            Logger.getLogger(EstudianteController.class.getName()).log(Level.SEVERE, null, ex);
            addErrorMessage(ex.getMessage());
        }
    }
    
    public void seleccionar(Estudiantes estudiantes){
        estudianteDM.setEstudiantes(estudiantes);
        estudianteDM.setShowDialogo(Boolean.TRUE);
    }
    
     protected void addErrorMessage(final String resumen) {
        FacesMessage message = new FacesMessage(resumen);
        message.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, message);
        
    }
    
    protected void addInfoMessage(final String resumen) {
        FacesMessage message = new FacesMessage(resumen);
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public EstudianteDM getEstudianteDM() {
        return estudianteDM;
    }

    public void setEstudianteDM(EstudianteDM estudianteDM) {
        this.estudianteDM = estudianteDM;
    }
    
    
    
  

}
