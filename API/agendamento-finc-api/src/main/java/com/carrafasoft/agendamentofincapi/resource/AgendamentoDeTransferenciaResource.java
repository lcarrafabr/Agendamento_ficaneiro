package com.carrafasoft.agendamentofincapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrafasoft.agendamentofincapi.model.AgendamentoDeTransferencia;
import com.carrafasoft.agendamentofincapi.repository.AgendamentoDeTransferenciaRepository;

@RestController
@RequestMapping("/")
public class AgendamentoDeTransferenciaResource {
	
	@Autowired
	private AgendamentoDeTransferenciaRepository agendamentoRepository;
	
	
	@GetMapping
	public List<AgendamentoDeTransferencia> listarAgendamentosTransferencia() {
		
		return agendamentoRepository.findAll();
	}
	
	public ResponseEntity<?> cadastrarAgendamentoTransferencia(@Valid @RequestBody AgendamentoDeTransferencia agendamentoTransf, HttpServletResponse response) {
		
		
		return null;
	}

}
