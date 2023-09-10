package com.backend.digitalhouse.clinicaodontologica.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="PACIENTES")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 50)
    private String nombre;
    @Column(nullable = false, length = 50)
    private String apellido;
    @Column(nullable = false)
    //ojo que int no puede ser nulo (porque es un dato primitivo) , para hacerlo nulo hay que especificar con el @Column(nullable = true)
    private int dni;
    @Column(name = "INGRESO_PACIENTE", nullable = false, length = 15)
    private LocalDate fechaIngreso;
    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE) //.LAZY es para cuando se peticione una dato en particular recién ahí se cargue esos datos con respecto a la relación
                                                                                          //.REMOVE es para cuando deje de existir por ej en este caso un Paciente también se borre sus turnos asociados
    private List<Turno> turnos =new ArrayList<>();//Deberíamos agregar al constructor?  get y set ?

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn (name = "domcilio_id")
    private Domicilio domicilio;


    public Paciente(String nombre, String apellido, int dni, LocalDate fechaIngreso, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    public Paciente() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }


    @Override
    public String toString() {
        return "\n🧑🏻Paciente{" +
                "id: " + id +
                ", apellido: " + apellido +
                ", nombre: " + nombre +
                ", dni: " + dni +
                ", fechaIngreso: " + fechaIngreso +
                ", domicilio: " + domicilio;
    }
}


