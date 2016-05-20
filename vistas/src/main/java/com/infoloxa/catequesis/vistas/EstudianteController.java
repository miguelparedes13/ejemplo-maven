/*
 * TestController.java
 * 
 * Copyright (c) 2011 polimundo.
 * Todos los derechos reservados.
 */
package com.infoloxa.catequesis.vistas;


import com.infoloxa.catequesis.excepciones.EntidadNoGrabadaException;
import com.infoloxa.catequesis.logica.servicios.CatequesisService;
import com.infoloxa.catequesis.logica.servicios.Imp.CatequesisServiceImpl;
import com.infoloxa.catequesis.model.Estudiantes;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

/**
 * Controlador de vista Administración de activos fijos
 *
 * @author Miguel Paredes
 * @revision $Revision: $
 */
@ManagedBean(name = "estudianteController")
@ViewScoped
public class EstudianteController implements Serializable {
    private static final long serialVersionUID = 2894565334915564100L;

    @ManagedProperty(value = "#{estudianteDM}")
    private EstudianteDM estudianteDM;

    @EJB(lookup = "java:global/logica-1.0/CatequesisServiceImpl!com.infoloxa.catequesis.logica.servicios.CatequesisService")
    CatequesisService catequesisServicio;
    
    public void inform(){
        List<Estudiantes> ontenerEstudiantes = catequesisServicio.ontenerEstudiantes();
        estudianteDM.setListaEstudiantes(ontenerEstudiantes);
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
