package com.example.AID.repository;

import com.example.AID.entity.Agendamento;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class AgendamentoRepository {

    private Map<UUID, Agendamento> agendamentos = new HashMap<>();

    public void save(Agendamento agendamento){
        agendamentos.put(agendamento.getId(), agendamento);
    }

    public List<Agendamento> getAllAgendamentos(){
        return agendamentos.values().stream().toList();
    }

    public Agendamento findById(UUID id) {
        return agendamentos.get(id);
    }
}
