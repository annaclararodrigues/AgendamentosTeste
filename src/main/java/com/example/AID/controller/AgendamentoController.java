package com.example.AID.controller;

import com.example.AID.dto.AgendamentoResponse;
import com.example.AID.dto.CreateAgendamentoRequest;
import com.example.AID.service.AgendamentoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


}
