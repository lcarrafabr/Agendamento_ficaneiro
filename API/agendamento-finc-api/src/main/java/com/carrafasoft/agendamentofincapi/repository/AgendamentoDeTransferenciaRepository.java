package com.carrafasoft.agendamentofincapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carrafasoft.agendamentofincapi.model.AgendamentoDeTransferencia;

@Repository
public interface AgendamentoDeTransferenciaRepository extends JpaRepository<AgendamentoDeTransferencia, Long> {

}
