package com.example.AID.mapper;

import com.example.AID.dto.AgendamentoResponse;
import com.example.AID.dto.CreateAgendamentoRequest;
import com.example.AID.entity.Agendamento;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class AgendamentoMapper {

    public Agendamento toAgendamento(CreateAgendamentoRequest createAgendamentoRequest){
        Agendamento agendamento = new Agendamento();
        agendamento.setPacienteCpf(createAgendamentoRequest.pacienteCpf());
        agendamento.setMedicoCrm(createAgendamentoRequest.medicoCrm());
        agendamento.setEspecialidade(createAgendamentoRequest.especialidade());
        agendamento.setInicio(createAgendamentoRequest.inicio());
        agendamento.setFim(createAgendamentoRequest.fim());

        if(createAgendamentoRequest.notas()!=null)
            agendamento.setNotas(createAgendamentoRequest.notas());

        return agendamento;
    }

    public AgendamentoResponse toDto(Agendamento agendamento){
        AgendamentoResponse agendamentoResponse = new AgendamentoResponse(
                agendamento.getId(),
                agendamento.getPacienteCpf(),
                agendamento.getMedicoCrm(),
                agendamento.getEspecialidade(),
                agendamento.getInicio(),
                agendamento.getFim(),
                agendamento.getStatus(),
                agendamento.getDataCriacao(),
                agendamento.getNotas()
        );

        return agendamentoResponse;
    }

}
