package model;

public class Sala {
    private int id;
    private int numero;
    private int capacidade;

    public Sala(int id, int numero, int capacidade) {
        this.id = id;
        this.numero = numero;
        this.capacidade = capacidade;
    }

    public Sala(int numero, int capacidade) {
        this.numero = numero;
        this.capacidade = capacidade;
    }

    public Sala(String idSala, String nomeSala, int capacidade) {
    }

    public Sala(int idSala, String nomeSala, int i) {
    }


    public int getId() {
        return id;
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
}