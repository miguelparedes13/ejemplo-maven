/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoloxa.catequesis.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author anthoserv
 */
@Entity
@Table(name = "estudiantes", schema = "catequesis")
public class Estudiantes implements Serializable {

    private static final long serialVersionUID = 6562957240824382775L;
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;
    ///
    @Column(name = "cedula", length = 13)
    private String cedula;
    @NotNull(message = "campo es obligatorio")
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "curso")
    private Integer curso;
    @Column(name = "paralelo")
    private Character paralelo;
    //
    @JoinColumn(name = "id_sacramento", referencedColumnName = "id")
    @ManyToOne
    private Sacramentos estudianteSacramento;

    //
    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getCurso() {
        return curso;
    }

    public void setCurso(Integer curso) {
        this.curso = curso;
    }

    public Character getParalelo() {
        return paralelo;
    }

    public void setParalelo(Character paralelo) {
        this.paralelo = paralelo;
    }

    public Sacramentos getEstudianteSacramento() {
        return estudianteSacramento;
    }

    public void setEstudianteSacramento(Sacramentos estudianteSacramento) {
        this.estudianteSacramento = estudianteSacramento;
    }

}
