package model;

import java.time.LocalDateTime;

public class Venda {
    private int id;
    private Sessao sessao;
    private Usuario usuario;
    private int quantidadeIngressos;
    private double valorTotal;
    private LocalDateTime dataVenda;

    public Venda(int id, Sessao sessao, Usuario usuario, int quantidadeIngressos, double valorTotal, LocalDateTime dataVenda) {
        this.id = id;
        this.sessao = sessao;
        this.usuario = usuario;
        this.quantidadeIngressos = quantidadeIngressos;
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
    }

    public Venda(Sessao sessao, Usuario usuario, int quantidadeIngressos, double valorTotal) {
        this.sessao = sessao;
        this.usuario = usuario;
        this.quantidadeIngressos = quantidadeIngressos;
        this.valorTotal = valorTotal;
        this.dataVenda = LocalDateTime.now(); // Data atual automática
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getQuantidadeIngressos() {
        return quantidadeIngressos;
    }

    public void setQuantidadeIngressos(int quantidadeIngressos) {
        this.quantidadeIngressos = quantidadeIngressos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }
}