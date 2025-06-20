package model;

public class Filme {
    private int id;
    private String titulo;
    private String sinopse;
    private String genero;
    private int duracaoEmMinutos;

    public Filme(String titulo, String sinopse, String genero, int duracaoEmMinutos) {
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.genero = genero;
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public Filme(int id, String titulo, String sinopse, String genero, int duracaoEmMinutos) {
        this.id = id;
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.genero = genero;
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }
}