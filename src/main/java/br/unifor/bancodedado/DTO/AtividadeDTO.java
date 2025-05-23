package br.unifor.bancodedado.DTO;

import java.time.LocalTime;
import java.time.DayOfWeek;
import java.util.List;

public class AtividadeDTO {
    public String nome;
    public List<DayOfWeek> diasDaSemana;
    public LocalTime horaInicio;
    public LocalTime horaFim;
    public boolean recorrente;
    public String duracaoRecorrencia;
    public Long responsavelId; // Pode ser null
}