package com.example.AID.entity;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Agendamento {

    private UUID id = UUID.randomUUID();
    private String pacienteCpf;
    private String medicoCrm;
    private String especialidade;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private Status status = Status.AGENDADO;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private List<String> notas = new ArrayList<>();


    public enum Status{
        AGENDADO,
        CANCELADO
    }



}
