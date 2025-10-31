package com.example.AID.dto;

import com.example.AID.entity.Agendamento;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record AgendamentoResponse(
    UUID id,
    Agendamento.Status status,
    LocalDateTime dataCriacao,
    List<String> notas
) {
}
