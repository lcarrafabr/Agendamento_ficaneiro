package com.carrafasoft.agendamentofincapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrafasoft.agendamentofincapi.model.AgendamentoDeTransferencia;
import com.carrafasoft.agendamentofincapi.repository.AgendamentoDeTransferenciaRepository;
import com.carrafasoft.agendamentofincapi.service.AgendamentoDeTransferenciaService;

@RestController
@RequestMapping("/")
public class AgendamentoDeTransferenciaResource {
	
	@Autowired
	private AgendamentoDeTransferenciaRepository agendamentoRepository;
	
	@Autowired
	private AgendamentoDeTransferenciaService agendamentoService;
	
	
	@GetMapping
	public List<AgendamentoDeTransferencia> listarAgendamentosTransferencia() {
		
		return agendamentoRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrarAgendamentoTransferencia(@Valid @RequestBody AgendamentoDeTransferencia agendamentoTransf, HttpServletResponse response) {
		
		ResponseEntity<?> retornoResponse = null;
		retornoResponse = agendamentoService.cadastrarAgendamentoTransferencia(agendamentoTransf, response);
		
		return retornoResponse;
	}

}
