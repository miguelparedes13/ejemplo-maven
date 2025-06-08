/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoloxa.catequesis.vistas;


import com.infoloxa.catequesis.model.Estudiantes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

/**
 *
 * @author anthoserv
 */
@Named("estudianteDM")
@ViewScoped
public class EstudianteDM implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Estudiantes> listaEstudiantes= new ArrayList<>();
    private Estudiantes estudiantes= new Estudiantes();
    private Boolean showDialogo;
    
    public List<Estudiantes> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(List<Estudiantes> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public Estudiantes getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Estudiantes estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Boolean getShowDialogo() {
        return showDialogo;
    }

    public void setShowDialogo(Boolean showDialogo) {
        this.showDialogo = showDialogo;
    }


}
