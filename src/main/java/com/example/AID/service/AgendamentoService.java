package com.example.AID.service;

import com.example.AID.dto.AgendamentoResponse;
import com.example.AID.dto.CancelamentoRequest;
import com.example.AID.dto.CreateAgendamentoRequest;
import com.example.AID.dto.NotaRequest;
import com.example.AID.entity.Agendamento;
import com.example.AID.exception.AgendamentoCancelException;
import com.example.AID.exception.AgendamentoNotFound;
import com.example.AID.exception.DataInvalidaException;
import com.example.AID.mapper.AgendamentoMapper;
import com.example.AID.repository.AgendamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final AgendamentoMapper agendamentoMapper;

    public AgendamentoResponse createAgendamento(CreateAgendamentoRequest createAgendamentoRequest){
        Agendamento agendamento = agendamentoMapper.toAgendamento(createAgendamentoRequest);

        if (createAgendamentoRequest.fim().isBefore(createAgendamentoRequest.inicio()) || createAgendamentoRequest.fim().isEqual(createAgendamentoRequest.inicio())) {
            throw new DataInvalidaException("A data de fim deve ser posterior à data de início");
        }

        agendamentoRepository.save(agendamento);
        return agendamentoMapper.toDto(agendamento);
    }

    public List<AgendamentoResponse> listAgendamentos(String status){
        List<Agendamento> agendamentos = agendamentoRepository.getAllAgendamentos();

        List<AgendamentoResponse> finalAgendamentos = agendamentos.stream()
                .filter(agendamento -> agendamento.getStatus().name().equalsIgnoreCase(status))
                .map(agendamentoMapper :: toDto)
                .collect(Collectors.toList());

        return finalAgendamentos;
    }

    public AgendamentoResponse cancel(UUID id, CancelamentoRequest request) {
        Agendamento agendamento = findAgendamentoById(id);

        if (agendamento.getInicio().isBefore(LocalDateTime.now())) {
            throw new AgendamentoCancelException("Não é possível cancelar agendamentos que já ocorreram.");
        }

        agendamento.setStatus(Agendamento.Status.CANCELADO);
        agendamento.getNotas().add("Cancelado: " + request.motivo());

        agendamentoRepository.save(agendamento);
        return agendamentoMapper.toDto(agendamento);
    }


    public AgendamentoResponse addNota(UUID id, NotaRequest request) {
        Agendamento agendamento = findAgendamentoById(id);

        agendamento.getNotas().add(request.nota());

        agendamentoRepository.save(agendamento);
        return agendamentoMapper.toDto(agendamento);
    }

    private Agendamento findAgendamentoById(UUID id) {
        Agendamento agendamento = agendamentoRepository.findById(id);

        if (agendamento == null) {
            throw new AgendamentoNotFound("Agendamento não encontrado com o ID: " + id);
        }
        return agendamento;
    }
}
