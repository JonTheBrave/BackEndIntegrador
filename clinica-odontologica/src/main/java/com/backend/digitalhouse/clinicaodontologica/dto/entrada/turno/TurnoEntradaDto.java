package com.backend.digitalhouse.clinicaodontologica.dto.entrada.turno;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoEntradaDto {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @FutureOrPresent(message = "La fecha no puede ser anterior al día de hoy")
    @NotNull(message = "Debe especificarse la fecha y hora del turno")
    private LocalDateTime fechaYhora;

    // Para registrar un turno solamente necesitamos un id de Paciente y un id de odontologo.
    @NotNull(message = "El odontologo no puede ser nulo")
    private int odontologoId; // únicamente necesitamos el id porque para registrar un turno no necesitamos todos los otros datos más que el id ( o sea que exista ese odontologo)

    @NotNull(message = "El paciente no puede ser nulo")
    private int pacienteId; //únicamente necesitamos el id porque para registrar un turno no necesitamos todos los otros datos más que el id ( o sea que exista ese paciente)

    public TurnoEntradaDto() {
    }

    public TurnoEntradaDto(LocalDateTime fechaYHora, int odontologoId, int pacienteId) {
        this.fechaYhora = fechaYHora;
        this.odontologoId = odontologoId;
        this.pacienteId = pacienteId;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYhora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYhora = fechaYHora;
    }

    public int getOdontologoId() {
        return odontologoId;
    }

    public void setOdontologoId(int odontologoId) {
        this.odontologoId = odontologoId;
    }

    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }
}
