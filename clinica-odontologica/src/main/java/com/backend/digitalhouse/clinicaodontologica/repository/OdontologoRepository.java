package com.backend.digitalhouse.clinicaodontologica.repository;

import com.backend.digitalhouse.clinicaodontologica.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//no es necesaria Ya la infiere, es igual que el autowire
public interface OdontologoRepository extends JpaRepository<Odontologo, Integer> {
}
