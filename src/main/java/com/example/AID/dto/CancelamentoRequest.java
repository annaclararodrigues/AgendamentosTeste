package com.example.AID.dto;

import jakarta.validation.constraints.NotBlank;

public record CancelamentoRequest(
        @NotBlank(message = "O motivo do cancelamento não pode ser vazio")
        String motivo
) {
}
