package com.example.AID.dto;

import jakarta.validation.constraints.NotBlank;

public record NotaRequest(
        @NotBlank(message = "A nota não pode ser vazia")
        String nota

) {
}
