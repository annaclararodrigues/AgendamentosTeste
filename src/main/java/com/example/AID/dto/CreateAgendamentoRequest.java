package com.example.AID.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;

public record CreateAgendamentoRequest(
    @NotBlank(message = "CPF do paciente é obrigatório")
    @Size(min = 11, max = 11, message = "CPF deve ter 11 dígitos")
    String pacienteCpf,

    @NotBlank(message = "CRM do médico é obrigatório")
    String medicoCrm,

    @NotBlank(message = "Especialidade é obrigatória")
    String especialidade,

    @NotNull(message = "Data de início é obrigatória")
    @Future(message = "Data de início deve ser no futuro")
    LocalDateTime inicio,

    @NotNull(message = "Data de fim é obrigatória")
    LocalDateTime fim,

    List<String> notas
) {
}
