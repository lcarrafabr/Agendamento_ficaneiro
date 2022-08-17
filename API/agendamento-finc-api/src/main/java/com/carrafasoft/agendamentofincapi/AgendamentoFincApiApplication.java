package com.carrafasoft.agendamentofincapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.carrafasoft.agendamentofincapi.config.AgendamentoTransfApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(AgendamentoTransfApiProperty.class)
public class AgendamentoFincApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendamentoFincApiApplication.class, args);
	}

}
