package model;

import java.time.LocalDateTime;

public class Sessao {
    private int id;
    private LocalDateTime horario;
    private Filme filme;
    private Sala sala;
    private int lugaresDisponiveis;

    public Sessao(int id, LocalDateTime horario, Filme filme, Sala sala, int lugaresDisponiveis) {
        this.id = id;
        this.horario = horario;
        this.filme = filme;
        this.sala = sala;
        this.lugaresDisponiveis = lugaresDisponiveis;
    }

    public Sessao(LocalDateTime horario, Filme filme, Sala sala, int lugaresDisponiveis) {
        this.horario = horario;
        this.filme = filme;
        this.sala = sala;
        this.lugaresDisponiveis = lugaresDisponiveis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public int getLugaresDisponiveis() {
        return lugaresDisponiveis;
    }

    public void setLugaresDisponiveis(int lugaresDisponiveis) {
        this.lugaresDisponiveis = lugaresDisponiveis;
    }
}