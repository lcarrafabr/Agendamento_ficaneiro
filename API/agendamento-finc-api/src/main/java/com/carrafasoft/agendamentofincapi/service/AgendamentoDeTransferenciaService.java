package com.carrafasoft.agendamentofincapi.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.carrafasoft.agendamentofincapi.enums.TipoTransacaoEnum;
import com.carrafasoft.agendamentofincapi.event.RecursoCriadoEvent;
import com.carrafasoft.agendamentofincapi.model.AgendamentoDeTransferencia;
import com.carrafasoft.agendamentofincapi.repository.AgendamentoDeTransferenciaRepository;

@Service
public class AgendamentoDeTransferenciaService {
	
	@Autowired
	private AgendamentoDeTransferenciaRepository agendamentoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	
	public ResponseEntity<?> cadastrarAgendamentoTransferencia(AgendamentoDeTransferencia agendamentoTransf, HttpServletResponse response) {
		
		ResponseEntity<AgendamentoDeTransferencia> httpStatus = new ResponseEntity<AgendamentoDeTransferencia>(HttpStatus.METHOD_NOT_ALLOWED);
		
		ResponseEntity<String> httpStatus2 = ResponseEntity.notFound().build();
		
		long qtdDias = calculaDataAtualXDataTransferencia(agendamentoTransf);
		TipoTransacaoEnum tipoTransacao = getTipoTransacao(agendamentoTransf.getValor());
		
		System.out.println(qtdDias);
		
		BigDecimal valorTaxa = calculaTaxa(tipoTransacao.toString(), qtdDias, agendamentoTransf.getValor(), agendamentoTransf);
		
		if (qtdDias < 0L) { 
			
			return httpStatus2 = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A data de agendamento não pode ser anterior a data de hoje.");
			
		}
		
		if(valorTaxa == null) {
			 return httpStatus2 = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não existe taxa aplicável");
		} else{
			
			
			agendamentoTransf.setTipoTransacao(tipoTransacao);
			agendamentoTransf.setValorTaxa(valorTaxa);
			
			AgendamentoDeTransferencia agendamentoSalvo = agendamentoRepository.save(agendamentoTransf);
			publisher.publishEvent(new RecursoCriadoEvent(this, response, agendamentoSalvo.getAgendamentoId()));
			
			httpStatus = ResponseEntity.status(HttpStatus.CREATED).body(agendamentoSalvo);
		}
		
		return httpStatus;
		
	}
	
	
	private long calculaDataAtualXDataTransferencia(AgendamentoDeTransferencia agendamentoTransf) {
		
		
		LocalDate dataAtual = LocalDate.now(ZoneId.of("America/Sao_Paulo"));
		
		LocalDate dataTrasferencia = agendamentoTransf.getDataTransferencia();
		
		int isEqual = dataTrasferencia.compareTo(dataAtual);
		long dias = 0;
		
		if(isEqual == 0) {
			
			dias = 0;
		} else if (isEqual < 0) {
			
			dias = -1;
		} else if(isEqual > 0) {

			dias = ChronoUnit.DAYS.between(dataAtual, dataTrasferencia);
			
		}
		
		return dias;
	}
	
	
	private BigDecimal calculaTaxa(String tipoTransacao, long qtdDias, BigDecimal valor, AgendamentoDeTransferencia agend) {
		
		BigDecimal percentual  = BigDecimal.valueOf(0);
		BigDecimal valorPercentualTaxa = null; //percentualda taxa do valor a ser transferido
		
		switch (tipoTransacao) {
		case "A":
			
			if(qtdDias == 0) {
				percentual = BigDecimal.valueOf(0.03);
				valorPercentualTaxa = valor.multiply(percentual).add(new BigDecimal("3"));
				agend.setPercentualTaxa(percentual.doubleValue() * 100);
			} 
			break;
			
		case "B":
			
			if(qtdDias > 0 && qtdDias <= 10) {
				
				valorPercentualTaxa = new BigDecimal("12");
				agend.setPercentualTaxa(0);
			}
			break;
			
		case "C":
			
				if(qtdDias > 10) {
					percentual = BigDecimal.valueOf(0.082);
					valorPercentualTaxa = valor.multiply(percentual);
					agend.setPercentualTaxa(percentual.doubleValue() * 100);
				}
				
				
				if(qtdDias > 20) {
					percentual = BigDecimal.valueOf(0.069);
					valorPercentualTaxa = valor.multiply(percentual);
					agend.setPercentualTaxa(percentual.doubleValue() * 100);
				}
				
				if(qtdDias > 30) {
					percentual = BigDecimal.valueOf(0.047);
					valorPercentualTaxa = valor.multiply(percentual);
					agend.setPercentualTaxa(percentual.doubleValue() * 100);
				}
				
				if(qtdDias > 40) {
					percentual = BigDecimal.valueOf(0.017);
					valorPercentualTaxa = valor.multiply(percentual);
					agend.setPercentualTaxa(percentual.doubleValue() * 100);
				}
			
			break;

		default:
			break;
		}
		
		return valorPercentualTaxa;
		
		
	}


	private TipoTransacaoEnum getTipoTransacao(BigDecimal valor) {
		
		TipoTransacaoEnum tipoTransacao = null;
		
		if(valor.compareTo(new BigDecimal("1000.00")) <= 0) {
			
			tipoTransacao = TipoTransacaoEnum.A;
		}
		
		if(valor.compareTo(new BigDecimal("1001.00")) >= 0 && valor.compareTo(new BigDecimal("2000.00")) <= 0) {
			
			tipoTransacao = TipoTransacaoEnum.B;
		}
		
		if(valor.compareTo(new BigDecimal("2001.00")) >= 0) {
			
			tipoTransacao = TipoTransacaoEnum.C;
		}
		
		
		
		return tipoTransacao;
	}


	
	
	

}
