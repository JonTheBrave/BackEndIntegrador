package com.backend.digitalhouse.clinicaodontologica;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@SpringBootApplication
@RestController
public class ClinicaOdontologicaApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClinicaOdontologicaApplication.class);

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		SpringApplication.run(ClinicaOdontologicaApplication.class, args);
		LOGGER.info("ClinicaOdontologicaApplication está ejecutándose...");
	}

	@Bean// para que luego Spring lo pueda identificar e inyectar adonde sea que se necesite. Puede ir a nivel clase (donde está el @RestController) a nivel atributo como método.
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}


}
