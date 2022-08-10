package com.carrafasoft.agendamentofincapi.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.carrafasoft.agendamentofincapi.enums.TipoTransacaoEnum;

@Entity
@Table(name = "agendamento_transferencia")
public class AgendamentoDeTransferencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "agendamento_id")
	private Long agendamentoId;
	
	@NotNull
	@Column(name = "conta_origem")
	private String contaOrigem;
	
	@NotNull
	@Column(name = "conta_destino")
	private String contaDestino;
	
	@NotNull
	private BigDecimal valor;
	
	@NotNull
	@Column(name = "data_transferencia")
	private LocalDate dataTransferencia;
	
	@Column(name = "data_agendamento", updatable = false)
	private LocalDate dataAgendamento;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_transacao", length = 1)
	private TipoTransacaoEnum tipoTransacao;
	
	@Column(name = "valor_taxa")
	private BigDecimal valorTaxa;
	
	@Column(name = "percentual_taxa")
	private double percentualTaxa;

	public Long getAgendamentoId() {
		return agendamentoId;
	}

	public void setAgendamentoId(Long agendamentoId) {
		this.agendamentoId = agendamentoId;
	}

	public String getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public String getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getDataTransferencia() {
		return dataTransferencia;
	}

	public void setDataTransferencia(LocalDate dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public TipoTransacaoEnum getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(TipoTransacaoEnum tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public BigDecimal getValorTaxa() {
		return valorTaxa;
	}

	public void setValorTaxa(BigDecimal valorTaxa) {
		this.valorTaxa = valorTaxa;
	}

	public double getPercentualTaxa() {
		return percentualTaxa;
	}

	public void setPercentualTaxa(double percentualTaxa) {
		this.percentualTaxa = percentualTaxa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agendamentoId == null) ? 0 : agendamentoId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgendamentoDeTransferencia other = (AgendamentoDeTransferencia) obj;
		if (agendamentoId == null) {
			if (other.agendamentoId != null)
				return false;
		} else if (!agendamentoId.equals(other.agendamentoId))
			return false;
		return true;
	}
	
	
	@PrePersist
	public void dataAgendamento() {
		
		dataAgendamento = LocalDate.now(ZoneId.of("America/Sao_Paulo"));
	}

}
