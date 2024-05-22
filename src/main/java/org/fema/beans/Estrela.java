package org.fema.beans;

public class Estrela {
    private int cod;
    private EstrelaTipo tipo;
    private String nome;
    private Galaxia galaxia;

    public Estrela() {

    }

    public Estrela(int cod, String nome, EstrelaTipo tipo, Galaxia galaxia) {
        this.cod = cod;
        this.tipo = tipo;
        this.nome = nome;
        this.galaxia = galaxia;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public EstrelaTipo getTipo() {
        return tipo;
    }

    public void setTipo(EstrelaTipo tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Galaxia getGalaxia() {
        return galaxia;
    }

    public void setGalaxia(Galaxia galaxia) {
        this.galaxia = galaxia;
    }
}
