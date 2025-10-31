package com.example.AID.dto;

import com.example.AID.entity.Agendamento;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record AgendamentoResponse(
    UUID id,
    String pacienteCpf,
    String medicoCrm,
    String especialidade,
    LocalDateTime inicio,
    LocalDateTime fim,
    Agendamento.Status status,
    LocalDateTime dataCriacao,
    List<String> notas
) {
}
