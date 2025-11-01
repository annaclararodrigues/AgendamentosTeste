package com.example.AID.controller;

import com.example.AID.dto.AgendamentoResponse;
import com.example.AID.dto.CancelamentoRequest;
import com.example.AID.dto.CreateAgendamentoRequest;
import com.example.AID.dto.NotaRequest;
import com.example.AID.service.AgendamentoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/agendamentos")
@AllArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<AgendamentoResponse> create(@Valid  @RequestBody CreateAgendamentoRequest createAgendamentoRequest) {
        AgendamentoResponse agendamentoResponse = agendamentoService.createAgendamento(createAgendamentoRequest);
        return ResponseEntity.ok(agendamentoResponse);
    }


    @GetMapping
    public ResponseEntity<List<AgendamentoResponse>> listAgendamentos(@RequestParam String status) {
        List<AgendamentoResponse> agendamentos = agendamentoService.listAgendamentos(status);

        return ResponseEntity.ok(agendamentos);
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<AgendamentoResponse> cancel(
            @PathVariable UUID id,
            @Valid @RequestBody CancelamentoRequest request) {

        AgendamentoResponse response = agendamentoService.cancel(id, request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{id}/notas")
    public ResponseEntity<AgendamentoResponse> addNota(
            @PathVariable UUID id,
            @Valid @RequestBody NotaRequest request) {

        AgendamentoResponse response = agendamentoService.addNota(id, request);
        return ResponseEntity.ok(response);
    }



}
